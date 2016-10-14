package com.tulingchain.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.PurchaseMapper;
import com.tulingchain.model.Noder;
import com.tulingchain.model.Purchase;
import com.tulingchain.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Autowired
	private NoderMapper noderMapper;
	
	@Override
	public void save(Purchase purchase) {
		
		//通过公司名称从 noder_ 表中获取sellerId(卖家id)
		int sellerId = noderMapper.getNoderByComId(purchase.getSellerComNum());
		purchase.setPurchaseDate(new Date());
		purchase.setSellerId(sellerId);
		//交易状态是未确认
		purchase.setState("未确认");
		
		purchaseMapper.save(purchase);
	}
	
	@Override
	public List<Purchase> listAll() {
		return purchaseMapper.listAll();
	}

	@Override
	public String getSellerCount(int id) {
		return purchaseMapper.getSellerCount(id);
	}

	@Override
	public List<Purchase> listPurchaseById(int id) {
		
		System.out.println(purchaseMapper.listPurchaseById(id));
		
		return purchaseMapper.listPurchaseById(id);
	}

	@Override
	public Purchase getPurchaseById(int id) {
		return purchaseMapper.getPurchaseById(id);
	}
public static void main(String[] args) {
	PurchaseServiceImpl impl=new PurchaseServiceImpl();
	System.out.println(impl.listAll());
}	

}
