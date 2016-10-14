package com.tulingchain.restful.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://114.55.5.67:8099/rest/key-pair/");
		request.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String("root:1234qwer".getBytes())));
		HttpResponse response = httpClient.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String res = br.readLine();
		//使用阿里巴巴的fastJson
		JSONObject obj = JSON.parseObject(res);
		System.out.println(obj);
		String originalPublicKey = obj.getString("public_key");
		String originalPrivateKey = obj.getString("private_key");
		System.out.println(originalPublicKey+"------"+originalPrivateKey);
		//以上内容从工具类中获取了
		response = httpClient.execute(request);
		br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		res = br.readLine();
		obj = JSON.parseObject(res);
		String reciptPublicKey = obj.getString("public_key");
//		post request
		HttpPost post = new HttpPost("http://114.55.5.67:8099/rest/transaction/create/");
        post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String("root:1234qwer".getBytes())));
        post.addHeader("content-type", "application/json");
        JSONObject whoOriginal = generateWhoItem(null, null, null, null, null, null);
        JSONObject whoGoto = generateWhoItem("000001", ChineseToUnicode("图灵"), "000001", "000001", ChineseToUnicode("李雷"), "3");
        System.out.println("========="+whoGoto);
        JSONObject whereOriginal = generateWhereItem(null, null, null, null);
        JSONObject whereGoto = generateWhereItem("china", "shenzhen", "guangdong", "0755");
        JSONObject who = generateWho(whoOriginal, whoGoto);
        JSONObject where = generateWhere(whereOriginal, whereGoto);
        JSONObject when = generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
        JSONObject thing = generateThing("1", ChineseToUnicode("类型"), "1", ChineseToUnicode("玻璃"), "shenzhen", "100", "1", "12");
        JSONObject param = generateCreateParam(originalPublicKey, null, who, where, when, thing);
        StringEntity params =new StringEntity(param.toString());
        post.setEntity(params);
        response = httpClient.execute(post);
        br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		res = br.readLine();
		obj = JSON.parseObject(res);
		System.out.println("Create tx id: " + obj.getString("id"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String previousProcessTxId = obj.getString("id");
		whoOriginal = whoGoto;
		whereOriginal = whereGoto;
		whoGoto = generateWhoItem("000002", ChineseToUnicode("顺丰"), "000002", "000002", ChineseToUnicode("韩梅梅"), "4");
		whereGoto = generateWhereItem("china", "shenzhen", "guangdong", "0755");
		who = generateWho(whoOriginal, whoGoto);
		where = generateWhere(whereOriginal, whereGoto);
		thing = generateThing("1", ChineseToUnicode("类型"), "1", ChineseToUnicode("玻璃"), "shenzhen", "80", "1", "12");
		param = generateTransferParam(originalPublicKey, originalPrivateKey, reciptPublicKey, previousProcessTxId, who, where, when, thing);
		params =new StringEntity(param.toString());
		post = new HttpPost("http://114.55.5.67:8099/rest/transaction/transfer/");
		post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64String("root:1234qwer".getBytes())));
        post.addHeader("content-type", "application/json");
		post.setEntity(params);
        response = httpClient.execute(post);
        br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        System.out.println(br.readLine());
	}
	
	public static JSONObject generateWhoItem(Object companyId, Object companyName, Object uCompanyId, Object userId, Object userName, Object userType) {
		JSONObject whoItem = new JSONObject();
		whoItem.put("company_id", companyId);
		whoItem.put("company_name", companyName);
		whoItem.put("u_company_id", uCompanyId);
		whoItem.put("user_id", userId);
		whoItem.put("user_name", userName);
		whoItem.put("user_type", userType);
		return whoItem;
	}
	
	public static JSONObject generateWhereItem(Object nation, Object place, Object region, Object regionId) {
		JSONObject whereItem = new JSONObject();
		whereItem.put("nation", nation);
		whereItem.put("place", place);
		whereItem.put("region", region);
		whereItem.put("region_id", regionId);
		return whereItem;
	}
	
	public static JSONObject generateWho(JSONObject whoOriginal, JSONObject whoGoto) {
		JSONObject who = new JSONObject();
		who.put("original", whoOriginal);
		who.put("goto", whoGoto);
		return who;
	}
	
	public static JSONObject generateWhere(JSONObject whereOriginal, JSONObject whereGoto) {
		JSONObject where = new JSONObject();
		where.put("original", whereOriginal);
		where.put("goto", whereGoto);
		return where;
	}
	
	public static JSONObject generateWhen(String makeDate, String sendDate, String receiveDate, String expireDate) {
		JSONObject when = new JSONObject();
		when.put("make_date", makeDate);
		when.put("send_date", sendDate);
		when.put("receive_date", receiveDate);
		when.put("expire_date", expireDate);
		return when;
	}
	
	public static JSONObject generateThing(String thingTypeId, String thingTypeName, String thingId, String thingName, String originPlace, String thingOrderQuantity, String thingOrderBatch, String price) {
		JSONObject thing = new JSONObject();
		thing.put("thing_type_id", thingTypeId);
		thing.put("thing_type_name", thingTypeName);
		thing.put("thing_id", thingId);
		thing.put("thing_name", thingName);
		thing.put("origin_place", originPlace);
		thing.put("thing_order_quantity", thingOrderQuantity);
		thing.put("thing_order_batch", thingOrderBatch);
		thing.put("price", price);
		return thing;
	}
	
	public static JSONObject generateCreateParam(String publicKey, Object previousProcessTxId, JSONObject who, JSONObject where, JSONObject when, JSONObject thing) {
		JSONObject param = new JSONObject();
		param.put("public_key", publicKey);
		param.put("previous_process_tx_id", previousProcessTxId);
		param.put("who", who);
		param.put("where", where);
		param.put("when", when);
		param.put("thing", thing);
		return param;
	}
	
	public static JSONObject generateTransferParam(String originatorPublicKey, String originatorPrivateKey, String recipientPublicKey, Object previousProcessTxId, JSONObject who, JSONObject where, JSONObject when, JSONObject thing) {
		JSONObject param = new JSONObject();
		param.put("tx_originator_public_key", originatorPublicKey);
		param.put("tx_originator_private_key", originatorPrivateKey);
		param.put("tx_recipient_public_key", recipientPublicKey);
		param.put("previous_process_tx_id", previousProcessTxId);
		param.put("who", who);
		param.put("where", where);
		param.put("when", when);
		param.put("thing", thing);
		return param;
	}
	
	public static String ChineseToUnicode(String s) {
		String as[] = new String[s.length()];
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
			s1 = s1 + "\\u" + as[i];
		}
		return s1;
	}
	
	public static String UnicodeToChinese(String string) {
		String str = string.replace("\\u", ",");
		String[] s2 = str.split(",");
		String s1 = "";
		for (int i = 1; i < s2.length; i++) {
			s1 = s1 + (char) Integer.parseInt(s2[i], 16);
		}
		return s1;
	}
}

