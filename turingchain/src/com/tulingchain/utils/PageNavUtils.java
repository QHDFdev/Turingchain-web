package com.tulingchain.utils;

/**
 * 
 * 分页工具
 * 
 * @author Administrator
 *
 */
public class PageNavUtils {
	/*
	 * 通过  总数目 和 每页显示条目 获得一共有多少页 
	 * 
	 */
	public static int getTotalPages(int count,int listNumPerPage){
		
		int totalPages =count%listNumPerPage==0?count/listNumPerPage:count/listNumPerPage+1;
		
		return totalPages;
	}
	/*
	 * 获得每页的起始条目id
	 * 
	 */
	public static int getCurrentPageFirstNum(int currentPage,int listNumPerPage){
		int currentPageFirstNum=(currentPage-1)*listNumPerPage+1;
		
		return currentPageFirstNum;
	}
	
	/**
	 * 这个是因为条目是从0开始的     第一页   0 1 2 3 4     第二页 5 6 7 8 9 
	 * @param currentPage
	 * @param listNumPerPage
	 * @return
	 */
	public static int getCurrentPageFirstNum2(int currentPage,int listNumPerPage){
		int currentPageFirstNum=(currentPage-1)*listNumPerPage;
		
		return currentPageFirstNum;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(PageNavUtils.getTotalPages(900, 20));
		System.out.println(PageNavUtils.getCurrentPageFirstNum(2, 10));
	}
	
}
