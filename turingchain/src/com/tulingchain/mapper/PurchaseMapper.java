package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.Purchase;

public interface PurchaseMapper {

	public void save(Purchase purchase);
	
	public List<Purchase> listAll();

	public String getSellerCount(int id);

	public List<Purchase> listPurchaseById(int sellerId);

	public Purchase getPurchaseById(int id);

	public void updateState(int purchaseid);

}
