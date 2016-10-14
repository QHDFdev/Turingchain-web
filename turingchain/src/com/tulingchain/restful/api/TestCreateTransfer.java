package com.tulingchain.restful.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;

public class TestCreateTransfer {
	public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
//		ReadClient client = new ReadClient();
//		boolean flag = true;
//		String oringinPubk = null;
//		String originPrik = null;
//		JSONObject bill = new JSONObject();
//		bill.put("Bill_amount_money", 3000);
//		JSONObject create = null;
//		JSONObject transfer = null;
//		create = RestWriteClient.createBillTransaction(oringinPubk, originPrik, bill);
//		String createTxId = create.getString("txid");
//		System.out.println("+++++++++++++++++++" + createTxId);
//		while (flag) {
//			System.out.println("-------------------------------------------");
//			Thread.sleep(3000);
//			JSONObject obj = client.getTransactionByid(createTxId);
//			if (!obj.containsKey("error")) {
//				flag = false;
//			}
//		}
//		System.out.println(create);
//		oringinPubk = create.getString("receive_pubk");
//		originPrik = create.getString("receive_prik");
//		transfer = RestWriteClient.transferBillTransaction(oringinPubk, originPrik, null, createTxId, bill);
		
		String oringinPubk = null;
		String originPrik = null;
		JSONObject bill = new JSONObject();
		bill.put("Bill_amount_money", 3000);
		JSONObject create = null;
		create = RestWriteClient.createBillTransaction(oringinPubk, originPrik, bill);
		Runnable detectCreate=new DetectCreate(create.getString("txid"),create.getString("receive_pubk"),create.getString("receive_prik"));
		Thread th=new Thread(detectCreate);
		th.start();
		System.out.println("================main 结束了!!!");
	}
}



class DetectCreate implements Runnable {
	private String createTxId;
	String noderPubkey;
	String noderPriKey;
	private boolean flag=true;


	public DetectCreate(String createTxId,String noderPubkey,String noderPriKey) {
		this.createTxId = createTxId;
		this.noderPubkey = noderPubkey;
		this.noderPriKey = noderPriKey;
	}

	@Override
	public void run() {
		ReadClient client=null;
		try {
			client = new ReadClient();
		} catch (IOException e1) {
		}
		while (flag) {
			System.out.println("-------------------------------------------");
		
			JSONObject obj=null;
			try {
				Thread.sleep(3000);
				obj = client.getTransactionByid(createTxId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!obj.containsKey("error")) {
				flag = false;
			}
		}
		flag=true;
		System.out.println("DetectCreate ok");
		
		JSONObject bill = new JSONObject();
		bill.put("Bill_amount_money", 3000);
		JSONObject transfer = null;
		try {
			transfer=RestWriteClient.transferBillTransaction(noderPubkey,noderPriKey,null,createTxId,bill);
		} catch (IOException e1) {
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
		
		System.out.println("DetectTransfer ok");
		
	
	}
}