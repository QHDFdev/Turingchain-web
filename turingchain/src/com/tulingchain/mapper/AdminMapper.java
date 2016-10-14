package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.Admin;


public interface AdminMapper {
	
	public void save(Admin admin);
	
	public void delete(Integer id);
	
	public void update(Admin admin);
	
	public List<Admin> listAll();

	public Admin getAdminByEmail(String email);

	public Admin getAdminByName(String adminName);

	public Admin queryLogin(Admin admin);
	
	public Admin queryReferrerKey(String adminName, String referrerKey);
	
}
