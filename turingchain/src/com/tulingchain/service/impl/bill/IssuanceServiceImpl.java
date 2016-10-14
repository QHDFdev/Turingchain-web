package com.tulingchain.service.impl.bill;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.IssuanceMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Issuance;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.IssuanceService;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.SpringUtils;

@Service
public class IssuanceServiceImpl implements IssuanceService{
	
	@Autowired
	private IssuanceMapper issuanceMapper;
	
	@Autowired
	private BillNoderMapper billNoderMapper;
	

	/**
	 *   这里的create之后并不能立马去创建transfer,此时create返回的txid还要进行投票
	 *   立刻进行transfer也许会获得{"error":"Wrong pre_txid"}
	 * 
	 */
	@Override
	public String insert(Issuance issuance) {
		String signername=RestUtils.ChineseToUnicode(issuance.getSignerNoder().getCompanyName());
		String payeename=RestUtils.ChineseToUnicode(issuance.getPayeeNoder().getCompanyName());
		String discountingOrgName=RestUtils.ChineseToUnicode(issuance.getDiscountingOrgNoder().getCompanyName());
		int signer=billNoderMapper.getNoderByComName(issuance.getSignerNoder().getCompanyName()).getId();
		int payee=billNoderMapper.getNoderByComName(issuance.getPayeeNoder().getCompanyName()).getId();
		int discountingOrg=billNoderMapper.getNoderByComName(issuance.getDiscountingOrgNoder().getCompanyName()).getId();
		int mouneySum=issuance.getMoneySum();
		String billNumber=issuance.getBillNumber();
		String noderPubkey=billNoderMapper.getNoderPubKeySer(signer)==null?null:billNoderMapper.getNoderPubKeySer(signer); 
		String noderPriKey=billNoderMapper.getNoderPriKeySer(signer)==null?null:billNoderMapper.getNoderPriKeySer(signer);	      //获得发送方用户私钥
		String receivePubKey=billNoderMapper.getNoderPubKeySer(payee)==null?null:billNoderMapper.getNoderPubKeySer(payee);   //接收方公钥
		String receivePriKey=billNoderMapper.getNoderPriKeySer(payee)==null?null:billNoderMapper.getNoderPriKeySer(payee);
		issuance.setSigner(signer);
		issuance.setPayee(payee);
		issuance.setIsDiscounted(0);
		issuance.setDiscountingOrg(discountingOrg);
		issuanceMapper.save(issuance);
		int re=issuance.getIs_id();
		//---------单独的inssuance线程-----------
		JSONObject bill=RestUtils.generateBill("签发",1,signername,signer,billNumber,payeename,payee,"RMB",mouneySum,discountingOrgName,discountingOrg,issuance.getExpireDate().toString(),
				discountingOrgName,null,null);
		Runnable quietInssuance=new QuietInssuance(issuance.getSignerNoder().getCompanyName(),noderPubkey,noderPriKey,issuance.getPayeeNoder().getCompanyName(),receivePubKey,receivePriKey,bill,re);
		Thread thread=new Thread(quietInssuance);
		thread.start();
		//----------------------
		
		
		return JsonUtils.returnState(1, null);
	}
	
	@Override
	public List<Issuance> listAll(int id) {
		List<Issuance> list=issuanceMapper.listAll(id);
		return list;
	}

	@Override
	public List<Issuance> listNeedDiscounting(int id) {
		 List<Issuance> list=issuanceMapper.selectIsDiscounted(id);
		return list;
	}
}



/**
 * 
 * @author Soooooolazy
 *	线程2:
 *					1.进行create操作返回的txid验证，返回error,正在投票或者创建失败
 *					2.通过后，进行transfer操作
 *					3.进行transfer操作返回的txid验证，返回error,正在投票或者创建失败
 *					4.存储操作
 */
class QuietInssuance implements Runnable {


	//通过Spring的ApplicationContext获得Bean,从而解决Spring不会在新线程中注入实例
	private IssuanceMapper issuanceMapper=(IssuanceMapper) SpringUtils.getBeanByClass(IssuanceMapper.class);
	private BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);
	 
	
	private String noderPubkey;
	private String noderPriKey;
	private String receivePubkey;
	private String receivePrikey;
	private String signername;
	private String payeename;
	private JSONObject bill;
	private int is_id;
	private boolean flag=true;

	
	public QuietInssuance(){}
	public QuietInssuance(String signername,String noderPubkey,String noderPriKey,String payeename,String receivePubkey,String receivePrikey,JSONObject bill,int is_id) {
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
		this.receivePubkey=receivePubkey;
		this.receivePrikey=receivePrikey;
		this.signername=signername;
		this.payeename=payeename;
		this.is_id=is_id;
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
		Issuance issuance=new Issuance();
		issuance.setIs_id(is_id);
	
		System.out.println("DetectCreate ok");
//		
//
//		JSONObject transfer = null;
//		try {
//			transfer=RestWriteClient.transferBillTransaction(noderPubkey,noderPriKey,receivePubkey,create.getString("txid"),bill);
//		} catch (IOException e1) {
//		}
//		if(receivePubkey==null && receivePrikey==null){
//			receivePubkey=transfer.getString("receive_pubk");
//			receivePrikey=transfer.getString("receive_prik");
//			BillNoder billNoder1=new BillNoder();
//			billNoder1.setCompanyName(payeename);
//			billNoder1.setNodePubKey(receivePubkey);
//			billNoder1.setNodePrivateKey(receivePrikey);
//			billNoderMapper.updatePubKPriK(billNoder1);
//		}
//		while (flag) {
//			System.out.println("+++++++++++++++++++++++++++++");
//		
//			JSONObject obj=null;
//			try {
//				Thread.sleep(3000);
//				obj = client.getTransactionByid(transfer.getString("txid"));
//			} catch (Exception e) {
//			}
//			if (!obj.containsKey("error")) {
//				flag = false;
//			}
//		}
		issuance.setCreateId(create.getString("txid"));
//		issuance.setTransferId(transfer.getString("txid"));
		issuanceMapper.updateCreateThrnsferId(issuance);
		System.out.println("DetectTransfer ok");
	}
}