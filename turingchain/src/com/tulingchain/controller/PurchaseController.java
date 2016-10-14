package com.tulingchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tulingchain.model.Purchase;
import com.tulingchain.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired 
	private PurchaseService purchaseService;
	
	@RequestMapping(value="/purchase",method=RequestMethod.POST)
	public @ResponseBody String save(@RequestBody Purchase purchase){
		
		System.out.println("==" + purchase);
		purchaseService.save(purchase);
		return JSON.toJSONString("{submit:'ok'}");
	}
	
	@RequestMapping(value="/purchase/{id}",method=RequestMethod.GET)
	public @ResponseBody String getSellerCount(@PathVariable("id") int id){
		return purchaseService.getSellerCount(id);
	}

	@RequestMapping(value="/listPurchase/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Purchase> listPurchase(@PathVariable("id") int id){
		return purchaseService.listPurchaseById(id);
	}
	
	@RequestMapping(value="/getPurchaseById/{id}",method=RequestMethod.GET)
	public @ResponseBody Purchase getPurchase(@PathVariable("id") int id){
		return purchaseService.getPurchaseById(id);
	}
}
