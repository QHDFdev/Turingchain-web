package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.NoderDeploy;

public interface NoderDeployService {

	public List<NoderDeploy> listAll();
	
	public void deleteById(String nodeID);
	
	public NoderDeploy getNodeDeployInfoByID(String nodeID);
	
}
