package com.tulingchain.restful.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestUtils {
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
	
	public static JSONObject generateBill(String billOperationName,int operationId,
			String signer,int signeerid,String billNumber,String payee,int payeeId,String billMoneyType,int moneySum ,
			String discountingOrg,int dsicountingORgid,String expireDate,String transferOrg,String earlygetRate,String earlygetDate) {
		JSONObject param = new JSONObject();
		String type=RestUtils.ChineseToUnicode("商业票据");
		param.put("Bill_type_name",type);
		param.put("Bill_type_id","1" );
		param.put("Bill_operation_name", billOperationName);
		param.put("Bill_operation_typeid", operationId);
		param.put("Bill_id", billNumber);
		param.put("Bill_operator_name", signer);
		param.put("Bill_operator_id", signeerid);//1
		
		param.put("Bill_receiver_name", payee);
		param.put("Bill_receiver_id",payeeId );//1
		param.put("Bill_amount_money_type",billMoneyType );
		param.put("Bill_amount_money", moneySum);
		
		param.put("Guarantee_organization_name", discountingOrg);
		param.put("Guarantee_organization_id",dsicountingORgid );
		param.put("Bill_outdate", expireDate);
		param.put("Bill_transfer_to",transferOrg);
		param.put("Bill_earlyget_rate", earlygetRate);
		param.put("Bill_earlyget_date", earlygetDate);
		param.put("Bill_trigger_condition", null);
		
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
	
	//票据create
	public static JSONObject generateBillCreateParam(String originatorPublicKey, JSONObject bill) {
		JSONObject param = new JSONObject();
		bill.put("Bill_after_operation","create" );
		param.put("origin_pubk", originatorPublicKey);
		param.put("bill", bill);
		return param;
	}
	
	
	//票据transfer
	public static JSONObject generateBillTransferParam(String originatorPublicKey, String originatorPrivateKey, String recipientPublicKey, String previousProcessTxId, JSONObject bill) {
		JSONObject param = new JSONObject();
		bill.put("Bill_after_operation","transfer" );
		param.put("origin_pubk", originatorPublicKey);
		param.put("origin_prik", originatorPrivateKey);
		param.put("receive_pubk", recipientPublicKey);
		param.put("pre_txid", previousProcessTxId);
		param.put("bill", bill);
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
	
	public static  String getToken(){
		HttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost("http://114.55.233.230/api-token-auth/");
		post.addHeader("content-type", "application/x-www-form-urlencoded");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		nvps.add(new BasicNameValuePair("username", "admin"));
		nvps.add(new BasicNameValuePair("password", "justletmein"));
		HttpResponse response=null;	
		BufferedReader br=null;
		JSONObject obj=null;
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps));
			response=client.execute(post);
			br=new BufferedReader(new InputStreamReader(response.getEntity().getContent())); 
			String res=br.readLine();
			obj=JSON.parseObject(res);
			return obj.getString("token");
		} catch (Exception e) {
			return new JSONObject().put("error", "token is error").toString();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(RestUtils.getToken());
	}
}

