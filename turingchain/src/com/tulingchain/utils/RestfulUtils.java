package com.tulingchain.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestfulUtils {
	private static final String uri="http://114.55.147.2:8000/rest/key-pair/";
	private static final String auth="root:1234qwer";
	
	private static HttpClient httpClient;
	private static	HttpGet request;
	private static HttpResponse response;
	private static BufferedReader br;
	private static String res;
	private static JSONObject obj;
	
	
	static{
		httpClient = new DefaultHttpClient();
		request = new HttpGet(uri);
		request.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String(auth.getBytes())));
		try {
			response = httpClient.execute(request);
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			res = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//使用阿里巴巴的fastJson
		obj = JSON.parseObject(res);
	}

	/**
	 * @see    获取公钥
	 * @return String
	 * @throws Exception
	 */
	public static String getOriginalPublicKey() throws Exception{
		String originalPublicKey = obj.getString("public_key");
		return originalPublicKey;
	}
	
	
	/**
	 * @see    获取私钥
	 * @return String
	 * @throws Exception
	 */
	public static String getOriginalPrivateKey() throws Exception{
		String originalPrivateKey = obj.getString("private_key");
		return originalPrivateKey;
	}
	
	public static HttpClient gethttpClient(){
		return httpClient;
	}
	
	public static HttpGet getRequest(){
	
		return  request;
	}
	
	
	public static  HttpResponse getResponse() throws ClientProtocolException, IOException{
		return httpClient.execute(request);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(RestfulUtils.getOriginalPublicKey()+"===="+RestfulUtils.getOriginalPrivateKey());
	}
	
}
