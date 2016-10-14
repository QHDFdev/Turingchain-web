package com.tulingchain.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.tulingchain.authority.Auth;
import com.tulingchain.dto.Message;
import com.tulingchain.model.Apply;
import com.tulingchain.service.ApplyService;

@Controller
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	//管理员审核权限页面
	//@Auth("admin")
	@RequestMapping(value="/admin/listAllApply" , method=RequestMethod.GET)
	public  String listAll(Map<String, Object> map){
		map.put("applys", applyService.listAll());
		return "listApply.jsp";
	}
	//权限申请详细信息
	@RequestMapping(value="/getApplyInfoById/{userId}",method=RequestMethod.GET)
	public String getApplyInfoById(@PathVariable("userId")int userId , Map<String , Object> map){
		Apply apply = applyService.findApplyById(userId);
		map.put("apply", apply);
		return "ApplyInfo.jsp";
	}
	
	@RequestMapping(value="/apply" , method=RequestMethod.POST)
	public @ResponseBody Message add(@RequestBody Apply apply){
		applyService.add(apply);
		return new Message("注册成功！！！");
	}
	
	@RequestMapping(value="/apply/{userId}",method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("userId")Integer userId){
		applyService.delete(userId);
	}
	
	@RequestMapping(value="/deleteApply/{userId}",method=RequestMethod.GET)
	public  String deleteApply(@PathVariable("userId")Integer userId){
		Apply apply = applyService.findApplyById(userId);
		applyService.failApply(apply);
		return "listApply.jsp";
	}
	
	@RequestMapping(value="/apply/{userName}",method=RequestMethod.DELETE)
	public @ResponseBody void deleteByName(@PathVariable("userName")String userName){
		applyService.deleteByName(userName);
	}
	
	@RequestMapping(value="/getApplyById/{userId}" ,method=RequestMethod.GET)
	public @ResponseBody Integer  getApplyById(@PathVariable("userId")Integer userId){
			return applyService.getApplyById(userId).size()+1;
	}
	
	//文件上传
		@RequestMapping(value="/uploadFile" , method=RequestMethod.POST)
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
	                        System.out.println(path);
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
	
}
