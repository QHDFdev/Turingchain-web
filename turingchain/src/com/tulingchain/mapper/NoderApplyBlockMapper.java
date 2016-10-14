package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.NoderApplyBlock;

public interface NoderApplyBlockMapper {

	public void addNewNodeApply(NoderApplyBlock nodeApplyblock);
	
	public List<NoderApplyBlock> listAllNewNodeApply();
	
	public List<NoderApplyBlock> listAllNewNodeApplyByKey(String userNameID);
	
	public NoderApplyBlock getNodeApplyBlockInfoByID(String userNameID);
	
	public NoderApplyBlock getNodeApplyBlockInfoByKey(NoderApplyBlock nodeApplyblock);
	
	public void deleteById(String userNameID);
	
	public void deleteByKey(NoderApplyBlock nodeApplyblock);
	
	public int updateNodeApplyState(NoderApplyBlock nodeApplyblock);
	
}
