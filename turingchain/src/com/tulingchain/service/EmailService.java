package com.tulingchain.service;

import javax.jws.WebService;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Produces(MediaType.APPLICATION_XML)
public interface EmailService {
	public String queryEmail(String emailAddress);
}
