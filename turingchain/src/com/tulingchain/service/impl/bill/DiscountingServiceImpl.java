package com.tulingchain.service.impl.bill;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.DiscountingMapper;
import com.tulingchain.mapper.billMapper.PaymentMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Discounting;
import com.tulingchain.model.bill.Payment;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.DiscountingService;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.SpringUtils;

@Service
public class DiscountingServiceImpl implements DiscountingService {
	@Autowired
	public BillNoderMapper billNoderMapper;
	
	@Autowired
	public DiscountingMapper discoutingMapper;
	
	@Override
	public String save(Discounting discounting) {
		String discountingName=RestUtils.ChineseToUnicode(discounting.getDiscountingNoder().getCompanyName());
		String payeeName=RestUtils.ChineseToUnicode(discounting.getPayeeNoder().getCompanyName());
		String discountingOrg=RestUtils.ChineseToUnicode(discounting.getDiscountingOrgNoder().getCompanyName());
		int discountingId=billNoderMapper.getNoderByComName(discounting.getDiscountingNoder().getCompanyName()).getId();
		int payeeId=billNoderMapper.getNoderByComName(discounting.getPayeeNoder().getCompanyName()).getId();
		int discountingOrgId=billNoderMapper.getNoderByComName(discounting.getDiscountingOrgNoder().getCompanyName()).getId();
		int moneySum=discounting.getMoneySum();
		String expireDate=discounting.getExpireDate().toString();
		String billNumber=discounting.getBillNumber();
		
		String noderPubkey=billNoderMapper.getNoderPubKeySer(discountingId)==null?null:billNoderMapper.getNoderPubKeySer(discountingId); 
		String noderPriKey=billNoderMapper.getNoderPriKeySer(discountingId)==null?null:billNoderMapper.getNoderPriKeySer(discountingId);	      //获得发送方用户私钥
		String receivePubKey=billNoderMapper.getNoderPubKeySer(payeeId)==null?null:billNoderMapper.getNoderPubKeySer(payeeId);   //接收方公钥
		String receivePriKey=billNoderMapper.getNoderPriKeySer(payeeId)==null?null:billNoderMapper.getNoderPriKeySer(payeeId);
		
		discounting.setDiscountingName(discountingId);
		discounting.setPayee(payeeId);
		discounting.setDiscountingOrg(discountingOrgId);
		
		//生成bill参数
		JSONObject bill=RestUtils.generateBill("承贴",2,discountingName,discountingId,billNumber,payeeName,payeeId,"RMB",moneySum,discountingName,discountingOrgId,expireDate,
				discountingOrg,null,null);
		int re=discoutingMapper.save(discounting);
		//------------
		Runnable duietDiscounting=new QuietDiscounting(discounting.getDiscountingNoder().getCompanyName(),noderPubkey,noderPriKey,discounting.getPayeeNoder().getCompanyName(),receivePubKey,receivePriKey,bill,re);
		Thread thread=new Thread(duietDiscounting);
		thread.start();
		//-------------
		return JsonUtils.returnState(1, null);
		
	}

	
	@Override
	public List<Discounting> listAll(int id) {
		List<Discounting> re=discoutingMapper.listAll(id);
		return re;
	}
}
class QuietDiscounting implements Runnable {


	//通过Spring的ApplicationContext获得Bean,从而解决Spring不会在新线程中注入实例
	private DiscountingMapper paymentMapper=(DiscountingMapper) SpringUtils.getBeanByClass(DiscountingMapper.class);
	private BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);
	 
	
	private String noderPubkey;
	private String noderPriKey;
	private String receivePubkey;
	private String receivePrikey;
	private String signername;
	private String payeename;
	private JSONObject bill;
	private int dis_id;
	private boolean flag=true;

	
	public QuietDiscounting(){}
	public QuietDiscounting(String signername,String noderPubkey,String noderPriKey,String payeename,String receivePubkey,String receivePrikey,JSONObject bill,int dis_id) {
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
		this.receivePubkey=receivePubkey;
		this.receivePrikey=receivePrikey;
		this.signername=signername;
		this.payeename=payeename;
		this.dis_id=dis_id;
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
		Discounting discounting=new Discounting();
		discounting.setDis_id(dis_id);
	
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
		discounting.setCreateId(create.getString("txid"));
		discounting.setTransferId(transfer.getString("txid"));
		paymentMapper.updateCreateThrnsferId(discounting);
		System.out.println("DetectTransfer ok");
	}
}
