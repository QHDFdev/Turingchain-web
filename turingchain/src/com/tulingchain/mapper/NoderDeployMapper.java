package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.NoderDeploy;

public interface NoderDeployMapper {
	
	public List<NoderDeploy> listAll();
	
	public void deleteById(String nodeID);
	
	public NoderDeploy getNodeDeployInfoByID(String nodeID);
}
