package com.tulingchain.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tulingchain.authority.AuthInterceptor;
import com.tulingchain.dto.Message;
import com.tulingchain.model.Admin;
import com.tulingchain.model.BlockChainAdmin;
import com.tulingchain.service.AdminService;
import com.tulingchain.service.BlockChainAdminService;

@Controller
public class BlockChainAdminController {

	@Autowired
	public BlockChainAdminService bcAdminService;
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/blockChainAdmin", method = RequestMethod.POST)
	public @ResponseBody Message add(@RequestBody BlockChainAdmin bcAdmin) {
		bcAdmin.setBlockChainAdminState("未审核");
		bcAdminService.add(bcAdmin);
		return new Message("区块链管理员注册成功！！！");
	}
	
	//Auth
	//@Auth("admin")
	@RequestMapping(value = "/admin/listAllBlockChainAdmin", method = RequestMethod.GET)
	public String listAllByState(Map<String, Object> map) {
		map.put("blockChainAdmin",
				bcAdminService.listAllBlockChainAdminByState("未审核"));
		return "blockChainAdminAll.jsp";
	}
	
	//Auth
	//@Auth("admin")
	@RequestMapping(value = "/admin/listAllBlockChainAdmin2", method = RequestMethod.GET)
	public String listAllByState2(Map<String, Object> map) {
		map.put("blockChainAdmin",
				bcAdminService.listAllBlockChainAdminByState("审核通过"));
		return "listBlockChainAdmin.jsp";
	}

	@RequestMapping(value = "/getBlockChainAdminInfoById/{id}", method = RequestMethod.GET)
	public String getBlockChainAdminInfoById(@PathVariable("id") int id,
			Map<String, Object> map) {
		BlockChainAdmin bcAdmin = bcAdminService.getBlockChainAdminInfoById(id);
		map.put("bcAdmin", bcAdmin);
		return "BlockChainAdminAllInfo.jsp";
	}

	@RequestMapping(value = "/getBlockChainAdminInfoById2/{id}", method = RequestMethod.GET)
	public String getBlockChainAdminInfoById2(@PathVariable("id") int id,
			Map<String, Object> map) {
		BlockChainAdmin bcAdmin = bcAdminService.getBlockChainAdminInfoById(id);
		map.put("bcAdmin", bcAdmin);
		return "BlockChainAdminAllInfo2.jsp";
	}

	@RequestMapping(value = "/passBlockChainAdmin/{id}", method = RequestMethod.GET)
	public String passBlockChainAdmin(@PathVariable("id") int id) {
		BlockChainAdmin bcAdmin = bcAdminService.getBlockChainAdminInfoById(id);
		bcAdminService.passBlockChainAdmin(bcAdmin);
		return "redirect:/listAllBlockChainAdmin.do";
	}

	@RequestMapping(value = "/failBlockChainAdmin/{id}", method = RequestMethod.GET)
	public String failBlockChainAdmin(@PathVariable("id") int id) {
		BlockChainAdmin bcAdmin = bcAdminService.getBlockChainAdminInfoById(id);
		bcAdminService.failBlockChainAdmin(bcAdmin);
		return "redirect:/listAllBlockChainAdmin.do";
	}

	@RequestMapping(value = "/deleteBlockChainAdmin/{id}", method = RequestMethod.GET)
	public String deleteBlockChainAdmin(@PathVariable("id") int id) {
		bcAdminService.delete(id);
		return "redirect:/admin/listAllBlockChainAdmin2.do";
	}
	
	@RequestMapping(value="/blockChainAdminLogin" , method=RequestMethod.POST)
	public @ResponseBody String queryLogin(@RequestBody BlockChainAdmin bcAdmin,HttpServletRequest request,HttpServletResponse response){
			System.out.println(bcAdminService.queryLogin1(bcAdmin));
			request.getSession().setAttribute("bcAdmName", bcAdminService.queryLogin1(bcAdmin).getBcAdmName());
			Cookie cookie = new Cookie("bcAdmName", "%22"+bcAdminService.queryLogin1(bcAdmin).getBcAdmName()+"%22");
			BlockChainAdmin bca=bcAdminService.queryLogin1(bcAdmin);
			JSONObject obj=(JSONObject) JSON.toJSON(bca);
			obj.remove("password");
			request.getSession().setAttribute(AuthInterceptor.SESSION_USERID, bcAdminService.queryLogin1(bcAdmin).getBcAdmName());
			request.getSession().setAttribute(AuthInterceptor.SESSION_AUTHS, "bcadmin");
			
			response.addCookie(cookie);
//			return "../bcaPages/bcaIndex.jsp";
			return obj.toJSONString();
	}

	@RequestMapping(value = "/queryLoginBlockChainAdmin/{email}/{password}", method = RequestMethod.GET)
	public @ResponseBody BlockChainAdmin queryLoginBlockChainAdmin(
			@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password,
			HttpSession session) {
		System.out.println(bcAdminService.queryLogin(email, password));
		return bcAdminService.queryLogin(email, password);
	}
	
	@RequestMapping(value = "/queryReferrerKey/{adminName}/{referrerKey}", method = RequestMethod.GET)
	public @ResponseBody Admin queryReferrerKey(
			@PathVariable(value = "adminName") String adminName,
			@PathVariable(value = "referrerKey") String referrerKey,
			HttpSession session) {
		System.out.println(adminService.queryReferrerKey(adminName, referrerKey));
		return adminService.queryReferrerKey(adminName, referrerKey);
	}

}
