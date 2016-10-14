package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Purchase;

public interface PurchaseService {

	public void save(Purchase purchase);
	
	public List<Purchase> listAll();

	public String getSellerCount(int id);

	public List<Purchase> listPurchaseById(int id);
	
	public Purchase getPurchaseById(int id);
	
}
