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
import com.tulingchain.model.Rawmaterial;
import com.tulingchain.service.RawmaterialService;

@Controller
public class RawmaterialController {
	@Autowired 
	private RawmaterialService rawmaterialService;
	
	@RequestMapping(value="/rawmaterial",method=RequestMethod.POST)
	public @ResponseBody String save(@RequestBody Rawmaterial rawmaterial){
		
		System.out.println("===================" + rawmaterial);
		rawmaterialService.save(rawmaterial);
		return JSON.toJSONString("{submit:'ok'}");
	}
	
	@RequestMapping(value="/rawmaterial/{sellerId}",method=RequestMethod.GET)
	public @ResponseBody List<Rawmaterial> list(@PathVariable("sellerId") int sellerId){
		return rawmaterialService.listAll(sellerId);
	}
	
	@RequestMapping(value="/getRawm/{id}",method=RequestMethod.GET)
	public @ResponseBody Rawmaterial getRawm(@PathVariable("id") int id){
		System.out.println(rawmaterialService.getRawmById(id));
		return rawmaterialService.getRawmById(id);
	}
	
	@RequestMapping(value="/getRawmPurc/{id}",method=RequestMethod.GET)
	public @ResponseBody Rawmaterial getRawmPurc(@PathVariable("id") int id){
		System.out.println(rawmaterialService.getRawmPurchaserById(id));
		return rawmaterialService.getRawmPurchaserById(id);
	}
	
	@RequestMapping(value="/listRawm/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Rawmaterial> listRawm(@PathVariable("id") int id){
		return rawmaterialService.listRawmById(id);
	}
	
	@RequestMapping(value="/transRawmCount/{id}",method=RequestMethod.GET)
	public @ResponseBody String transRawmCount(@PathVariable("id") int id){
		return rawmaterialService.getRawmCount(id);
	}
	
	
	@RequestMapping(value="/listTransRawm/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Rawmaterial> listTransRawm(@PathVariable("id") int id){
		return rawmaterialService.listTransRawmById(id);
	}
	
}
