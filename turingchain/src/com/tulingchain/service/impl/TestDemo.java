package com.tulingchain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Autowired
	public static NoderServiceImpl impl;
	
	public static void init(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:root.xml");
		impl=(NoderServiceImpl)context.getBean("noderService");
		System.out.println(context.getApplicationName());
		}
	
	public static void main(String[] args) {
		System.out.println();
		System.out.println(impl.listAll());
		
	}
}
