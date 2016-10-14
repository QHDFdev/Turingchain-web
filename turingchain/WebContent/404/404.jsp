<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>哎呀，不好了，您访问的页面出错了！</title>
<meta name="author" content="www.xmoban.cn">
<meta name="copyright" content="">
  <link rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/base.css"/>
 </head>

 <body>
  <div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
        	 <div class="e404"></div>
            <p><b>出错啦！</b></p>
            <p>您访问的页面不存在</p>
            <div class="bt" ><a href="<%=path%>">返回首页</a></div>
        </div>
    </div>
</div>
<!-- xmoban.cn 提示文本 实际使用请删除 -->
<div style="padding:20px 0;margin-top:30px;">

<div style="margin-bottom:30px;text-align:center;"><a href="<%=path%>">首页</a> | <a href="#">XxX</a> | <a href="#">XxX</a></div>
</div>

 </body>
</html>