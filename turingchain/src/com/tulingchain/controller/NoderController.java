package com.tulingchain.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tulingchain.authority.Auth;
import com.tulingchain.dto.Message;
import com.tulingchain.model.Noder;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.service.NoderService;
import com.tulingchain.utils.JsonUtils;

@Controller
public class NoderController {
	
	@Autowired
	private NoderService noderService;
	
	//@Auth("admin")
	@RequestMapping(value="/admin/listAllNoder" ,method=RequestMethod.GET)
	public String listAllByState(Map<String, Object> map){
		map.put("noders", noderService.listAllByState());
		return "upToNoder.jsp";
	}
	
	@RequestMapping(value="/listAllBillNoder",method=RequestMethod.GET)
	public @ResponseBody String listAllBillNoder(){
		byte[] str=JSON.toJSONString(noderService.listAllBill()).getBytes();
		String str1=null;
		try {
			str1 = JsonUtils.ascii2native(new String(str,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str1;
	}
	
	
	//@Auth("admin")
	@RequestMapping(value="/admin/listNoders" ,method=RequestMethod.GET)
	public String listAll(Map<String, Object> map){
		map.put("noders", noderService.listAllByState2());
		return "nodersAll.jsp";
	}
	
	//@Auth("bcadmin")
	@RequestMapping(value="/bcadmin/listNoders2" ,method=RequestMethod.GET)
	public String listAll2(Map<String, Object> map){
		map.put("noders", noderService.listAllByState2());
		return "../bcaPages/nodersAll2.jsp";
	}
	
	
	//注册功能
	@RequestMapping(value="/noder" , method=RequestMethod.POST)
	public @ResponseBody Message save(@RequestBody Noder noder){
		noderService.addNoder(noder);
		return new Message("注册成功！！！");
	}
	
	//BillNoder
	@RequestMapping(value="/billNoder" , method=RequestMethod.POST)
	public @ResponseBody String saveBillNoder(@RequestBody BillNoder billNoder){
		noderService.addBillNoder(billNoder);
		return "ok";
	}
	
	
	//
	@RequestMapping(value="/noderyy" , method=RequestMethod.POST)
	public String add111(Noder noder){
		noderService.upGrade(noder);
		return "redirect:/listAllNoder.do";
	}
	
	@RequestMapping(value="/noderLogin" , method=RequestMethod.POST)
	public @ResponseBody Noder queryLogin(@RequestBody Noder noder){
		System.out.println(noder);
			System.out.println(noderService.queryLogin(noder));
			return noderService.queryLogin(noder);
	}
	
	@RequestMapping(value="/billnoderLogin" , method=RequestMethod.POST)
	public @ResponseBody BillNoder queryLogin(@RequestBody BillNoder noder){
			System.out.println(noderService.queryLogin(noder));
			return noderService.queryLogin(noder);
	}
	
	
	@RequestMapping(value="/noder/{id}",method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id")Integer id){
		noderService.delete(id);
	}
	
	@RequestMapping(value="/noder/{noderName}/{newPassword}",method=RequestMethod.PUT)
	@ResponseBody
	public void updatePwd(@PathVariable("noderName")String noderName,@PathVariable("newPassword") String newPassword){
		noderService.updatePwd(noderName,newPassword);
	}
	
	@RequestMapping(value="/findNoderByName" ,method=RequestMethod.POST)
	@ResponseBody
	public Noder findByName(@RequestParam("noderName")String noderName){
		if(noderService.findNoderByName(noderName) == null){
			return null;
		}else {
			return noderService.findNoderByName(noderName);
		}
		
	}
	//BillNoder
	@RequestMapping(value="/findBillNoderByName" ,method=RequestMethod.POST)
	@ResponseBody
	public BillNoder findBillByName(@RequestParam("noderName")String noderName){
		if(noderService.findBillNoderByName(noderName) == null){
			return null;
		}else {
			return noderService.findBillNoderByName(noderName);
		}
		
	}
	
	
	@RequestMapping(value="/findNoderByEmail" ,method=RequestMethod.POST)
	@ResponseBody
	public Noder findByEmail(@RequestParam("email")String email){
		if(noderService.findNoderByEmail(email) == null){
			return null;
		}else {
			return noderService.findNoderByEmail(email);
		}
	}
	//BillNoder
	@RequestMapping(value="/findBillNoderByEmail" ,method=RequestMethod.POST)
	@ResponseBody
	public BillNoder findBillByEmail(@RequestParam("email")String email){
		if(noderService.findBillNoderByEmail(email) == null){
			return null;
		}else {
			return noderService.findBillNoderByEmail(email);
		}
	}
	
	@RequestMapping(value="/findNoderByComNum" ,method=RequestMethod.POST)
	@ResponseBody
	public Noder findByComNum(@RequestParam("comNum")String comNum){
		if(noderService.findByComNum(comNum) == null){
			return null;
		}else {
			return noderService.findByComNum(comNum);
		}
	}
	
	//BillNoder
	@RequestMapping(value="/findBillNoderByComNum" ,method=RequestMethod.POST)
	@ResponseBody
	public BillNoder findBillByComNum(@RequestParam("comNum")String comNum){
		if(noderService.findByComNum(comNum) == null){
			return null;
		}else {
			return noderService.findBillByComNum(comNum);
		}
	}
	
	@RequestMapping(value="/findNoderByComName" ,method=RequestMethod.POST)
	@ResponseBody
	public Noder findByComName(@RequestParam("comName")String comName){
		if(noderService.findByComName(comName) == null){
			return null;
		}else {
			return noderService.findByComName(comName);
		}
	}
	
	@RequestMapping(value="/findBillNoderByComName" ,method=RequestMethod.POST)
	@ResponseBody
	public BillNoder findBillByComName(@RequestParam("comName")String comName){
		if(noderService.findBillByComName(comName) == null){
			return null;
		}else {
			return noderService.findBillByComName(comName);
		}
	}
	
	@RequestMapping(value="/getInfoById/{id}",method=RequestMethod.GET)
	public String getInfoById(@PathVariable("id")int id , Map<String , Object> map){
		Noder noder = noderService.findNoderById(id);
		map.put("noder", noder);
		return "upToNoderInfo.jsp";
	}
	
	@RequestMapping(value="/getNoderInfoById/{id}",method=RequestMethod.GET)
	public String getNoderInfoById(@PathVariable("id")int id , Map<String , Object> map){
		Noder noder = noderService.findNoderById(id);
		map.put("noder", noder);
		return "noderAllInfo.jsp";
	}
	
	@RequestMapping(value="/getNoderInfoById2/{id}",method=RequestMethod.GET)
	public String getNoderInfoById2(@PathVariable("id")int id , Map<String , Object> map){
		Noder noder = noderService.findNoderById(id);
		map.put("noder", noder);
		return "../bcaPages/noderAllInfo2.jsp";
	}
	
	@RequestMapping(value="/passNoder/{id}",method=RequestMethod.GET)
	public String passNoder(@PathVariable("id")int id){
		Noder noder = noderService.findNoderById(id);
		noderService.passNoder(noder);
		return "redirect:/listAllNoder.do";
	}
	
	@RequestMapping(value="/failNoder/{id}",method=RequestMethod.GET)
	public String failNoder(@PathVariable("id")int id){
		
		Noder noder = noderService.findNoderById(id);
		noderService.failNoder(noder);
		return "redirect:/listAllNoder.do";
		
	}
	
	@RequestMapping(value="/deleteNoder/{id}",method=RequestMethod.GET)
	public String deleteNoder(@PathVariable("id")int id){
		
		Noder noder = noderService.findNoderById(id);
		noderService.deleteNoder(noder);
		return "redirect:/bcadmin/listNoders.do";
		
	}
	
	@RequestMapping(value="/deleteNoder2/{id}",method=RequestMethod.GET)
	public String deleteNoder2(@PathVariable("id")int id){
		
		Noder noder = noderService.findNoderById(id);
		noderService.deleteNoder(noder);
		return "redirect:/bcadmin/listNoders2.do";
		
	}
	
	//文件上传
	@RequestMapping(value="/uploadNoderFile" , method=RequestMethod.POST)
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
	//文件下载
	@RequestMapping("/downloadNoderFile/{fileName}")  
    public ModelAndView download(@PathVariable("fileName")  String fileName, 
    		HttpServletRequest request, HttpServletResponse response)  
            throws Exception {  
  
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("UTF-8");  
        java.io.BufferedInputStream bis = null;  
        java.io.BufferedOutputStream bos = null;  
  
        /*String ctxPath = request.getSession().getServletContext().getRealPath(  
                "/")  
                + "\\" + "images\\"; */ 
        
        System.out.println(fileName);
        
        String downLoadPath = "D://" + fileName;  
        System.out.println(downLoadPath);  
	        try {  
	            long fileLength = new File(downLoadPath).length();  
	            response.setContentType("application/x-msdownload;");  
	            response.setHeader("Content-disposition", "attachment; filename="  
	                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));  
	            response.setHeader("Content-Length", String.valueOf(fileLength));  
	            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	            bos = new BufferedOutputStream(response.getOutputStream());  
	            byte[] buff = new byte[2048];  
	            int bytesRead;  
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	                bos.write(buff, 0, bytesRead);  
		            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
        	} finally {  
	            if (bis != null)  
	                bis.close();  
	            if (bos != null)  
	                bos.close();  
        	}  
        	return null;  
    	}
	
	@RequestMapping(value="/findNoderByName/{noderName}",method=RequestMethod.GET)
	@ResponseBody
	public Noder input(@PathVariable("noderName")String noderName){
		return noderService.findNoderByName(noderName);
	}
	
	@RequestMapping(value="/upNoderImg" , method=RequestMethod.POST)
	public @ResponseBody String upNoderImg(@RequestBody Noder noder){
		    noderService.upNoderImg(noder);
		    return "成功";
	}
	
}  

