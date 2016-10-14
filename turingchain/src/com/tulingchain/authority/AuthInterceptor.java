package com.tulingchain.authority;

import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	public static final String SESSION_USERID = "kUSERID";  
    public static final String SESSION_AUTHS = "kAUTHS";  
    
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
    	
   
        boolean flag = true;  
        if (handler instanceof HandlerMethod) {  
        	System.out.println("SESSION_USERID============="+request.getSession().getAttribute(SESSION_USERID));
        	System.out.println("SESSION_AUTHS============="+request.getSession().getAttribute(SESSION_AUTHS));
            Auth auth = ((HandlerMethod) handler).getMethod().getAnnotation(Auth.class);  
            if (auth != null) 
            {// 有权限控制的就要检查  
                if (request.getSession().getAttribute(SESSION_USERID) == null) {
                	// 没登录就要求登录  
//                    response.setStatus(HttpStatus.FORBIDDEN.value());  
//                    response.setContentType("text/html; charset=UTF-8");  
//                    PrintWriter out=response.getWriter();  
//                    out.write("{\"type\":\"nosignin\",\"msg\":\"请您先登录!\"}");  
//                    out.flush();  
//                    out.close(); 
                	response.sendRedirect(request.getContextPath()+"/404/404.jsp");
                	
                    flag = false;  
                } else {
                	// 登录了检查,方法上只是@Auth,表示只要求登录就能通过.@Auth("authority")这类型,验证用户权限  
                	
                    if (!"".equals(auth.value())) {  
                    	//单权限验证
                    	 String authority=(String)request.getSession().getAttribute(SESSION_AUTHS);
                    	 if(!authority.equals(auth.value())){
                    		 response.setStatus(HttpStatus.FORBIDDEN.value());  
                             response.setContentType("text/html; charset=UTF-8");  
                             PrintWriter out=response.getWriter();  
                             out.write("{\"type\":\"noauth\",\"msg\":\"您没有"+auth.name()+"权限!\"}");  
                             out.flush();  
                             out.close();  
                             flag = false; 
                    	 }
                     	
                    	
//                        Set<String> auths = (Set<String>) request.getSession().getAttribute(SESSION_AUTHS); 
//                        if (!auths.contains(auth.value())) {// 提示用户没权限  
//                            response.setStatus(HttpStatus.FORBIDDEN.value());  
//                            response.setContentType("text/html; charset=UTF-8");  
//                            PrintWriter out=response.getWriter();  
//                            out.write("{\"type\":\"noauth\",\"msg\":\"您没有"+auth.name()+"权限!\"}");  
//                            out.flush();  
//                            out.close();  
//                            flag = false;  
//                        }  
                    }  
                }  
            }  
        }  
        return flag;  
    }  
}
