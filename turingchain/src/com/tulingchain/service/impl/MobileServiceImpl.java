package com.tulingchain.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.webxml.MobileCodeWSSoap;

import com.tulingchain.service.MobileService;

@Service("mobileService")
public class MobileServiceImpl implements MobileService {

	@Autowired
	private  MobileCodeWSSoap mobileClient;
	
	public void setMobileClient(MobileCodeWSSoap mobileClient) {
		this.mobileClient = mobileClient;
	}
	
	@Override
	public String queryMobile(String code) {
		System.out.println("=====>" + code);
		return mobileClient.getMobileCodeInfo(code, "");
	}
	
}
