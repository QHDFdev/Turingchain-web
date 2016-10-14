package com.tulingchain.restful.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Restful 创建Transaction
 * 1.获得公私钥
 * 2.
 * 
 * @author Administrator
 *
 */
public class RestWriteClient {
	
	//create类型个的Transaction
	private static String URL="http://114.55.233.230/rest/";
	private static String TRANSACTION_URL=URL+"transactions/";
	private static String COMMON_CREATE=URL+"transaction/common/create/";
	private static final String TOKEN=RestUtils.getToken();
	//transfer类型的Transaction
//	private static String TRANSFER_TRANSACTION_URL="http://114.55.5.67:8099/rest/transaction/transfer/";
	
	/*
	 * public String createTransaction( publicKey, Who , Where , When , Thing ) {
	 */
//	private static final String authInfo = "admin:justletmein";
	
	public static JSONObject createTransaction(String originalPublicKey,JSONObject who,JSONObject where,JSONObject when,JSONObject thing) throws ClientProtocolException, IOException{
		HttpClient httpClient=new DefaultHttpClient();
//		
//		  JSONObject whoOriginal = RestUtils.generateWhoItem(null, null, null, null, null, null);
//        JSONObject whoGoto = RestUtils.generateWhoItem("000001", RestUtils.ChineseToUnicode("图灵"), "000001", "000001", RestUtils.ChineseToUnicode("李雷"), "3");
//        JSONObject whereOriginal = RestUtils.generateWhereItem(null,null, null, null);
//        JSONObject whereGoto = RestUtils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
//        JSONObject who = RestUtils.generateWho(whoOriginal, whoGoto);
//        JSONObject where = RestUtils.generateWhere(whereOriginal, whereGoto);
//        JSONObject when = RestUtils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
//        JSONObject thing = RestUtils.generateThing("1", RestUtils.ChineseToUnicode("类型"), "1", RestUtils.ChineseToUnicode("玻璃"), "shenzhen", "100", "1", "12");
        JSONObject param = RestUtils.generateCreateParam(originalPublicKey, null, who, where, when, thing);
        
        HttpPost post=new HttpPost(TRANSACTION_URL);
//		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(authInfo.getBytes())));
        post.setHeader("Authorization","token "+TOKEN);
		post.addHeader("content-type", "application/json");
        StringEntity params =new StringEntity(param.toString());
        post.setEntity(params);
        HttpResponse response=httpClient.execute(post);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res=bufferedReader.readLine();
        JSONObject object=JSON.parseObject(res);
        System.out.println("==============================Create id:"+object.getString("id"));
        return object;
	}
	
	
	
	
	
//	transferTransaction(txOriginatorPublicKey,txRecipientPublicKey, txOriginatorPrivateKey, Who , Where , When , Thing ) {
//		
	public static JSONObject transferTransaction(String originalPublicKey,String originalPrilicKey,String txRecipientPublicKey,String previousProcessTxId,JSONObject who,JSONObject where,JSONObject when,JSONObject thing) throws ClientProtocolException, IOException{
		HttpClient httpClient=new DefaultHttpClient();
		JSONObject param = RestUtils.generateTransferParam(originalPublicKey, originalPrilicKey, txRecipientPublicKey, previousProcessTxId, who, where, when, thing);
		System.out.println(param);
	    HttpPost post=new HttpPost(TRANSACTION_URL);
//		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(authInfo.getBytes())));
	    post.setHeader("Authorization","token "+TOKEN);
		post.addHeader("content-type", "application/json");
	    StringEntity params =new StringEntity(param.toString());
	    post.setEntity(params);
	    HttpResponse response=httpClient.execute(post);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res=bufferedReader.readLine();
        JSONObject object=JSON.parseObject(res);
        System.out.println(res);
        return object;
	}
	
	
	public static JSONObject transferBillTransaction(String origin_pubk,String origin_prik,String recipe_pubk,String pre_txid,JSONObject bill) throws ClientProtocolException, IOException{
		HttpClient httpClient=new DefaultHttpClient();
//		JSONObject param = RestUtils.generateBillTransferParam(origin_pubk, origin_prik, recipe_pubk, pre_txid, bill);
		  List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		  if(recipe_pubk!=null){
			  nvps.add(new BasicNameValuePair("origin_pubk", origin_pubk));  
		      nvps.add(new BasicNameValuePair("origin_prik", origin_prik));  
		      nvps.add(new BasicNameValuePair("receive_pubk", recipe_pubk));  
		      nvps.add(new BasicNameValuePair("pre_txid", pre_txid));  
		      nvps.add(new BasicNameValuePair("data", bill.toString()));  
		  }else{
			  nvps.add(new BasicNameValuePair("origin_pubk", origin_pubk));  
		      nvps.add(new BasicNameValuePair("origin_prik", origin_prik));  
		      nvps.add(new BasicNameValuePair("pre_txid", pre_txid));  
		      nvps.add(new BasicNameValuePair("data", bill.toString()));  
		  }
		HttpPost post=new HttpPost(TRANSACTION_URL);
//		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(authInfo.getBytes())));
		post.setHeader("Authorization","token "+TOKEN);
		//post.addHeader("content-type", "application xwwwformurlencoded");
//	    StringEntity params =new StringEntity(param.toString());
	    post.setEntity(new UrlEncodedFormEntity(nvps));
	    HttpResponse response=httpClient.execute(post);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res=bufferedReader.readLine();
        JSONObject object=JSON.parseObject(res);
        System.out.println(res);
        return object;
	}
	
	
	public static JSONObject createBillTransaction(String receivePubk,String receivePrik,JSONObject bill) throws ClientProtocolException, IOException{
		HttpClient httpClient=new DefaultHttpClient();
//		JSONObject param = RestUtils.generateBillTransferParam(origin_pubk, origin_prik, recipe_pubk, pre_txid, bill);
		  List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		  if(receivePubk!=null && receivePrik!=null){
			  nvps.add(new BasicNameValuePair("receive_pubk", receivePubk));  
			  nvps.add(new BasicNameValuePair("receive_prik", receivePrik));  
			  nvps.add(new BasicNameValuePair("data", bill.toString()));  
		  }else{
			  nvps.add(new BasicNameValuePair("data", bill.toString()));  
		  }
	    HttpPost post=new HttpPost(TRANSACTION_URL);
//		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(authInfo.getBytes())));
	    post.setHeader("Authorization","token "+TOKEN);
		//post.addHeader("content-type", "application xwwwformurlencoded");
//	    StringEntity params =new StringEntity(param.toString());
	    post.setEntity(new UrlEncodedFormEntity(nvps));
	    HttpResponse response=httpClient.execute(post);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res=bufferedReader.readLine();
        JSONObject object=JSON.parseObject(res);
        System.out.println(res);
        return object;
	}
	

	
	public static JSONObject getKeyPair() throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://114.55.233.230/rest/key-pair/");
//		request.setHeader("Authorization", "Basic " + new  String(Base64.encodeBase64String(authInfo.getBytes())));
		request.setHeader("Authorization","token "+TOKEN);
		HttpResponse response =httpClient.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String res = br.readLine();
		JSONObject obj = JSON.parseObject(res);
		return obj;
	}
	
	//测试API---首页用户测试api返回txid
	public static JSONObject testApi(JSONObject bill) throws ClientProtocolException, IOException{
		HttpClient httpCiient=new DefaultHttpClient();
	    HttpPost post=new HttpPost(COMMON_CREATE);
//		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(authInfo.getBytes())));
	    post.setHeader("Authorization","token "+TOKEN);
		post.addHeader("content-type", "application/json");
		post.setEntity(new StringEntity(bill.toJSONString()));
		HttpResponse response=httpCiient.execute(post);
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String res = bufferedReader.readLine();
		JSONObject obj = JSON.parseObject(res);
		return obj;
	}
}
