package com.tulingchain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.BlockChainAdminMapper;
import com.tulingchain.model.BlockChainAdmin;
import com.tulingchain.service.BlockChainAdminService;

@Service
public class BlockChainAdminServiceImpl implements BlockChainAdminService {

	@Autowired
	public BlockChainAdminMapper bcAdminMapper;

	@Override
	public void add(BlockChainAdmin bcAdmin) {
		bcAdminMapper.add(bcAdmin);
		System.out.println(bcAdmin);
	}

	@Override
	public List<BlockChainAdmin> listAllBlockChainAdminByState(
			String blockChainAdminState) {
		return bcAdminMapper
				.listAllBlockChainAdminByState(blockChainAdminState);
	}

	@Override
	public BlockChainAdmin getBlockChainAdminInfoById(int id) {
		return bcAdminMapper.getBlockChainAdminInfoById(id);
	}

	@Override
	public String passBlockChainAdmin(BlockChainAdmin bcAdmin) {
		bcAdmin.setBlockChainAdminState("审核通过");
		if (bcAdminMapper.updateState(bcAdmin) == 1) {
			return "成功";
		}
		return "失败";
	}

	@Override
	public String failBlockChainAdmin(BlockChainAdmin bcAdmin) {
		bcAdmin.setBlockChainAdminState("审核未通过");
		if (bcAdminMapper.updateState(bcAdmin) == 1) {
			return "成功";
		}
		return "失败";
	}

	@Override
	public int updateState(BlockChainAdmin bcAdmin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		return bcAdminMapper.delete(id);
	}

	@Override
	public BlockChainAdmin queryLogin1(BlockChainAdmin bcAdmin) {
		return bcAdminMapper.queryLogin1(bcAdmin);
	}

	@Override
	public BlockChainAdmin queryLogin(String email, String password) {
		return bcAdminMapper.queryLogin(email, password);
	}

}
