<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>TuLingChain</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="<%=basePath%>plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<%=basePath%>dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="<%=basePath%>css/showBo.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini" style="font-size:14px;">
<div class="wrapper">

 <%@ include file="common/bcdheader.jsp"%>
 
  <!-- Left side column. contains the logo and sidebar -->
<%@ include file="common/bcdsidebar.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
               节点部署详细信息
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="col-md-16">
          <!-- Horizontal Form -->
          <div class="box box-info">
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">用户名ID</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.userNameID}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">用户注册时间</label>
                  <div class="col-sm-6">
                  	<%-- <%
					   Date dNow = new Date( );
                		  /* dNow = request.getParameter(nodeApplyBlock); */
					   SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                	   
					   out.print( "<input class=\"form-control\" >" + ft.format(dNow) + "</input>");
					%> --%>
                    <td><fmt:formatDate value="${nodeApplyBlock.registerDate}" pattern="yyyy-MM-dd"/></td>
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点IP地址</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeIP}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点ID</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeID}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点具体地址</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeAddr}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点IP所属区域</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeIPRegion}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点所属机构</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeOrga}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点创始时间</label>
                  <div class="col-sm-6">
                    <td><fmt:formatDate value="${nodeApplyBlock.nodeCreaTime}" pattern="yyyy-MM-dd"/></td>
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点配置-MEM</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeConfMEM}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点配置-CPU</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeConfCPU}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点配置-OS</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeConfOS}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点配置-NETWORK</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeConfNetwork}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点配置-USED-LIST</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeConfUsedList}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点负责人-ID</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeChargeID}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">新节点负责人联系方式-CONTACT</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.nodeChargeContact}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">申请加入节点类型</label>
                  <div class="col-sm-6">
                   	<c:choose>
					    <c:when test="${nodeApplyBlock.nodeType==1}">
					    	主验证节点
					    </c:when>
					    <c:when test="${nodeApplyBlock.nodeType==2}">
					    	从辅助节点
					    </c:when>
					    <c:otherwise>
					    </c:otherwise>
				    </c:choose>
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">申请加入网络原因</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.reason}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">申请加入网络推荐人ID</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.refereeID}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">其他事项说明</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.others}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="text" class="col-sm-2 control-label">审核状态</label>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${nodeApplyBlock.state}">
                  </div>
                </div>
                
              <!-- /.box-body -->
              <div class="box-footer">
              <label class="col-sm-2 control-label"></label>
	              <%-- <div class="col-sm-1">
	              	<a href="<%=basePath%>deleteNodeApplyBlock/${nodeApplyBlock.userNameID}/${nodeApplyBlock.nodeID}.do" class="delete"><button type="button" class="btn btn-block btn-danger btn-info ">删除</button></a>
	              </div> --%>
	              <div class="col-sm-1">
	              	<a href="<%=request.getContextPath()%>/agreeNodeApplyState/${nodeApplyBlock.userNameID}/${nodeApplyBlock.nodeID}.do" class="delete"><button type="button" class="btn btn-block btn-success ">同意</button></a>
	              </div>
	              <div class="col-sm-1">
	              	<a href="<%=request.getContextPath()%>/rejectNodeApplyState/${nodeApplyBlock.userNameID}/${nodeApplyBlock.nodeID}.do" class="delete"><button type="button" class="btn btn-block btn-danger ">拒绝</button></a>
	              </div>
	               
              </div>
              </div>
              </form>
          </div>
          </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
	<!-- footer -->
	 <div class="control-sidebar-bg"></div>
	<%@ include file="common/bcdfooter.jsp" %>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.0 -->
<script src="<%=basePath%>plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="<%=basePath%>plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="<%=basePath%>plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=basePath%>plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>dist/js/demo.js"></script>
<!-- page script -->
<script src="<%=basePath%>js/showBo.js"></script>
<script type="text/javascript">
