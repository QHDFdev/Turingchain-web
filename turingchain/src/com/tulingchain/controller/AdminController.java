package com.tulingchain.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.tulingchain.authority.Auth;
import com.tulingchain.authority.AuthInterceptor;
import com.tulingchain.dto.Message;
import com.tulingchain.model.Admin;
import com.tulingchain.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin" ,method=RequestMethod.POST)
	public @ResponseBody Message save(@RequestBody Admin admin){
		adminService.save(admin);
		return new Message(true,"注册成功！！！");
	}
	
	
	//登陆
	@RequestMapping(value="/adminLogin" , method=RequestMethod.POST)
	public  @ResponseBody String login(@RequestBody Admin admin,HttpServletRequest request){
			System.out.println(admin);
			System.out.println(adminService.queryLogin(admin));
			Admin ad=adminService.queryLogin(admin);
			request.getSession().setAttribute("adminName", adminService.queryLogin(admin).getAdminName());
			//用户权限字段
			return JSON.toJSONString(ad);
	}
	
	
	@RequestMapping(value="/uploadComFile" , method=RequestMethod.POST)
	public @ResponseBody Message upload(HttpServletRequest request) throws IllegalStateException, IOException{

		System.out.println("========>");
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                System.out.println(file.getName() + ":" + file.getSize());
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() != ""){
                    	
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = file.getOriginalFilename();  
                        //定义上传路径  
                        String path = request.getServletContext().getRealPath("/upload/"+ fileName);  
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                        return new Message(" 上传成功！！" , fileName);
                    } 
                    
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre); 
                
            }  
              
        }  
        return new Message("上传文件为空！！");
	}

	
	@RequestMapping(value="/adminLogin1" , method=RequestMethod.POST)
	public  String queryLogin(@RequestBody Admin admin,HttpServletRequest request){
			System.out.println(admin);
			System.out.println(adminService.queryLogin(admin));
			request.getSession().setAttribute("adminName", adminService.queryLogin(admin).getAdminName());
			//用户权限字段
			request.getSession().setAttribute(AuthInterceptor.SESSION_USERID, adminService.queryLogin(admin).getAdminName());
			request.getSession().setAttribute(AuthInterceptor.SESSION_AUTHS, "admin");
			return "magindex.jsp";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		//销毁session
		request.getSession().invalidate();
		Cookie cookie = new Cookie("bcAdmName", "");
		response.addCookie(cookie);
		return "index.html";
	}
	
	@RequestMapping("/deleteAdminById")
	public @ResponseBody void delete(@RequestParam(value="id") int id){
		adminService.delete(id);
	}
	
	@RequestMapping("/listAdmin")
	public @ResponseBody List<Admin> listAll(){
		return adminService.listAll();
	}
	@RequestMapping("/updateAdmin")
	public @ResponseBody void update(@RequestBody Admin admin){
		adminService.update(admin);
	}
	
	@RequestMapping(value="/findAdminByName" ,method=RequestMethod.POST)
	@ResponseBody
	public Admin findByName(@RequestParam("adminName")String adminName){
		if(adminService.findAdminByName(adminName) == null){
			return null;
		}else {
			return adminService.findAdminByName(adminName);
		}
	}
	
	@RequestMapping(value="/findAdminByEmail" ,method=RequestMethod.POST)
	@ResponseBody
	public Admin findByEmail(@RequestParam("email")String email){
		if(adminService.findAdminByEmail(email) == null){
			return null;
		}else {
			return adminService.findAdminByEmail(email);
		}
	}
	
}
