package com.tulingchain.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.ProductMapper;
import com.tulingchain.mapper.RawmaterialMapper;
import com.tulingchain.mapper.TransportMapper;
import com.tulingchain.model.Noder;
import com.tulingchain.model.Product;
import com.tulingchain.model.Rawmaterial;
import com.tulingchain.model.Transport;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.TransportService;

import com.tulingchain.utils.TransforCode;

@Service
public class TransportServiceImpl implements TransportService {

	@Autowired
	private NoderMapper noderMapper;
	
	@Autowired
	private TransportMapper transportMapper;
	
	@Autowired
	private RawmaterialMapper rawmaterialMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public void save(Transport transport) {
		/*
		 *  将一个物流信息放进数据库，状态为"未确认"
		 */
		transport.setSentDate(new Date());
		transport.setState("未确认");
		
		transportMapper.save(transport);
	}
	
	
	/*
	 * 原材料发货给生产商，物流接受请求，并设置状态为未确认，由生产商确认收货，来确认状态
	 * 产生 
	 * 
	 */
	
	@Override
	public void saveRawm(Transport transport) {
		
		ReadClient readClient=null;
		JSONObject txOriginatorKeyPair=null;
		try {
			readClient= new ReadClient();
			txOriginatorKeyPair= readClient.getKeyPair();
		} catch (Exception e) {
		}
		
		JSONObject txRecipientKeyPair=null;
		try {
			txRecipientKeyPair = readClient.getKeyPair();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		transport.setSentDate(new Date());
		transport.setState("未确认");
		transport.setArticleType("原材料");
		Date receiveDate = new Date();
		transport.setReceiveDate(receiveDate);
		//获取公钥私钥 
		transport.setTxPubKeyPair(txOriginatorKeyPair.getString("public_key"));
		transport.setTxPrivKeyPair(txOriginatorKeyPair.getString("private_key"));
		
		rawmaterialMapper.updateState(transport.getPurchaseId());
		
		Rawmaterial rawm = rawmaterialMapper.getRawmByPurchaseId(transport.getPurchaseId());
		
		Noder sellerNoder = noderMapper.getNoderById(transport.getSellerId());
		Noder transNoder = noderMapper.getNoderById(transport.getTransportId());
		
		System.out.println(rawm);
		System.out.println(sellerNoder);
		System.out.println(transNoder);
		
		//生成who
		String companyId = String.valueOf(transNoder.getCompanyId());
		String companyName = transNoder.getCompanyName();
		String uCompanyId = String.valueOf(transNoder.getCompanyId());
		String userId = transport.getSenderNum();
		String userName = transport.getSenderName();
		String userType = "type";
		
		String companyId1 = String.valueOf(sellerNoder.getCompanyId());
		String companyName1 = sellerNoder.getCompanyName();
		String uCompanyId1 = String.valueOf(sellerNoder.getCompanyId());
		String userId1 = rawm.getPrincipalNum();
		String userName1 = rawm.getPrincipalName();
		String userType1 = "type";
		
		JSONObject  whoOriginal= RestUtils.generateWhoItem( companyId1 , companyName1 , uCompanyId1, userId1, userName1 , userType1);
		JSONObject  whoGoto= RestUtils.generateWhoItem( companyId , companyName , uCompanyId, userId, userName , userType);
		
		JSONObject who = RestUtils.generateWho(whoOriginal,whoGoto);
		
		//生成where
		String region =TransforCode.chinese2Encoding(transNoder.getNoderCity());
		String place = TransforCode.chinese2Encoding(transNoder.getNoderProvince());
		String nation = TransforCode.chinese2Encoding("中国");
		
		String region1 =TransforCode.chinese2Encoding(sellerNoder.getNoderCity());
		String place1 = TransforCode.chinese2Encoding(sellerNoder.getNoderProvince());
		String nation1 = TransforCode.chinese2Encoding("中国");
		
		JSONObject  whereOriginal = RestUtils.generateWhereItem(nation1, place1, region1, "0755");
		JSONObject whereGoto = RestUtils.generateWhereItem(nation, place, region, "0756");
		
		JSONObject where = RestUtils.generateWhere(whereOriginal,whereGoto);
		
		//生成when
		String makeDate = rawm.getProductedDate().toString();
		String expireDate = rawm.getExpirationDate().toString();
		String sendDate = rawm.getSendDate().toString();
		
		JSONObject when = RestUtils.generateWhen(makeDate, sendDate, receiveDate.toString(), expireDate);
		//When when = Utils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		
		
		//生成thing
		String thingTypeId = "1";
		String thingTypeName = "原材料";
		String thingId = rawm.getRawmNum();
		String thingName = rawm.getRawmName();
		String originPlace = TransforCode.chinese2Encoding(rawm.getOrigin());
		String thingOrderQuantity = rawm.getNumber();
		String price =rawm.getPrice();		
		JSONObject thing = RestUtils.generateThing(thingTypeId, thingTypeName, thingId, thingName, originPlace, thingOrderQuantity, "1", price);
		
		System.out.println("==============================================="+rawm.getBlockId());
		JSONObject result = null;
		try {
			result = RestWriteClient.transferTransaction(rawm.getTxPubKeyPair(), rawm.getTxPrivKeyPair(),txRecipientKeyPair.getString("public_key"),rawm.getBlockId(),who,where, when, thing);
			if (result.getString("id")==null) {
				return;
			} else {
				System.out.println("Transfer transaction id: " + result.getString("id"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rawmaterialMapper.updateTxId(result.getString("id"));
		 
		transportMapper.save(transport);
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
	
		JSONObject whoOriginal = RestUtils.generateWhoItem(null,null, null, null, null, null);
       JSONObject whoGoto = RestUtils.generateWhoItem("000001", RestUtils.ChineseToUnicode("图灵"), "000001", "000001",RestUtils.ChineseToUnicode("李雷"), "3");
       JSONObject whereOriginal = RestUtils.generateWhereItem(null, null, null, null);
       JSONObject whereGoto = RestUtils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
       JSONObject who = RestUtils.generateWho(whoOriginal, whoGoto);
       JSONObject where = RestUtils.generateWhere(whereOriginal, whereGoto);
       JSONObject when = RestUtils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
       JSONObject thing = RestUtils.generateThing("1", RestUtils.ChineseToUnicode("类型"), "1", RestUtils.ChineseToUnicode("玻璃"), "shenzhen", "100", "1", "12");
		JSONObject result = RestWriteClient.transferTransaction("CJ2Ev2UQsVzNGeQ2k6ic11UGBAcRGXiAGW8fq2A7Jd7q", "7h4mhqMzZRyWvBVcvsrcuBbmnXHcZV1Wo9aPygAEFCZN","7h4mhqMzZRyWvBVcvsrcuBbmnXHcZV1Wo9aPygAEFCZN","Ad1LxG5XXqTZYMDnP4dboPd6xgFxAQ8qh6qh8C8vt8Gj",who,where,when,thing);
		System.out.println(result);
	}
	
	
	
	@Override
	public void saveProd(Transport transport) {
		
		ReadClient readClient=null;
		JSONObject txOriginatorKeyPair=null;
		try {
			readClient= new ReadClient();
			txOriginatorKeyPair= readClient.getKeyPair();
		} catch (Exception e) {
		}
		
		JSONObject txRecipientKeyPair=null;
		try {
			txRecipientKeyPair = readClient.getKeyPair();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		transport.setSentDate(new Date());
		transport.setState("未确认");
		transport.setArticleType("产品");
		Date receiveDate = new Date();
		transport.setReceiveDate(receiveDate);
		transport.setTxPubKeyPair(txOriginatorKeyPair.getString("public_key"));
		transport.setTxPrivKeyPair(txOriginatorKeyPair.getString("private_key"));
		
		
		
		productMapper.updateState(transport.getPurchaseId());
		
		Product prod = productMapper.getProdByPurchaseId(transport.getPurchaseId());
		
		Noder sellerNoder = noderMapper.getNoderById(transport.getSellerId());
		Noder transNoder = noderMapper.getNoderById(transport.getTransportId());
		
		System.out.println(prod);
		System.out.println(sellerNoder);
		System.out.println(transNoder);
		//生成who
		String companyId = String.valueOf(transNoder.getCompanyId());
		String companyName = transNoder.getCompanyName();
		String uCompanyId = String.valueOf(transNoder.getCompanyId());
		String userId = transport.getSenderNum();
		String userName = transport.getSenderName();
		String userType = "type";
		
		String companyId1 = String.valueOf(sellerNoder.getCompanyId());
		String companyName1 = sellerNoder.getCompanyName();
		String uCompanyId1 = String.valueOf(sellerNoder.getCompanyId());
		String userId1 = prod.getPrincipalNum();
		String userName1 = prod.getPrincipalName();
		String userType1 = "type";
		
		JSONObject whoOriginal = RestUtils.generateWhoItem( companyId1 , companyName1 , uCompanyId1, userId1, userName1 , userType1);
		JSONObject whoGoto= RestUtils.generateWhoItem( companyId , companyName , uCompanyId, userId, userName , userType);
		
		JSONObject who = RestUtils.generateWho(whoOriginal,whoGoto);

		String region =TransforCode.chinese2Encoding(transNoder.getNoderCity());
		String place = TransforCode.chinese2Encoding(transNoder.getNoderProvince());
		String nation = TransforCode.chinese2Encoding("中国");
		
		String region1 =TransforCode.chinese2Encoding(sellerNoder.getNoderCity());
		String place1 = TransforCode.chinese2Encoding(sellerNoder.getNoderProvince());
		String nation1 = TransforCode.chinese2Encoding("中国");
		
		JSONObject whereOriginal = RestUtils.generateWhereItem(nation1, place1, region1, "0755");
		JSONObject whereGoto = RestUtils.generateWhereItem(nation, place, region, "0756");
		
		JSONObject where = RestUtils.generateWhere(whereOriginal,whereGoto);
		
		String makeDate = prod.getProductDate().toString();
		String expireDate = prod.getExpirationDate().toString();
		String sendDate = prod.getSendDate().toString();
		
		JSONObject when = RestUtils.generateWhen(makeDate, sendDate, receiveDate.toString(), expireDate);
		//When when = Utils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		
		String thingTypeId = "2";
		String thingTypeName = "产品";
		String thingId = prod.getProductNum();
		String thingName = prod.getProductName();
		String originPlace = TransforCode.chinese2Encoding(sellerNoder.getNoderCity());
		String thingOrderQuantity = prod.getNumber();
		String price =prod.getPrice();		
		
		JSONObject thing = RestUtils.generateThing(thingTypeId, thingTypeName, thingId, thingName, originPlace, thingOrderQuantity, "1", price);
		
		JSONObject result=null;
		try {
			result = RestWriteClient.transferTransaction(prod.getTxPubKeyPair(), prod.getTxPrivKeyPair(), txRecipientKeyPair.getString("public_key"), prod.getBlockId(),who, where, when, thing);
			if (result.getShort("id")==null) {
				return;
			} else {
				System.out.println("Transfer transaction id: " + result.getString("id"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//将生成的transferTx放入数据库
		productMapper.updateTxId(result.getString("id"));
		
		transportMapper.save(transport);
	}
	
	@Override
	public List<Transport> listAll() {
		return transportMapper.listAll();
	}
	
	public String getTransCount(int id){
		return transportMapper.getTransCount(id);
	}

	@Override
	public List<Transport> listDelivery(int id) {
		return transportMapper.listDelivery(id);
	}

	@Override
	public Transport getTransPurchase(int id) {
		return transportMapper.getTransPurchase(id);
	}

	@Override
	public Transport getTransTransport(int id) {
		return transportMapper.getTransTransport(id);
	}

	@Override
	public Transport getTransPurchaser(int id) {
		return transportMapper.getTransPurchaser(id);
	}

	@Override
	public Transport getTransSeller(int id) {
		return transportMapper.getTransSeller(id);
	}

	@Override
	public void updateDelivery(Transport transport) {
		
		ReadClient readClient=null;
		JSONObject customerKeyPair=null;
		try {
			readClient= new ReadClient();
			customerKeyPair= readClient.getKeyPair();
		} catch (Exception e) {
		}
		
		try {
			customerKeyPair = readClient.getKeyPair();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		Date receiveDate = new Date();
		transport.setDeliveryDate(receiveDate);
		
		Noder transNoder = noderMapper.getNoderById(transport.getTransportId());
		Noder purchaserNoder = noderMapper.getNoderById(transport.getPurchaserId());
		
		Transport trans = transportMapper.getTransByID(transport.getId());
		System.out.println("trasnsport=="+trans);
		
		String thingTypeId = null;
		String thingTypeName = null;
		String thingId = null;
		String thingName = null;
		String originPlace = null;
		String thingOrderQuantity = null;
		String price = null;
		String makeDate = null;
		String expireDate = null;
		String previous=null;
		
		if(transport.getArticleType().equals("原材料")){
			Rawmaterial article = rawmaterialMapper.getRawmByPurchaseId(transport.getPurchaseId());
			 
			thingTypeId = "1";
			thingTypeName = "原材料";
			thingId = article.getRawmNum();
			thingName = article.getRawmName();
			originPlace = TransforCode.chinese2Encoding(transNoder.getNoderCity());
			thingOrderQuantity = article.getNumber();
			price =article.getPrice();
			makeDate = article.getProductedDate().toString();
			expireDate = article.getExpirationDate().toString();
			previous=article.getTxId();
			
			System.out.println("原材料: "+article);
		}else {
			Product article = productMapper.getProdByPurchaseId(transport.getPurchaseId());
			
			thingTypeId = "2";
			thingTypeName = "产品";
			thingId = article.getProductNum();
			thingName = article.getProductName();
			originPlace = TransforCode.chinese2Encoding(transNoder.getNoderCity());
			thingOrderQuantity = article.getNumber();
			price = article.getPrice();
			makeDate = article.getProductDate().toString();
			expireDate = article.getExpirationDate().toString();
			previous=article.getTxId();
			
			System.out.println("产品: "+article);
		}
		
		
		
		System.out.println(transNoder);
		System.out.println(purchaserNoder);
		
		String companyId = String.valueOf(transNoder.getCompanyId());
		String companyName = transNoder.getCompanyName();
		String uCompanyId = String.valueOf(transNoder.getCompanyId());
		String userId = trans.getSenderNum();
		String userName = trans.getSenderName();
		String userType = "type";
		
		String companyId1 = String.valueOf(purchaserNoder.getCompanyId());
		String companyName1 = purchaserNoder.getCompanyName();
		String uCompanyId1 = String.valueOf(purchaserNoder.getCompanyId());
		String userId1 = transport.getRecipientNum();
		String userName1 = transport.getRecipientName();
		String userType1 = "type";
		
		JSONObject whoOriginal = RestUtils.generateWhoItem( companyId , companyName , uCompanyId, userId, userName , userType);
		JSONObject whoGoto = RestUtils.generateWhoItem( companyId1 , companyName1 , uCompanyId1, userId1, userName1 , userType1);
		
		JSONObject who = RestUtils.generateWho(whoOriginal,whoGoto);

		String region =TransforCode.chinese2Encoding(transNoder.getNoderCity());
		String place = TransforCode.chinese2Encoding(transNoder.getNoderProvince());
		String nation = TransforCode.chinese2Encoding("中国");
		
		String region1 =TransforCode.chinese2Encoding(purchaserNoder.getNoderCity());
		String place1 = TransforCode.chinese2Encoding(purchaserNoder.getNoderProvince());
		String nation1 = TransforCode.chinese2Encoding("中国");
		
		JSONObject whereOriginal = RestUtils.generateWhereItem(nation, place, region, "0756");
		JSONObject whereGoto = RestUtils.generateWhereItem(nation1, place1, region1, "0757");
		
		JSONObject where = RestUtils.generateWhere(whereOriginal,whereGoto);
		
		String sendDate = trans.getSentDate().toString();
		
		JSONObject when = RestUtils.generateWhen(makeDate, sendDate, receiveDate.toString(), expireDate);
		
		JSONObject thing = RestUtils.generateThing(thingTypeId, thingTypeName, thingId, thingName, originPlace, thingOrderQuantity, "1", price);
		
		JSONObject result=null;
		try {
			result = RestWriteClient.transferTransaction(trans.getTxPubKeyPair(),trans.getTxPrivKeyPair(), customerKeyPair.getString("public_key"),previous,who, where, when, thing);
			if (result.getString("id")==null) {
				return;
			} else {
				System.out.println("Transfer transaction id: " + result.getString("id"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		transportMapper.updateTxId(result.getString("id"));
		transportMapper.updateDelivery(transport);
	}

	@Override
	public List<Transport> listDelivered(int id) {
		return transportMapper.listDelivered(id);
	}

	


}
