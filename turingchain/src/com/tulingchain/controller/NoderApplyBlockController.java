package com.tulingchain.controller;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulingchain.authority.Auth;
import com.tulingchain.dto.Message;
import com.tulingchain.model.NoderApplyBlock;
import com.tulingchain.service.NoderApplyBlockService;

@Controller
public class NoderApplyBlockController {

	@Autowired
	private NoderApplyBlockService nodeApplyService;
	
	@RequestMapping(value="/nodeApplyBlock" , method=RequestMethod.POST)
	public @ResponseBody Message addNewNodeApply(@RequestBody NoderApplyBlock nodeApplyBlock){
		nodeApplyService.addNewNodeApply(nodeApplyBlock);
		return new Message("新节点申请信息发送成功！！！");
	}
	
	//@Auth("bcadmin")
	@RequestMapping(value="/bcadmin/listAllNewNodeApply" ,method=RequestMethod.GET)
	public String listAllNewNodeApply(Map<String,Object> map) throws ParseException{
		List<NoderApplyBlock> list=nodeApplyService.listAllNewNodeApply();
        map.put("newNodeApplys", list);
		return "../bcaPages/noderDeploy.jsp";
	}
	
	@RequestMapping(value="/listAllNewNodeApplyByKey/{userNameID}" ,method=RequestMethod.GET)
	public @ResponseBody List<NoderApplyBlock> listAllNewNodeApplyByKey(
			@PathVariable("userNameID") String userNameID){
		System.out.println(nodeApplyService.listAllNewNodeApplyByKey(userNameID));
		return nodeApplyService.listAllNewNodeApplyByKey(userNameID);
	}
	
	@RequestMapping(value="/getNodeApplyBlockInfoByID/{userNameID}",method=RequestMethod.GET )
	public String getNodeApplyBlockInfoByID(@PathVariable("userNameID") String userNameID,
			Map<String,Object> map){
		map.put("nodeApplyBlock", nodeApplyService.getNodeApplyBlockInfoByID(userNameID));
		return "../bcaPages/nodeApplyBlockInfo.jsp";
	}
	
	@RequestMapping(value="/getNodeApplyBlockInfoByKey1/{userNameID}/{nodeID}",method=RequestMethod.GET )
	public String getNodeApplyBlockInfoByKey1(@PathVariable("userNameID") String userNameID,
			@PathVariable("nodeID") String nodeID,Map<String,Object> map){
		map.put("nodeApplyBlock", nodeApplyService.getNodeApplyBlockInfoByKey(userNameID, nodeID));
		return "../bcaPages/nodeApplyBlockInfo.jsp";
	}
	
	@RequestMapping(value="/getNodeApplyBlockInfoByKey2/{userNameID}/{nodeID}",method=RequestMethod.GET )
	public @ResponseBody NoderApplyBlock getNodeApplyBlockInfoByKey2(@PathVariable("userNameID") String userNameID,
			@PathVariable("nodeID") String nodeID){
		System.out.println(nodeApplyService.getNodeApplyBlockInfoByKey(userNameID, nodeID));
		return nodeApplyService.getNodeApplyBlockInfoByKey(userNameID, nodeID);
	}
	
	@RequestMapping(value="/deleteNodeApplyBlock/{userNameID}/{nodeID}",method=RequestMethod.GET)
	public String deleteByKey(@PathVariable("userNameID") String userNameID,
			@PathVariable("nodeID") String nodeID){
		nodeApplyService.deleteByKey(userNameID, nodeID);
		return "redirect:/bcadmin/listAllNewNodeApply.do";
	}
	
	@RequestMapping(value = "/agreeNodeApplyState/{userNameID}/{nodeID}", method = RequestMethod.GET)
	public String agreeNodeApplyState(@PathVariable("userNameID") String userNameID,
			@PathVariable("nodeID") String nodeID) {
		NoderApplyBlock nodeApplyblock=nodeApplyService.getNodeApplyBlockInfoByKey(userNameID, nodeID);
		nodeApplyService.agreeNodeApplyState(nodeApplyblock);
		return "redirect:/bcadmin/listAllNewNodeApply.do";
	}
	
	@RequestMapping(value = "/rejectNodeApplyState/{userNameID}/{nodeID}", method = RequestMethod.GET)
	public String rejectNodeApplyState(@PathVariable("userNameID") String userNameID,
			@PathVariable("nodeID") String nodeID) {
		NoderApplyBlock nodeApplyblock=nodeApplyService.getNodeApplyBlockInfoByKey(userNameID, nodeID);
		nodeApplyService.rejectNodeApplyState(nodeApplyblock);
		return "redirect:/bcadmin/listAllNewNodeApply.do";
	}
}
