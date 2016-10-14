package com.tulingchain.service.impl.bill;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.PayoffMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Payoff;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.PayoffService;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.SpringUtils;

@Service
public class PayoffServiceImpl implements PayoffService{
	
	@Autowired
	BillNoderMapper billNoderMapper;
	
	@Autowired
	PayoffMapper payoffMapper;
	
	@Override
	public String save(Payoff payoff) {
		int payerId=billNoderMapper.getNoderByComName(payoff.getPayoffNoder().getCompanyName()).getId();;
		int payeeId=billNoderMapper.getNoderByComName(payoff.getPayeeNoder().getCompanyName()).getId();
		int discoutingOrgId=billNoderMapper.getNoderByComName(payoff.getDiscountingOrgNoder().getCompanyName()).getId();
		String payer=RestUtils.ChineseToUnicode(payoff.getPayoffNoder().getCompanyName());
		String payee=RestUtils.ChineseToUnicode(payoff.getPayeeNoder().getCompanyName());
		String discountingOrg=RestUtils.ChineseToUnicode(payoff.getDiscountingOrgNoder().getCompanyName());
		String billNumber=payoff.getBillNumber();
		int moneySum=payoff.getMoneySum();
		String expireDate=payoff.getExpireDate().toString();
		
		payoff.setPayoffName(payerId);
		payoff.setPayee(payeeId);
		payoff.setDiscountingOrg(discoutingOrgId);
		//--------------
		String noderPubkey=billNoderMapper.getNoderPubKeySer(payerId)==null?null:billNoderMapper.getNoderPubKeySer(payerId);
		String noderPriKey=billNoderMapper.getNoderPriKeySer(payerId)==null?null:billNoderMapper.getNoderPriKeySer(payerId);
		String receivePubKey=billNoderMapper.getNoderPubKeySer(payeeId)==null?null:billNoderMapper.getNoderPubKeySer(payerId);
		String receivePriKey=billNoderMapper.getNoderPriKeySer(payeeId)==null?null:billNoderMapper.getNoderPriKeySer(payerId);
		
		JSONObject bill=RestUtils.generateBill("发薪",2,payer,payerId,billNumber,payee,payeeId,"RMB",moneySum,discountingOrg,discoutingOrgId,expireDate,
				discountingOrg,null,null);
		int re=payoffMapper.save(payoff);
		//-------------------
		Runnable quietPayoff=new QuietPayoff(payoff.getPayoffNoder().getCompanyName(),noderPubkey,noderPriKey,payoff.getPayeeNoder().getCompanyName(),receivePubKey,receivePriKey,bill,re);
		Thread thread=new Thread(quietPayoff);
		thread.start();
		
		//----------------
		return JsonUtils.returnState(1, null);
	}

	
	@Override
	public List<Payoff> listAll(int id) {
		List<Payoff> list=payoffMapper.listAll(id);
		return list;
	}

}

class QuietPayoff implements Runnable {


	//通过Spring的ApplicationContext获得Bean,从而解决Spring不会在新线程中注入实例
	private PayoffMapper PayoffMapper=(PayoffMapper) SpringUtils.getBeanByClass(PayoffMapper.class);
	private BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);
	 
	
	private String noderPubkey;
	private String noderPriKey;
	private String receivePubkey;
	private String receivePrikey;
	private String signername;
	private String payeename;
	private JSONObject bill;
	private int payoff_id;
	private boolean flag=true;

	
	public QuietPayoff(){}
	public QuietPayoff(String signername,String noderPubkey,String noderPriKey,String payeename,String receivePubkey,String receivePrikey,JSONObject bill,int payoff_id) {
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
		this.receivePubkey=receivePubkey;
		this.receivePrikey=receivePrikey;
		this.signername=signername;
		this.payeename=payeename;
		this.payoff_id=payoff_id;
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
		Payoff payoff=new Payoff();
		payoff.setPayoff_id(payoff_id);
	
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
		payoff.setCreateId(create.getString("txid"));
		payoff.setTransferId(transfer.getString("txid"));
		PayoffMapper.updateCreateThrnsferId(payoff);
		System.out.println("DetectTransfer ok");
	}
}
