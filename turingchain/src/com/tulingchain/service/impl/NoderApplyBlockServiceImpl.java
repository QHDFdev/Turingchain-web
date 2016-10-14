package com.tulingchain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.NoderApplyBlockMapper;
import com.tulingchain.model.NoderApplyBlock;
import com.tulingchain.service.NoderApplyBlockService;

@Service
public class NoderApplyBlockServiceImpl implements NoderApplyBlockService{

	@Autowired
	public NoderApplyBlockMapper nodeApplyMapper;
	
	@Override
	public void addNewNodeApply(NoderApplyBlock nodeApplyblock) {
		nodeApplyMapper.addNewNodeApply(nodeApplyblock);
	}

	@Override
	public List<NoderApplyBlock> listAllNewNodeApply() {
		return nodeApplyMapper.listAllNewNodeApply();
	}
	
	@Override
	public List<NoderApplyBlock> listAllNewNodeApplyByKey(String userNameID) {
		return nodeApplyMapper.listAllNewNodeApplyByKey(userNameID);
	}

	@Override
	public NoderApplyBlock getNodeApplyBlockInfoByID(String userNameID) {
		return nodeApplyMapper.getNodeApplyBlockInfoByID(userNameID);
	}
	
	@Override
	public NoderApplyBlock getNodeApplyBlockInfoByKey(String userNameID,String nodeID) {
		NoderApplyBlock nodeApplyblock = new NoderApplyBlock();
		nodeApplyblock.setUserNameID(userNameID);
		nodeApplyblock.setNodeID(nodeID);
		return nodeApplyMapper.getNodeApplyBlockInfoByKey(nodeApplyblock);
	}

	@Override
	public void deleteById(String userNameID) {
		nodeApplyMapper.deleteById(userNameID);
	}
	
	@Override
	public void deleteByKey(String userNameID,String nodeID){
		
	}

	@Override
	public String agreeNodeApplyState(NoderApplyBlock nodeApplyblock) {
		nodeApplyblock.setState("通过");
		if (nodeApplyMapper.updateNodeApplyState(nodeApplyblock) == 1) {
			return "成功";
		}
		return "失败";
	}

	@Override
	public String rejectNodeApplyState(NoderApplyBlock nodeApplyblock) {
		nodeApplyblock.setState("拒绝");
		if (nodeApplyMapper.updateNodeApplyState(nodeApplyblock) == 1) {
			return "成功";
		}
		return "失败";
	}

	@Override
	public int updateNodeApplyState(String userNameID, String nodeID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
