package com.tulingchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulingchain.model.Product;
import com.tulingchain.service.ProductService;

@Controller
public class ProductController {
	@Autowired 
	private ProductService productService;
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public @ResponseBody String save(@RequestBody Product product){
		System.out.println("==" + product);
		productService.save(product);
		return "注册成功";
	}
	
	@RequestMapping(value="/product/{sellerId}",method=RequestMethod.GET)
	public @ResponseBody List<Product> list(@PathVariable("sellerId") int sellerId){
		return productService.listAll(sellerId);
	}
	
	@RequestMapping(value="/getProd/{id}",method=RequestMethod.GET)
	public @ResponseBody Product getProd(@PathVariable("id") int id){
		System.out.println(productService.getProdById(id));
		return productService.getProdById(id);
	}
	
	@RequestMapping(value="/getProdPurc/{id}",method=RequestMethod.GET)
	public @ResponseBody Product getProdPurc(@PathVariable("id") int id){
		System.out.println(productService.getProdPurchaserById(id));
		return productService.getProdPurchaserById(id);
	}
	
	@RequestMapping(value="/listProd/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Product> listProd(@PathVariable("id") int id){
		return productService.listProdById(id);
	}
	
	@RequestMapping(value="/transProdCount/{id}",method=RequestMethod.GET)
	public @ResponseBody String transProdCount(@PathVariable("id") int id){
		return productService.getProdCount(id);
	}
	
	
	@RequestMapping(value="/listTransProd/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Product> listTransProd(@PathVariable("id") int id){
		return productService.listTransProdById(id);
	}
}
