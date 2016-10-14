package com.tulingchain.soap.rpc;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.tulingchain.soap.schema.write.Thing;
import com.tulingchain.soap.schema.write.When;
import com.tulingchain.soap.schema.write.Where;
import com.tulingchain.soap.schema.write.WhereItem;
import com.tulingchain.soap.schema.write.Who;
import com.tulingchain.soap.schema.write.WhoItem;

public class Utils {
	
	public static final String SERVICE_QNAME = "com.examples.rpc";
	public static final String MODEL_QNAME = "soap_rpc.models";

	public static WhoItem generateWhoItem(String companyId, String companyName, String uCompanyId, String userId, String userName, String userType) {
		WhoItem whoItem = new WhoItem();
		whoItem.setCompanyId(new JAXBElement<String>(new QName(MODEL_QNAME, "company_id"), String.class, companyId));
		whoItem.setCompanyName(new JAXBElement<String>(new QName(MODEL_QNAME, "company_name"), String.class, Utils.ChineseToUnicode(companyName)));
		whoItem.setUCompanyId(new JAXBElement<String>(new QName(MODEL_QNAME, "u_company_id"), String.class, uCompanyId));
		whoItem.setUserId(new JAXBElement<String>(new QName(MODEL_QNAME, "user_id"), String.class, userId));
		whoItem.setUserName(new JAXBElement<String>(new QName(MODEL_QNAME, "user_name"), String.class, Utils.ChineseToUnicode(userName)));
		whoItem.setUserType(new JAXBElement<String>(new QName(MODEL_QNAME, "user_type"), String.class, userType));
		return whoItem;
	}
	
	public static WhereItem generateWhereItem(String nation, String place, String region, String regionId) {
		WhereItem whereItem = new WhereItem();
		whereItem.setNation(new JAXBElement<String>(new QName(MODEL_QNAME, "nation"), String.class, nation));
		whereItem.setPlace(new JAXBElement<String>(new QName(MODEL_QNAME, "place"), String.class, place));
		whereItem.setRegion(new JAXBElement<String>(new QName(MODEL_QNAME, "region"), String.class, region));
		whereItem.setRegionId(new JAXBElement<String>(new QName(MODEL_QNAME, "region_id"), String.class, regionId));
		return whereItem;
	}
	
	public static When generateWhen(String makeDate, String sendDate, String receiveDate, String expireDate) {
		When when = new When();
		when.setMakeDate(new JAXBElement<String>(new QName(MODEL_QNAME, "make_date"), String.class, makeDate));
		when.setSendDate(new JAXBElement<String>(new QName(MODEL_QNAME, "send_date"), String.class, sendDate));
		when.setReceiveDate(new JAXBElement<String>(new QName(MODEL_QNAME, "receive_date"), String.class, receiveDate));
		when.setExpireDate(new JAXBElement<String>(new QName(MODEL_QNAME, "expire_date"), String.class, expireDate));
		return when;
	}
	
	public static Thing generateThing(String thingTypeId, String thingTypeName, String thingId, String thingName, String originPlace, String thingOrderQuantity, String thingOrderBatch, String price) {
		Thing thing = new Thing();
		thing.setThingTypeId(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_type_id"), String.class, thingTypeId));
		thing.setThingTypeName(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_type_name"), String.class, Utils.ChineseToUnicode(thingTypeName)));
		thing.setThingId(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_id"), String.class, thingId));
		thing.setThingName(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_name"), String.class, Utils.ChineseToUnicode(thingName)));
		thing.setOriginPlace(new JAXBElement<String>(new QName(MODEL_QNAME, "origin_place"), String.class, originPlace));
		thing.setThingOrderQuantity(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_order_quantity"), String.class, thingOrderQuantity));
		thing.setThingOrderBatch(new JAXBElement<String>(new QName(MODEL_QNAME, "thing_order_batch"), String.class, thingOrderBatch));
		thing.setPrice(new JAXBElement<String>(new QName(MODEL_QNAME, "price"), String.class, price));
		return thing;
	}
	
	public static Who generateWho(WhoItem whoOriginal, WhoItem whoGoto) {
		Who who = new Who();
		who.setOriginal(new JAXBElement<WhoItem>(new QName(MODEL_QNAME, "original"), WhoItem.class, whoOriginal));
		who.setGoto(new JAXBElement<WhoItem>(new QName(MODEL_QNAME, "goto"), WhoItem.class, whoGoto));
		return who;
	}
	
	public static Where generateWhere(WhereItem whereOriginal, WhereItem whereGoto) {
		Where where = new Where();
		where.setOriginal(new JAXBElement<WhereItem>(new QName(MODEL_QNAME, "original"), WhereItem.class, whereOriginal));
		where.setGoto(new JAXBElement<WhereItem>(new QName(MODEL_QNAME, "goto"), WhereItem.class, whereGoto));
		return where;
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
