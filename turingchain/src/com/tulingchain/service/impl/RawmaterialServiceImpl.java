package com.tulingchain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.PurchaseMapper;
import com.tulingchain.mapper.RawmaterialMapper;
import com.tulingchain.model.Noder;
import com.tulingchain.model.Rawmaterial;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestUtils;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.RawmaterialService;
import com.tulingchain.utils.TransforCode;

@Service
public class RawmaterialServiceImpl implements RawmaterialService {

	@Autowired
	private RawmaterialMapper rawmaterialMapper;
	
	@Autowired
	private NoderMapper noderMapper;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Override
	public void save(Rawmaterial rawmaterial) {
		
		purchaseMapper.updateState(rawmaterial.getPurchaseId());
		ReadClient readClient=null;
		JSONObject txOriginatorKeyPair=null;
		try {
			readClient= new ReadClient();
			txOriginatorKeyPair= readClient.getKeyPair();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		int transportId = noderMapper.getNoderByComNum(rawmaterial.getTransComNum()).getId();
		System.out.println(transportId);
		
		rawmaterial.setTransportId(transportId);
		rawmaterial.setState("未确认");
		rawmaterial.setSendDate(new Date());
		rawmaterial.setTxPubKeyPair(txOriginatorKeyPair.getString("public_key"));
		rawmaterial.setTxPrivKeyPair(txOriginatorKeyPair.getString("private_key"));
		System.out.println(txOriginatorKeyPair.getString("public_key"));
		System.out.println(txOriginatorKeyPair.getString("private_key"));
		
		
		Noder noder = noderMapper.getNoderById(rawmaterial.getSellerId());
		//生成whoGoto
		String companyId = String.valueOf(noder.getCompanyId());
		String companyName = noder.getCompanyName();
		String uCompanyId = String.valueOf(noder.getCompanyId());
		String userId = rawmaterial.getPrincipalNum();
		String userName = rawmaterial.getPrincipalName();
		String userType = "type";
		
		
		
		JSONObject whoGoto = RestUtils.generateWhoItem( companyId , companyName , uCompanyId, userId, userName , userType);
		JSONObject whoOriginal = null;
		JSONObject who = RestUtils.generateWho(whoOriginal, whoGoto);
		
		//生成whereGoto
		String region =TransforCode.chinese2Encoding(noder.getNoderCity());
		String place = TransforCode.chinese2Encoding(noder.getNoderProvince());
		String nation = TransforCode.chinese2Encoding("中国");
		
		JSONObject whereGoto = RestUtils.generateWhereItem(nation, place, region, "0755");
		JSONObject whereOriginal = null;
		JSONObject where = RestUtils.generateWhere(whereOriginal, whereGoto);
		
		String makeDate = rawmaterial.getProductedDate().toString();
		String expireDate = rawmaterial.getExpirationDate().toString();
		System.out.println(makeDate +"+++"+expireDate);
		
		JSONObject when = RestUtils.generateWhen(makeDate, null, null, expireDate);
		//When when = Utils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		
		String thingTypeId = "1";
		String thingTypeName = "原材料";
		String thingId = rawmaterial.getRawmNum();
		String thingName = rawmaterial.getRawmName();
		String originPlace = TransforCode.chinese2Encoding(rawmaterial.getOrigin());
		String thingOrderQuantity = rawmaterial.getProductQuantity();
		String price =rawmaterial.getPrice();		
		
		JSONObject thing = RestUtils.generateThing(thingTypeId, thingTypeName, thingId, thingName, originPlace, thingOrderQuantity, "1", price);
		//创建createTransaction
		JSONObject object=null;
		try {
			object=RestWriteClient.createTransaction(txOriginatorKeyPair.getString("public_key"),who, where, when, thing);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String id=object.getString("id");
		//将产生的区块id放到数据库里
		rawmaterial.setBlockId(id);
		rawmaterialMapper.save(rawmaterial);
	}

	@Override
	public List<Rawmaterial> listAll(int sellerId) {
		return rawmaterialMapper.listAll(sellerId);
	}

	@Override
	public Rawmaterial getRawmById(int id) {
		return rawmaterialMapper.getRawmById(id);
	}
	
	@Override
	public Rawmaterial getRawmPurchaserById(int id) {
		return rawmaterialMapper.getRawmPurchaserById(id);
	}
	
	@Override
	public List<Rawmaterial> listRawmById(int id) {
		return rawmaterialMapper.listRawmById(id);
	}

	@Override
	public String getRawmCount(int id) {
		return rawmaterialMapper.getRawmCount(id);
	}

	@Override
	public List<Rawmaterial> listTransRawmById(int id) {
		return rawmaterialMapper.listTransRawmById(id);
	}

}
