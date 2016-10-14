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
import com.tulingchain.model.Transport;
import com.tulingchain.service.TransportService;

@Controller
public class TransportController {
	@Autowired 
	private TransportService transportService;
	
	@RequestMapping(value="/addRawmTrans",method=RequestMethod.POST)
	public @ResponseBody String saveRawm(@RequestBody Transport transport){
		
		System.out.println("Rawm==" + transport);
		transportService.saveRawm(transport);
//		return "注册成功";
		return JSON.toJSONString("{submit:'ok'}");
	}
	
	@RequestMapping(value="/addProdTrans",method=RequestMethod.POST)
	public @ResponseBody String saveProd(@RequestBody Transport transport){
		
		System.out.println("Prod==" + transport);
		transportService.saveProd(transport);
//		return "注册成功";
		return JSON.toJSONString("{submit:'ok'}");
	}
	
	@RequestMapping(value="/getTransCount/{id}",method=RequestMethod.GET)
	public @ResponseBody String getCount(@PathVariable int id){
		
		System.out.println("=====>"+transportService.getTransCount(id));
		
		return transportService.getTransCount(id);
	}
	@RequestMapping(value="/listTrans",method=RequestMethod.GET)
	public @ResponseBody List<Transport> listTrans(){
		System.out.println(transportService.listAll());
		return transportService.listAll();
	}
	@RequestMapping(value="/delivery",method=RequestMethod.POST)
	public @ResponseBody String articleDelivery(@RequestBody Transport transport){
		System.out.println("==================》");
		System.out.println(transport);
		System.out.println("==================》");
		transportService.updateDelivery(transport);
//		return "收货成功";
		return JSON.toJSONString("{submit:'ok'}");
	}
	
	@RequestMapping(value="/listDelivered/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Transport> listDelivered(@PathVariable("id") int id){
		return transportService.listDelivered(id);
	}
	
	//采购商确认产品收货
	@RequestMapping(value="/listDelivery/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Transport> listDelivery(@PathVariable("id") int id){
		System.out.println(transportService.listDelivery(id));
		return transportService.listDelivery(id);
	}
	
	@RequestMapping(value="/getTransPurchase/{id}",method=RequestMethod.GET)
	public @ResponseBody Transport getTransPurchase(@PathVariable("id") int id){
		return transportService.getTransPurchase(id);
	}
	
	@RequestMapping(value="/getTransTransport/{id}",method=RequestMethod.GET)
	public @ResponseBody Transport getTransTransport(@PathVariable("id") int id){
		return transportService.getTransTransport(id);
	}
	
	@RequestMapping(value="/getTransPurchaser/{id}",method=RequestMethod.GET)
	public @ResponseBody Transport getTransPurchaser(@PathVariable("id") int id){
		return transportService.getTransPurchaser(id);
	}
	
	@RequestMapping(value="/getTransSeller/{id}",method=RequestMethod.GET)
	public @ResponseBody Transport getTransSeller(@PathVariable("id") int id){
		return transportService.getTransSeller(id);
	}
	
}
