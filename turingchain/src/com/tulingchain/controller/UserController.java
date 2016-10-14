package com.tulingchain.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.tulingchain.dto.Message;
import com.tulingchain.model.Admin;
import com.tulingchain.model.Apply;
import com.tulingchain.model.Noder;
import com.tulingchain.model.User;
import com.tulingchain.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	private User user;
	@ModelAttribute
	public void setUser(User user) {
		this.user = user;
	}
	@RequestMapping(value="/user" , method=RequestMethod.POST)
	public @ResponseBody Message add(@RequestBody User user){
		    userService.addUser(user);
		    return new Message("注册成功！！！");
		
	}
	//文件上传
		@RequestMapping(value="/upload" , method=RequestMethod.POST)
		public @ResponseBody Message upload(HttpServletRequest request) throws IllegalStateException, IOException{

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
	                    }else {
	                    	return new Message("上传文件为空！！");
						}
	                    
	                }  
	                //记录上传该文件后的时间  
	                int finaltime = (int)System.currentTimeMillis();  
	                System.out.println(finaltime - pre); 
	                
	            }  
	              
	        }  
	        return null;
		}
	
	@RequestMapping(value="/uploadImg" , method=RequestMethod.POST)
	public @ResponseBody Message uploadImg(HttpServletRequest request) throws IllegalStateException, IOException{
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
                        String path = request.getServletContext().getRealPath("/images/"+ fileName);  
                        File localFile = new File(path);  
                        file.transferTo(localFile); 
                        //添加到数据库的路径
                        int url = request.getRequestURL().lastIndexOf("/");
                        String path1 = request.getRequestURL().substring(0, url) +"/images/"+ fileName;
                        System.out.println(path1);
                        return new Message(" 上传成功！！" , path1 , fileName);
                    } 
                    
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre); 
                
            }  
              
        }  
        return new Message("上传文件为空！！");
	}

	
	@RequestMapping(value="/upUserImg" , method=RequestMethod.POST)
	public @ResponseBody String upUserImg(@RequestBody User user){
		    userService.upUserImg(user);
		    return "成功";
	}
/*	@RequestMapping("/active")
	@ResponseBody
	public String active(@RequestParam(value="code") String code, Map<String, Object> map){
		User user = userService.findByCode(code);
		if (user == null) {
			map.put("msg", "您已激活！请登录！");
			return "msg";
		}else {
			userService.active(user);
			map.put("msg", "激活成功！请登录！");
			return "msg";
		}
	}*/
	
	@RequestMapping(value="/findByName" ,method=RequestMethod.POST)
	@ResponseBody
	public User findByName(@RequestParam("userName")String userName){
		if(userService.findByName(userName) == null){
			return null;
		}else {
			return userService.findByName(userName);
		}
		
	}
	
	@RequestMapping(value="/findByEmail" ,method=RequestMethod.POST)
	@ResponseBody
	public User findByEmail(@RequestParam("email")String email){
		if(userService.findByEmail(email) == null){
			return null;
		}else {
			return userService.findByEmail(email);
		}
		
	}
	
	@RequestMapping(value="/queryLogin/{email}/{password}" , method=RequestMethod.GET)
	public @ResponseBody User queryLogin(@PathVariable(value="email") String email,
			@PathVariable(value = "password") String password , HttpSession session){
			
			session.setAttribute("userName",userService.queryLogin(email,password).getUserName());
			System.out.println("===========>session.name:" + session.getAttribute("userName"));
			System.out.println("===========>" + userService.queryLogin(email,password));
			return userService.queryLogin(email,password);
	}
	
	@RequestMapping(value="/userLogin" , method=RequestMethod.POST)
	public  String queryLogin2(User user,HttpServletRequest request){
			System.out.println(userService.queryLogin2(user));
			request.getSession().setAttribute("userName", userService.queryLogin2(user).getUserName());
			System.out.println("userLogin:" + request.getSession().getAttribute("userName").toString());
//			return "../tpls/home.html";
			return "../bcaPages/bcaIndex.jsp";
	}
	
	@RequestMapping(value="/user/{id}" , method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id")Integer id){
		userService.delete(id);
		return "success";
	}
	
	@RequestMapping(value="/user" , method=RequestMethod.PUT)
	@ResponseBody
	public String update(User user){
		userService.updateUser(user);
		return "success";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public String input(Map<String, Object> map){
		map.put("users", userService.getAll());
		return "success";
	}
	
	@RequestMapping(value="/user/{userName}/{newPassword}",method=RequestMethod.PUT)
	@ResponseBody
	public void updatePwd(@PathVariable("userName")String userName,@PathVariable("newPassword") String newPassword){
		userService.updatePwd(userName,newPassword);
	}
	
	@RequestMapping(value="/findByName/{userName}",method=RequestMethod.GET)
	@ResponseBody
	public User input(@PathVariable("userName")String userName){
		return userService.findByName(userName);
	}
	
	@RequestMapping(value="/deleteAdd/{id}",method=RequestMethod.GET)
	public String deleteAdd(@PathVariable("id")int id){
		userService.deleteAdd(id);
		return "redirect:/listAllApply.do";
	}
	
	/*@RequestMapping(value="/failApply/{userId}",method=RequestMethod.GET)
	public String failNoder(@PathVariable("userId")int id){
		
		User user = userService.findById(id);
		userService.failApply(user);
		return "redirect:/listAllApply.do";
		
	}*/
	
}
