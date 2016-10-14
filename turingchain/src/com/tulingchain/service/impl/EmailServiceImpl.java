   package com.tulingchain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.webxml.ValidateEmailWebServiceSoap;

import com.tulingchain.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private ValidateEmailWebServiceSoap emailClient;
	
	@Override
	public String queryEmail(String emailAddress) {
		Short isEmail = emailClient.validateEmailAddress(emailAddress);
		return isEmail.toString();
	}

}
