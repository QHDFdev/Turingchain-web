package com.tulingchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulingchain.service.EmailService;

@Controller
public class EmialController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/queryEmail/{emailAddress}",method=RequestMethod.GET)
	public @ResponseBody String queryEmail(@PathVariable("emailAddress")String emailAddress){
		String isEmail = emailService.queryEmail(emailAddress);
		String message = null;
		switch (isEmail) {
		case "0":
			message = "请重新验证";
			break;
		case "1":
			message = "邮件地址合法";
			break;
		case "2":
			message = "只是域名正确";
			break;
		case "3":
			message = " 一个未知错误";
			break;
		case "4":
			message = "邮件服务器没有找到";
			break;
		case "5":
			message = "电子邮件地址错误";
			break;
		case "6":
			message = "免费用户验证超过数量（50次/24小时";
			break;
		case "7":
			message = "商业用户不能通过验证";
			break;
		}
		return message;
	}
	
}
