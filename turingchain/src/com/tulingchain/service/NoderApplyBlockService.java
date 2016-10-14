package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.NoderApplyBlock;

public interface NoderApplyBlockService {

	public void addNewNodeApply(NoderApplyBlock nodeApplyblock);
	
	public List<NoderApplyBlock> listAllNewNodeApply();
	
	public List<NoderApplyBlock> listAllNewNodeApplyByKey(String userNameID);
	
	public NoderApplyBlock getNodeApplyBlockInfoByID(String userNameID);
	
	public NoderApplyBlock getNodeApplyBlockInfoByKey(String userNameID,String nodeID);
	
	public void deleteById(String userNameID);
	
	public void deleteByKey(String userNameID,String nodeID);
	
	public int updateNodeApplyState(String userNameID,String nodeID);
	
	public String agreeNodeApplyState(NoderApplyBlock nodeApplyblock);

	public String rejectNodeApplyState(NoderApplyBlock nodeApplyblock);
	
}
