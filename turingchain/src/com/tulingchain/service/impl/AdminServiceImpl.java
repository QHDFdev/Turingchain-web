package com.tulingchain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.AdminMapper;
import com.tulingchain.model.Admin;
import com.tulingchain.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void save(Admin admin) {
		adminMapper.save(admin);
	}

	@Override
	public void delete(Integer id) {
		adminMapper.delete(id);
	}

	@Override
	public void update(Admin admin) {
		adminMapper.update(admin);
	}

	@Override
	public List<Admin> listAll() {
		return adminMapper.listAll();
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return adminMapper.getAdminByEmail(email);
	}

	@Override
	public Admin findAdminByName(String adminName) {
		return adminMapper.getAdminByName(adminName);
	}

	@Override
	public Admin queryLogin(Admin admin) {
		return adminMapper.queryLogin(admin);
	}

	@Override
	public Admin queryReferrerKey(String adminName, String referrerKey) {
		System.out.println("====>admin: " + adminMapper.queryReferrerKey(adminName, referrerKey));
		return adminMapper.queryReferrerKey(adminName, referrerKey);
	}

}
