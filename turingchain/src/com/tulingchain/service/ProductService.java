package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Product;

public interface ProductService {

	public void save(Product product);
	
	public List<Product> listAll(int sellerId);
	
	public Product getProdById(int id);

	public List<Product> listProdById(int id);

	public String getProdCount(int id);

	public List<Product> listTransProdById(int id);
	
	public Product getProdPurchaserById(int id);
}
