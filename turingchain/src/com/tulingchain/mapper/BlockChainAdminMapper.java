package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.BlockChainAdmin;

public interface BlockChainAdminMapper {

	public void add(BlockChainAdmin bcAdmin);

	public List<BlockChainAdmin> listAllBlockChainAdminByState(
			String blockChainAdminState);

	public BlockChainAdmin getBlockChainAdminInfoById(int id);

	public int updateState(BlockChainAdmin bcAdmin);

	public int delete(int id);

	public BlockChainAdmin queryLogin1(BlockChainAdmin bcAdmin);
	
	public BlockChainAdmin queryLogin(String email, String password);

}
