package com.tulingchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulingchain.service.MobileService;

@Controller
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@RequestMapping(value= "/queryMobile/{mobile}", method=RequestMethod.GET)
	public @ResponseBody String queryMobile( Model model , @PathVariable("mobile") String code) throws Exception{
		String result = mobileService.queryMobile(code);
		return result;
	}
}
