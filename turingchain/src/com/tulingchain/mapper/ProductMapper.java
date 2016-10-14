package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.Product;

public interface ProductMapper {

	public void save(Product product);
	
	public List<Product> listAll(int sellerId);
	
	public Product getProdById(int id);

	public List<Product> listProdById(int id);

	public String getProdCount(int id);

	public List<Product> listTransProdById(int id);
	
	public Product getProdSellerById(int id);
	
	public Product getProdPurchaserById(int id);
	
	public Product getProdByPurchaseId(int id);
	
	public void updateState(int id);
	
	public void updateTxId(String txId);
	
}
