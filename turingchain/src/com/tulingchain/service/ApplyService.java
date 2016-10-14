package com.tulingchain.service;

import java.util.List;
import java.util.Map;

import com.tulingchain.model.Apply;
import com.tulingchain.model.Noder;


public interface ApplyService {
	public void add(Apply apply);
	
	public void delete(Integer userId);
	
	public List<Apply> listAll();

	public List<Apply> getApplyById(Integer userId);
	
	public Apply queryLogin(Apply apply);

	public Apply findApplyById(Integer userId);
	
	public void deleteByName(String userName);
	
	public String failApply(Apply apply);
}
