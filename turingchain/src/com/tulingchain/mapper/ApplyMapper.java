package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.Apply;
import com.tulingchain.model.User;

public interface ApplyMapper {
	public void add(Apply apply);
	public void delete(Integer userId);
	public void update(Apply apply);
	public List<Apply> listAll();
	public List<Apply> getApplyById(Integer userId);
	public Apply queryLogin(Apply apply);
	public Apply findApplyById(Integer userId);
	public Apply getByName(String userName);
	public void deleteByName(String userName);
	public int deleteApply(Apply apply);
}
