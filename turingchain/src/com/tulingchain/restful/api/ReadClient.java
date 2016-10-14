package com.tulingchain.restful.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @version 1.0
 * @author Soooooolazy
 * @see 这里是GET客户端
 *
 */
public class ReadClient {
	public static final String URL="http://114.55.233.230/rest";
	private static final String KEYPAIR_URI = URL+"/key-pair/";
	private static final String BLOCK_BYID_URI =URL+ "/blocks/";//传入id，获得block
	private static final String BLOCK_BYHEIGHT_URI =URL+ "/block/?height="; //待加.............
	private static final String TRANSACTION_LAST_URI =URL+ "/transaction/last/";
	private static final String BLOCK_LAST_URI = URL+"/block/last/";
	private static final String LAST_BLOCK_HEIGHT=URL+"/blocks/?order=des&sortby=block_number&limit=1&field=block_number";
	private static final String TRAMSACTION_BYID_URI = URL+"/transactions/";
	private static final String QUERY_MY_BILLS=URL+"/transactions/?receive_pubk=";
//	private static final String authInfo = "admin:justletmein";
	private static final String TOKEN=RestUtils.getToken();
	private  HttpClient httpClient;
	private  HttpGet request;
	private  HttpResponse response;
	private  int  last_block_number;
	private  JSONArray tracearray=new JSONArray();
	
	
	public ReadClient() throws ClientProtocolException, IOException {
		this.httpClient = new DefaultHttpClient();
		this.getLastBlockHeight();
	}
	
	public int getLastBlockHeight() {
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet request = new HttpGet(LAST_BLOCK_HEIGHT);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		try {
			HttpResponse response = httpClient.execute(request);
			BufferedReader rs = new BufferedReader(new InputStreamReader(response
					.getEntity().getContent()));
			String res = rs.readLine();
			JSONObject obj =JSON.parseObject(res);
			last_block_number=obj.getIntValue("block_number");
		} catch (Exception e) {
		}finally{
		}
		
		
		return last_block_number;
	}
	

	public JSONObject getKeyPair() throws IOException {
		 request = new HttpGet(KEYPAIR_URI);
//		 request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		 request.setHeader("Authorization","token "+TOKEN);
		 response = httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONObject obj = JSON.parseObject(res);
		return obj;
	}

	public JSONObject getBlockById(String txid) throws ClientProtocolException,
			IOException {
		request = new HttpGet(BLOCK_BYID_URI + txid);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response = httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONObject obj = JSON.parseObject(res);
		rs.close();

//		httpClient.getConnectionManager().shutdown();
		return obj;
	}

	public JSONObject getBlockByHeight(int height)
			throws ClientProtocolException, IOException {
		JSONObject obj=null;
		BufferedReader rs=null;
		try {
		request = new HttpGet(BLOCK_BYHEIGHT_URI + height);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response = httpClient.execute(request);
		//内容可能为空
		if(response.getEntity()!=null){
			rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
			String res = rs.readLine();
				 obj = JSON.parseObject(res);
		}
		} catch (Exception e) {
			return obj;
		}
		
		return obj;
		
	}

	public JSONObject getLastTransaction() throws ClientProtocolException,
			IOException {
		request = new HttpGet(TRANSACTION_LAST_URI);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response = httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONObject obj =null;
		try {
			obj= JSON.parseObject(res);
		} catch (Exception e) {
			return null;
		}
		return obj;
	}

	public static  JSONObject getLastBlock() throws ClientProtocolException,
			IOException {
		JSONObject obj =null;
		HttpGet request=null;
		HttpResponse response;
		HttpClient httpClient=new DefaultHttpClient();
		BufferedReader rs=null;
		try {
		 request = new HttpGet(BLOCK_LAST_URI);
//		 request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		 request.setHeader("Authorization","token "+TOKEN);
		 response = httpClient.execute(request);
		rs = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String res = rs.readLine();
		obj= JSON.parseObject(res);
		} catch (Exception e) {
			return null;
		}finally{
			rs.close();
		}
		return obj;
	}

	

