<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- header -->
<%@ include file="common/bcdheader.jsp"%>
  <!-- sidebar，里面可以修改侧边栏菜单 -->
<%@ include file="common/bcdsidebar.jsp"%>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
               节点部署
      </h1>
            	<!-- 
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">数据表</li>
      </ol>
       -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">数据表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>用户名ID</th>
                  <th>用户注册时间</th>
                  <th>新节点IP地址</th>
                  <th>新节点ID</th>
                  <th>新节点具体地址</th>
                  <th>审核状态</th>
                  <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="newNodeApply" items="${newNodeApplys}">
                <tr>
                  <td>${newNodeApply.userNameID}</td>
                  <td><fmt:formatDate value="${newNodeApply.registerDate}" pattern="yyyy-MM-dd"/></td>
                  <td>${newNodeApply.nodeIP}</td>
                  <td>${newNodeApply.nodeID}</td>
                  <td>${newNodeApply.nodeAddr}</td>
                  <td>${newNodeApply.state}</td>
				  <td>
                     <a href="<%=request.getContextPath()%>/getNodeApplyBlockInfoByKey1/${newNodeApply.userNameID}/${newNodeApply.nodeID}.do" >
                    	<button type="button" class="btn btn-block btn-info" >详细信息</button>
                    </a> 
                  </td>
                </tr>
                </c:forEach>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
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
/* 	$(function() {
		//1. 点击 时, 弹出 确定删? 若确定, 执行删除, 若不确定, 则取消
		$(".delete").click(function() {
			var flag = confirm("nodersAll确定删除该节点用户?");
			if (flag) {
				var $tr = $(this).parent().parent();
				//删除, 使用 ajax 的方式
				var url = this.href;
				var args = {
					"time" : new Date()
				};
				$.get(url, args, function(data) {
					//若 data 的返回值为 1, 则提示 审核通过成功, 且把当前行删除
					if (data == "1") {
						Showbo.Msg.alert("nodersAll删除完成!");
						$tr.remove();
						window.location.reload();
					} else {
						//若 data 的返回值不是 1, 审核通过失败. 
						alert("nodersAll删除失败!");
					}
				});
			}
			//取消超链接的默认行为
			return false;
		});
	});  */
	
	/* $(function() {
		//1. 点击 时, 弹出 确定通过审核? 若确定, 执行删除, 若不确定, 则取消
		$(".fail").click(function() {
			var flag = Showbo.Msg.confirm("确定不通过审核?");
			if (flag) {
				var $tr = $(this).parent().parent();
				//删除, 使用 ajax 的方式
				var url = this.href;
				var args = {
					"time" : new Date()
				};
				$.get(url, args, function(data) {
					//若 data 的返回值为 1, 则提示 审核不通过完成, 且把当前行删除
					if (data == "1") {
						Showbo.Msg.alert("审核不通过完成!");
						$tr.remove();
					} else {
						//若 data 的返回值不是 1, 审核通过失败. 
						Showbo.Msg.alert("审核不通过失败!");
					}
				});
			}
			//取消超链接的默认行为
			return false;
		});
	});
	 */
	  $(function () {
	    $("#example1").DataTable();
	    $('#example2').DataTable({
	      "paging": true,
	      "lengthChange":true,
	      "searching": true,
	      "ordering": true,
	      "info": true,
	      "autoWidth": true
	    });
	  });
	
</script>
</body>
</html>
