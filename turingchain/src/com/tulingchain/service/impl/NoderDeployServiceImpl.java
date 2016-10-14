package com.tulingchain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.NoderDeployMapper;
import com.tulingchain.model.NoderDeploy;
import com.tulingchain.service.NoderDeployService;

@Service
public class NoderDeployServiceImpl implements NoderDeployService{
	
	@Autowired
	public NoderDeployMapper noderDeployMapper;
	
	@Override
	public List<NoderDeploy> listAll(){
		return noderDeployMapper.listAll();
	}

	@Override
	public void deleteById(String nodeID) {
		noderDeployMapper.deleteById(nodeID);
	}

	@Override
	public NoderDeploy getNodeDeployInfoByID(String nodeID) {
		return noderDeployMapper.getNodeDeployInfoByID(nodeID);
	}

}
