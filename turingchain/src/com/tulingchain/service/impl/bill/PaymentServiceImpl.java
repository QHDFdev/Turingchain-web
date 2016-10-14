package com.tulingchain.service.impl.bill;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.PaymentMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Payment;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.PaymentService;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.SpringUtils;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	BillNoderMapper billNoderMapper;
	
	@Autowired
	PaymentMapper paymentMapper;
	
	@Override
	public String save(Payment payment) {
		int payerId=billNoderMapper.getNoderByComName(payment.getPayerNoder().getCompanyName()).getId();;
		int payeeId=billNoderMapper.getNoderByComName(payment.getPayeeNoder().getCompanyName()).getId();
		int discoutingOrgId=billNoderMapper.getNoderByComName(payment.getDiscountingOrgNoder().getCompanyName()).getId();
		String payer=RestUtils.ChineseToUnicode(payment.getPayerNoder().getCompanyName());
		String payee=RestUtils.ChineseToUnicode(payment.getPayeeNoder().getCompanyName());
		String discountingOrg=RestUtils.ChineseToUnicode(payment.getDiscountingOrgNoder().getCompanyName());
		String billNumber=payment.getBillNumber();
		int moneySum=payment.getMoneySum();
		String expireDate=payment.getExpireDate().toString();
		
		String noderPubkey=billNoderMapper.getNoderPubKeySer(payerId)==null?null:billNoderMapper.getNoderPubKeySer(payerId); 
		String noderPriKey=billNoderMapper.getNoderPriKeySer(payerId)==null?null:billNoderMapper.getNoderPriKeySer(payerId);	      //获得发送方用户私钥
		String receivePubKey=billNoderMapper.getNoderPubKeySer(payeeId)==null?null:billNoderMapper.getNoderPubKeySer(payeeId);   //接收方公钥
		String receivePriKey=billNoderMapper.getNoderPriKeySer(payeeId)==null?null:billNoderMapper.getNoderPriKeySer(payeeId);
		
		payment.setPayerName(payerId);
		payment.setPayee(payeeId);
		payment.setDiscountingOrg(discoutingOrgId);
		int re=paymentMapper.save(payment);
		
		JSONObject bill=RestUtils.generateBill("支付",2,payer,payerId,billNumber,payee,payeeId,"RMB",moneySum,discountingOrg,discoutingOrgId,expireDate,
				discountingOrg,null,null);
			//----------------------
			Runnable quietPayment=new QuietPayment(payment.getPayerNoder().getCompanyName(),noderPubkey,noderPriKey,payment.getPayeeNoder().getCompanyName(),receivePubKey,receivePriKey,bill,re);
			Thread thread=new Thread(quietPayment);
			thread.start();
			
			//----------------------
			
		return JsonUtils.returnState(1, null);

		
	}

	@Override
	public List<Payment> listAll(int id) {
		List<Payment> list=paymentMapper.listAll(id);
		return list;
	}

}
class QuietPayment implements Runnable {


	//通过Spring的ApplicationContext获得Bean,从而解决Spring不会在新线程中注入实例
	private PaymentMapper paymentMapper=(PaymentMapper) SpringUtils.getBeanByClass(PaymentMapper.class);
	private BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);
	 
	
	private String noderPubkey;
	private String noderPriKey;
	private String receivePubkey;
	private String receivePrikey;
	private String signername;
	private String payeename;
	private JSONObject bill;
	private int pay_id;
	private boolean flag=true;

	
	public QuietPayment(){}
	public QuietPayment(String signername,String noderPubkey,String noderPriKey,String payeename,String receivePubkey,String receivePrikey,JSONObject bill,int pay_id) {
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
		this.receivePubkey=receivePubkey;
		this.receivePrikey=receivePrikey;
		this.signername=signername;
		this.payeename=payeename;
		this.pay_id=pay_id;
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
		Payment payment=new Payment();
		payment.setPay_id(pay_id);
	
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
		payment.setCreateId(create.getString("txid"));
		payment.setTransferId(transfer.getString("txid"));
		paymentMapper.updateCreateThrnsferId(payment);
		System.out.println("DetectTransfer ok");
	}
}