	public JSONObject getTransactionByid(String tid)
			throws ClientProtocolException, IOException {
		request = new HttpGet(TRAMSACTION_BYID_URI + tid);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response = httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONObject obj = JSON.parseObject(res);
		rs.close();
//		httpClient.getConnectionManager().shutdown();
		return obj;
	}
	
	public JSONArray queryMyBills(String userPubkey) throws ClientProtocolException, IOException{
		request=new HttpGet(QUERY_MY_BILLS+userPubkey+"&sortby=timestamp&orderby=des&field=id");
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response=httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONArray obj = JSON.parseArray(res);
		rs.close();
		System.out.println(obj);
		return obj;
	}
	
	
	

//	public JSONObject testDemo()
//			throws ClientProtocolException, IOException {
//		request = new HttpGet("http://114.55.233.230/rest/block/last/");
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String("admin:justletmein".getBytes())));
//		response = httpClient.execute(request);
//		BufferedReader rs = new BufferedReader(new InputStreamReader(response
//				.getEntity().getContent()));
//		String res = rs.readLine();
//		JSONObject obj = JSON.parseObject(res);
//		rs.close();
////		httpClient.getConnectionManager().shutdown();
//		return obj;
//	}

	/*
	 * 首页获取区块列表，（ 各处想要动态获取区块信息条目） 1.先通过getLastBlock()获得最新的区块高度(height)
	 * 2.然后向下查询n个区块，然后存放到JSONObject中
	 */
	public String getListBlock(int k) throws ClientProtocolException, IOException  {
		List<JSONObject> blockList = new ArrayList<JSONObject>();
		try {
			for (int i = last_block_number; i > last_block_number - k; i--) {
				JSONObject object = getBlockByHeight(i);
				if (object == null) {
					k++;
					continue;
				}
				blockList.add(object);
		}
		} catch (Exception e) {
			JSON.toJSONString(blockList);
		}
//		httpClient.getConnectionManager().shutdown();
		return JSON.toJSONString(blockList);
	}
	

	

	/*
	 * 首页获取交易列表 1.交易信息存放在区块里，但不是每个区块里都有交易信息，我们要自上向下选取五条记录
	 * 2.从最高的区块开始，依次读取里面交易信息,选取 <operation> 为 TRANSFER 的交易信息 3.不足五条就读取下一个区块
	 * 
	 * 这个速度简直报警了啊，后台依次提交20个http请求，在进行处理,可以尝试一下多线程!!!!!!!!!
	 */
	public String getListTrans(int k) throws ClientProtocolException,
			IOException {
//		JSONObject lastBlock =ReadClient getLastBlock();
//		int last_block_number = lastBlock.getIntValue("block_number");
//		int last_block_number = 1000;
		List<JSONArray> transactionList = new ArrayList<JSONArray>();
		try {
			outFor: for (int i = last_block_number; i > 0; i--) {
				JSONObject object = getBlockByHeight(i);
				if (object != null) {
					JSONArray array = object.getJSONObject("block").getJSONArray(
							"transactions");
					System.out.println(array.size());
					int j = array.size();
					if (j > 0) {
						// 得到里面的transaction
						for (int m = 0; m < j; m++) {
							JSONObject tran = array.getJSONObject(m).getJSONObject(
									"transaction");
							if (tran.containsValue("TRANSFER")) {
								transactionList.add(array);
								if (transactionList.size() == k)
									break outFor;
								System.out.println("=========="
										+ transactionList.size());
							} else {
								continue;
							}
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			} 
		} catch (Exception e) {
		}
//		httpClient.getConnectionManager().shutdown();
		return JSON.toJSONString(transactionList);
	}
	
	
	/*
	 * 获得opetation为transfer的交易
	 * 
	 */
	public String getListTransfer(int k) throws ClientProtocolException, IOException{
		List<JSONObject> transactionList = new ArrayList<JSONObject>();
		JSONArray obj =null;
		try{
			request=new HttpGet(URL+"/transactions/?operation=TRANSFER&order=des&sortby=timestamp");
//			request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
			request.setHeader("Authorization","token "+TOKEN);
			response=httpClient.execute(request);
			BufferedReader rs = new BufferedReader(new InputStreamReader(response
					.getEntity().getContent()));
			String res = rs.readLine();
			 obj= JSON.parseArray(res);
			 outFor: for(int i=0;i<obj.size();i++){
					 JSONObject element=(JSONObject) obj.get(i);
					 if(element.getJSONObject("transaction").getString("operation").equals("TRANSFER")){
						 transactionList.add(element);
						 if(transactionList.size()==k){
							 break outFor;
						 }
					 }else{
						 continue;
					 }
				 }
			 
		}catch(Exception e){
		}
		System.out.println(obj);
		return transactionList.toString();
	}
	

	
	//根据区块Hash获得JSON中content中数据
	public JSONObject getBlockContent(int height,String hash) throws ClientProtocolException, IOException{
		request=new HttpGet(TRAMSACTION_BYID_URI+hash);
//		request.setHeader("Authorization","Basic "+ new String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		response=httpClient.execute(request);
		BufferedReader rs = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String res = rs.readLine();
		JSONObject obj=JSON.parseObject(res);
		obj=obj.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload");
		System.out.println(obj);
		return obj;
	}
	
	
	public  void close(){
		request.abort();
		httpClient.getConnectionManager().shutdown();
	}
	
	
	//前端溯源系统
	public  String getAllPrevious(String tid) throws ClientProtocolException, IOException{
		JSONObject obj=getTransactionByid(tid);
		tracearray.add(obj);
		if(obj.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload").getString("previous_process_tx_id")==null){
			return tracearray.toJSONString();
		}else{
			getAllPrevious(obj.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload").getString("previous_process_tx_id"));
		}
		return tracearray.toJSONString();
	}
	
	
	public static void main(String[] args) throws Exception {
		
	ReadClient client = new ReadClient();
//	System.out.println(client.getLastBlockHeight());
	System.out.println(client.getListTransfer(2));
//		Date date=new Date(1474167237000L);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(date));
//		client.getBlockByHeight(2);
		System.out.println(getLastBlock().getIntValue("block_number"));
//		JSONObject obj=client.getBlockContent(4088,"cd9de214fd15727cff144244adfad46c1b9f85af9e10cb7bfe217130113b175a");
//		System.out.println(obj);
//		System.out.println(client.getBlockByHeight(4088));
//		System.out.println(client.getKeyPair());
//		 System.out.println(client.getListTrans(7));
//		 System.out.println(client.getListBlock(20));
//		System.out.println(getLastBlock());
//		 System.out.println(client.getBlockByHeight(900));
//		 if(client.getBlockByHeight(19)==null){
//		 System.out.println(client.getBlockByHeight(19));
//		 }else{
//		 System.out.println("不是空的");
//		 }
//		 System.out.println(getLastBlockHeight());
//		System.out.println(client.getAllPrevious("9512d328870cfa52468de5a8a95b26dbae6926d6c0979f055af83c741a020548"));
//		JSONArray object=(JSONArray)JSON.toJSON(client.getAllPrevious("9512d328870cfa52468de5a8a95b26dbae6926d6c0979f055af83c741a020548"));
		
		
		//JSON.toJSONString(object, config, features)
//		System.out.println(object);
		/**
		 *  根据一个txid获得所有相关的交易信息
		 */
//		String obj=client.getAllPrevious("9512d328870cfa52468de5a8a95b26dbae6926d6c0979f055af83c741a020548");
//		System.out.println(obj);
//		System.out.println(obj.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload").getString("previous_process_tx_id"));
		
		
//		System.out.println("=========="+obj);
//		JSONObject previous=obj.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload");
//		while(previous.getString("previous_process_tx_id")!=null){
//			System.out.println(previous.getString("previous_process_tx_id"));
//			String tid=previous.getString("previous_process_tx_id");
//			JSONObject obj1=client.getTransactionByid(tid);;
//		}
	}





	
	
}