package com.tulingchain.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.ProductMapper;
import com.tulingchain.mapper.PurchaseMapper;
import com.tulingchain.model.Noder;
import com.tulingchain.model.Product;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.ProductService;
import com.tulingchain.utils.TransforCode;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private NoderMapper noderMapper;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Override
	public void save(Product product) {
		
        purchaseMapper.updateState(product.getPurchaseId());
		
        //SOAP开始
        ReadClient readClient=null;
		JSONObject txOriginatorKeyPair=null;
		try {
			readClient= new ReadClient();
			txOriginatorKeyPair= readClient.getKeyPair();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int transportId = noderMapper.getNoderByComNum(product.getTransComNum()).getId();
		product.setTransportId(transportId);
		product.setState("未确认");
		product.setSendDate(new Date());
		product.setTxPubKeyPair(txOriginatorKeyPair.getString("public_key"));
		product.setTxPrivKeyPair(txOriginatorKeyPair.getString("private_key"));
		
		Noder noder = noderMapper.getNoderById(product.getSellerId());
		
		String companyId = String.valueOf(noder.getCompanyId());
		String companyName = noder.getCompanyName();
		String uCompanyId = String.valueOf(noder.getCompanyId());
		String userId = product.getPrincipalNum();
		String userName = product.getPrincipalName();
		String userType = "type";
		JSONObject whoGoto = RestUtils.generateWhoItem( companyId , companyName , uCompanyId, userId, userName , userType);
		JSONObject whoOriginal = null;
		JSONObject who = RestUtils.generateWho(whoOriginal, whoGoto);
		
		String region =TransforCode.chinese2Encoding(noder.getNoderCity());
		String place = TransforCode.chinese2Encoding(noder.getNoderProvince());
		String nation = TransforCode.chinese2Encoding("中国");
		
		JSONObject whereGoto = RestUtils.generateWhereItem(nation, place, region, "0755");
		JSONObject whereOriginal = null;
		JSONObject where = RestUtils.generateWhere(whereOriginal, whereGoto);
		
		String makeDate = product.getProductDate().toString();
		String expireDate = product.getExpirationDate().toString();
		System.out.println(makeDate +"+++"+expireDate);
		
		JSONObject when = RestUtils.generateWhen(makeDate, null, null, expireDate);
		//JSONObject when = RestUtils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		
		String thingTypeId = "2";
		String thingTypeName = "产品";
		String thingId = product.getProductNum();
		String thingName = product.getProductName();
		String originPlace = TransforCode.chinese2Encoding(noder.getNoderCity());
		String thingOrderQuantity = product.getProductQuantity();
		String price =product.getPrice();		
		
		JSONObject thing = RestUtils.generateThing(thingTypeId, thingTypeName, thingId, thingName, originPlace, thingOrderQuantity, "1", price);
		JSONObject object=null;
		try {
			object=RestWriteClient.createTransaction(txOriginatorKeyPair.getString("public_key"), who, where, when, thing);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		product.setBlockId(object.getString("id"));
		productMapper.save(product);
	}

	@Override
	public List<Product> listAll(int sellerId) {
		return productMapper.listAll(sellerId);
	}

	@Override
	public Product getProdById(int id) {
		return productMapper.getProdById(id);
	}
	
	@Override
	public Product getProdPurchaserById(int id) {
		return productMapper.getProdPurchaserById(id);
	}
	
	@Override
	public List<Product> listProdById(int id) {
		return productMapper.listProdById(id);
	}

	@Override
	public String getProdCount(int id) {
		return productMapper.getProdCount(id);
	}

	@Override
	public List<Product> listTransProdById(int id) {
		return productMapper.listTransProdById(id);
	}

}
