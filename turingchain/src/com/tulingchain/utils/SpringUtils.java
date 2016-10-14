package com.tulingchain.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

///获得Spring上下文
public class SpringUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBeanById(String id){
        return applicationContext.getBean(id);
    }

	  public static Object getBeanByClass(Class c){
	        return applicationContext.getBean(c);
	    }

	  public static Map getBeansByClass(Class c){
	        return applicationContext.getBeansOfType(c);
	    }
}