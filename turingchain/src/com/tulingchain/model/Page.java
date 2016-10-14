package com.tulingchain.model;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.soap.schema.read.BigBlock;

/**
 * 
 * 分页用的分页对象
 * 
 * @author Administrator 用途: 首页 区块详情 每一页请求一个Page 对象
 * 
 */
public class Page {
	private int currentPage; // 当前页
	private int listNumPerPage; // 每页显示数量
	private int totalPages; // 总页数
	private int count; // 区块数目
	private List<JSONObject> listPerPage; // 每一页的BigBlock对象

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListNumPerPage() {
		return listNumPerPage;
	}

	public void setListNumPerPage(int listNumPerPage) {
		this.listNumPerPage = listNumPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<JSONObject> getListPerPage() {
		return listPerPage;
	}

	public void setListPerPage(List<JSONObject> listPerPage) {
		this.listPerPage = listPerPage;
	}

	
}
