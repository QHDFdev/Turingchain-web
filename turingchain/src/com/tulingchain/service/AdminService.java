package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Admin;

public interface AdminService {
	
	public void save(Admin admin);
	
	public void delete(Integer id);
	
	public void update(Admin admin);
	
	public List<Admin> listAll();

	public Admin findAdminByEmail(String email);

	public Admin findAdminByName(String adminName);

	public Admin queryLogin(Admin admin);
	
	public Admin queryReferrerKey(String adminName, String referrerKey);
}
