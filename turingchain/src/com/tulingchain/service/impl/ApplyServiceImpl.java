package com.tulingchain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.ApplyMapper;
import com.tulingchain.model.Apply;
import com.tulingchain.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService{
	@Autowired
	private ApplyMapper applyMapper;
	
	@Override
	public void add(Apply apply) {
		apply.setApplyTime(new Date());
		System.out.print(apply);
		applyMapper.add(apply);
	}

	@Override
	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		applyMapper.delete(userId);
	}
	
	@Override
	public void deleteByName(String userName) {
		// TODO Auto-generated method stub
		applyMapper.deleteByName(userName);
	}

	@Override
	public List<Apply> listAll() {
		// TODO Auto-generated method stub
		return applyMapper.listAll();
	}

	@Override
	public Apply queryLogin(Apply apply) {
		// TODO Auto-generated method stub
		return applyMapper.queryLogin(apply);
	}

	@Override
	public Apply findApplyById(Integer userId) {
		// TODO Auto-generated method stub
		return applyMapper.findApplyById(userId);
	}

	@Override
	public List<Apply> getApplyById(Integer userId) {
		// TODO Auto-generated method stub
		return applyMapper.getApplyById(userId);
	}

	@Override
	public String failApply(Apply apply) {
		if(applyMapper.deleteApply(apply)==1){
			return "成功";
		}
		return "失败";
	}

	/*@Override
	public String deleteApply(Apply apply) {
		if(applyMapper.deleteApply(apply) == 1){
			return "成功";
		}
		return "失败";
	}
*/
	

	

}
