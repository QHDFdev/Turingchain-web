package com.tulingchain.dto;

public class Message {

	private  boolean  success=true;
	private  String  msg;
	private  Integer id;
	private  String  fileName;
	private String url ;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public Message(String msg) {
		super();
		this.msg = msg;
	}
	public Message(boolean success, String msg, Integer id) {
		super();
		this.success = success;
		this.msg = msg;
		this.id = id;
	}
	public Message(String msg, Integer id) {
		super();
		this.msg = msg;
		this.id = id;
	}
	public Message(String msg, String fileName) {
		super();
		this.msg = msg;
		this.fileName = fileName;
	}
	
	public Message(String msg, String url , String fileName) {
		super();
		this.msg = msg;
		this.url = url;
		this.fileName = fileName;
	}
	
}
