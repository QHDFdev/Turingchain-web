package com.tulingchain.service.impl.bill;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.DiscountMapper;
import com.tulingchain.mapper.billMapper.PayrollMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Discount;
import com.tulingchain.model.bill.Payroll;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.DiscountService;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.SpringUtils;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	BillNoderMapper billNoderMapper;
	
	@Autowired
	DiscountMapper discountMapper;
		
	@Override
	public String save(Discount discount) {
		int payerId=billNoderMapper.getNoderByComName(discount.getDiscountingOrgNoder().getCompanyName()).getId();;
		int payeeId=billNoderMapper.getNoderByComName(discount.getPayeeNoder().getCompanyName()).getId();
		int discoutingOrgId=billNoderMapper.getNoderByComName(discount.getDiscountingOrgNoder().getCompanyName()).getId();
		String payer=RestUtils.ChineseToUnicode(discount.getDiscountingOrgNoder().getCompanyName());
		String payee=RestUtils.ChineseToUnicode(discount.getPayeeNoder().getCompanyName());
		String discountingOrg=RestUtils.ChineseToUnicode(discount.getDiscountingOrgNoder().getCompanyName());
		String billNumber=discount.getBillNumber();
		int moneySum=discount.getMoneySum();
		String expireDate=discount.getExpireDate().toString();
		
		discount.setDiscountName(payerId);
		discount.setPayee(payeeId);
		discount.setDiscountingOrg(discoutingOrgId);
		//--------------
		String noderPubkey=billNoderMapper.getNoderPubKeySer(payerId)==null?null:billNoderMapper.getNoderPubKeySer(payerId);
		String noderPriKey=billNoderMapper.getNoderPriKeySer(payerId)==null?null:billNoderMapper.getNoderPriKeySer(payerId);
		String receivePubKey=billNoderMapper.getNoderPubKeySer(payeeId)==null?null:billNoderMapper.getNoderPubKeySer(payerId);
		String receivePriKey=billNoderMapper.getNoderPriKeySer(payeeId)==null?null:billNoderMapper.getNoderPriKeySer(payerId);
		
		JSONObject bill=RestUtils.generateBill("贴现",2,payer,payerId,billNumber,payee,payeeId,"RMB",moneySum,discountingOrg,discoutingOrgId,expireDate,
				discountingOrg,null,null);
		int re=discountMapper.save(discount);
		//------------------
		Runnable discountPayroll=new QuietDiscount(discount.getDiscountNoder().getCompanyName(),noderPubkey,noderPriKey,discount.getPayeeNoder().getCompanyName(),receivePubKey,receivePriKey,bill,re);
		Thread thread=new Thread(discountPayroll);
		thread.start();
		//--------------------
		return JsonUtils.returnState(1, null);
	}

	@Override
	public List<Discount> listAll(int id) {
		List<Discount> list=discountMapper.listAll(id);
		return list;
	}

}
class QuietDiscount implements Runnable {


	//通过Spring的ApplicationContext获得Bean,从而解决Spring不会在新线程中注入实例
	private DiscountMapper discountMapper=(DiscountMapper) SpringUtils.getBeanByClass(DiscountMapper.class);
	private BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);
	 
	
	private String noderPubkey;
	private String noderPriKey;
	private String receivePubkey;
	private String receivePrikey;
	private String signername;
	private String payeename;
	private JSONObject bill;
	private int discount_id;
	private boolean flag=true;

	
	public QuietDiscount(){}
	public QuietDiscount(String signername,String noderPubkey,String noderPriKey,String payeename,String receivePubkey,String receivePrikey,JSONObject bill,int discount_id) {
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
		this.receivePubkey=receivePubkey;
		this.receivePrikey=receivePrikey;
		this.signername=signername;
		this.payeename=payeename;
		this.discount_id=discount_id;
		this.bill=bill;
	}

	@Override
	public void run() {
	
		ReadClient client=null;
		try {
			client = new ReadClient();
		} catch (IOException e1) {
		}
		
		JSONObject create=null;
		try {
			create = RestWriteClient.createBillTransaction(noderPubkey,noderPriKey,bill);
		} catch (IOException e2) {
		}                          
		if(noderPubkey==null && noderPriKey==null ){
			noderPubkey=create.getString("receive_pubk");
			noderPriKey=create.getString("receive_prik");
			BillNoder billNoder=new BillNoder();
			billNoder.setCompanyName(signername);
			billNoder.setNodePubKey(noderPubkey);
			billNoder.setNodePrivateKey(noderPriKey);
			System.out.println("====="+billNoder);
			billNoderMapper.updatePubKPriK(billNoder);
			System.out.println(noderPubkey+"==========="+noderPriKey);
		}
		while (flag) {
			System.out.println("---------------------------------------"+create);
			JSONObject obj=null;
			try {
				Thread.sleep(3000);
				obj = client.getTransactionByid(create.getString("txid"));
			} catch (Exception e) {
			}
			if (!obj.containsKey("error")) {
				flag = false;
			}
		}
		flag=true;
		Discount discount=new Discount();
		discount.setDicount_id(discount_id);
	
		System.out.println("DetectCreate ok");
		

		JSONObject transfer = null;
		try {
			transfer=RestWriteClient.transferBillTransaction(noderPubkey,noderPriKey,receivePubkey,create.getString("txid"),bill);
		} catch (IOException e1) {
		}
		if(receivePubkey==null && receivePrikey==null){
			receivePubkey=transfer.getString("receive_pubk");
			receivePrikey=transfer.getString("receive_prik");
			BillNoder billNoder1=new BillNoder();
			billNoder1.setCompanyName(payeename);
			billNoder1.setNodePubKey(receivePubkey);
			billNoder1.setNodePrivateKey(receivePrikey);
			billNoderMapper.updatePubKPriK(billNoder1);
		}
		while (flag) {
			System.out.println("+++++++++++++++++++++++++++++");
		
			JSONObject obj=null;
			try {
				Thread.sleep(3000);
				obj = client.getTransactionByid(transfer.getString("txid"));
			} catch (Exception e) {
			}
			if (!obj.containsKey("error")) {
				flag = false;
			}
		}
		discount.setCreateId(create.getString("txid"));
		discount.setTransferId(transfer.getString("txid"));
		discountMapper.updateCreateThrnsferId(discount);
		System.out.println("----------------------"+discount);
		System.out.println("DetectTransfer ok");
	}
}
