package com.tulingchain.service;

import javax.jws.WebService;

@WebService
public interface MobileService {
	public String queryMobile(String code);
}
