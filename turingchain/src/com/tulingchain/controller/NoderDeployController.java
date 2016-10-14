package com.tulingchain.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tulingchain.authority.Auth;
import com.tulingchain.service.NoderDeployService;

@Controller
public class NoderDeployController {

	@Autowired
	public NoderDeployService noderDeployService;
	
	//@Auth("bcadmin")
	@RequestMapping(value="/bcadmin/listAllNoderDeploy" ,method=RequestMethod.GET)
	public String listAllNoderDeploy(Map<String, Object> map){
		map.put("noderDeploy", noderDeployService.listAll());
		return "../bcaPages/deploy.jsp";
	}
	
	@RequestMapping(value="/admin/listAllNoderDeploy" ,method=RequestMethod.GET)
	public String listAllNoderDeploy1(Map<String, Object> map){
		map.put("noderDeploy", noderDeployService.listAll());
		return "../mags/deploy.jsp";
	}
	
	@RequestMapping(value="/deleteById/{nodeID}",method=RequestMethod.GET )
	public String deleteById(
			@PathVariable(value="nodeID")String nodeID
			)throws Exception{
		System.out.println(nodeID);
		noderDeployService.deleteById(nodeID);
		return "redirect:/bcadmin/listAllNoderDeploy.do";
	}
	
	@RequestMapping(value="/nodeDeployinfo/{nodeID}",method=RequestMethod.GET )
	public String getNodeDeployInfoByID(@PathVariable("nodeID") String nodeID,
			Map<String,Object> map){
		map.put("nodeDep", noderDeployService.getNodeDeployInfoByID(nodeID));
		return "../bcaPages/nodeDeployInfo.jsp";
	}
	
	@RequestMapping(value="/admin/nodeDeployinfo/{nodeID}",method=RequestMethod.GET )
	public String getNodeDeployInfoByID1(@PathVariable("nodeID") String nodeID,
			Map<String,Object> map){
		map.put("nodeDep", noderDeployService.getNodeDeployInfoByID(nodeID));
		return "../mags/nodeDeployInfo.jsp";
	}

}
