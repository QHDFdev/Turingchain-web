<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>TuLingChain</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<%=basePath%>dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=basePath%>plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="<%=basePath%>plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="<%=basePath%>plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="<%=basePath%>plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=basePath%>plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="<%=basePath%>plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

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
               部署说明
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
             <a href="javascript:void(0)" onclick="document.getElementById('onUbantu').scrollIntoView();">
    	<img src="../bcaPages/doc/doc0.png" alt="Install RethinkDB on Ubantu">
    </a>
    <ol>
    	<li><h4><a href="javascript:void(0)" onclick="document.getElementById('RethinkDBServer').scrollIntoView();">Install RethinkDB Server</a></h4></li>
    	<li><h4><a href="javascript:void(0)" onclick="document.getElementById('configRethinkDBServer').scrollIntoView();">Configure RethinkDB Server</a></h4></li>
    	<li><h4><a href="javascript:void(0)" onclick="document.getElementById('BigchainDBServer').scrollIntoView();">Install BigchainDB Server</a></h4></li>
    </ol>
    <div id="onUbantu" style="padding-left:100px;">
    	<h4 id="RethinkDBServer">Install RethinkDB on Ubantu</h4>
    	<br/>
    	<img src="../bcaPages/doc/doc1.png" alt="">
    	<br/>
    	<br/>
    	<img src="../bcaPages/doc/doc2.png" alt="">
    	<br/>
    	<br/>
    	<img src="../bcaPages/doc/doc3.png" alt="">
    	<br/>
    	<br/>
    	<h4 id="configRethinkDBServer">Configure RethinkDB Server</h4>
    	<p>创建一个RethinkDB配置文件 取名为rethinkdbconfig.conf输入如下内容，将其中的”join=node0_hostname”替换成需要连接的节点IP地址</p>
    	<img src="../bcaPages/doc/doc4.png" alt="">
    	<br/>
    	<h4 >Install BigchainDB Server</h4>
    	<p>Ubuntu 14.04下先做如下更新</p>
    	<img src="../bcaPages/doc/doc21.png" alt="">
    	<br/>
    	<br/>
    	<p>再更新PiP</p>
    	<img src="../bcaPages/doc/doc22.png" alt="">
    	<br/>
    	<img src="../bcaPages/doc/doc23.png" alt="">
    	<br/>
    	<br/>
    	<p id="BigchainDBServer">开始安装Bigchaindb</p>
    	<img src="../bcaPages/doc/doc24.png" alt="">
    	<br/>
    	<br/>
    	<p>开始配置BigchainDB Server</p>
		<p>使用命令创建Bigchaindb初始配置文件等</p>
		<img src="../bcaPages/doc/doc25.png" alt="">
		<p>使用Vi打开/.bigchaindb配置文件</p>
		<p>修改配置文件</p>
		<img src="../bcaPages/doc/doc26.png" alt="">
		<br/>
		<img src="../bcaPages/doc/doc27.png" alt="">
		<br/>
		<br/>
		<p>开始运行RethinkDB，开始连接所有已知节点</p>
		<p>rethinkdb --config-file instance1.conf</p>
		<img src="../bcaPages/doc/doc28.png" alt="">
		<p>首先初始化BigchainDB</p>
		<p>bigchaindb init</p>
		<p>开始运行 BigchainDB</p>
		<p>bigchaindb start</p>
		<img src="../bcaPages/doc/doc29.png" alt="">
		<p>各个节点都按照以上方法运行后。整个区块链已经完成部署。</p>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
     <div class="control-sidebar-bg"></div>
  </div>
   <div class="control-sidebar-bg"></div>
  <%@ include file="common/bcdfooter.jsp" %>
</div>
<!-- ./wrapper -->
	<!-- footer -->
	
<!-- jQuery 2.2.0 -->
<script src="<%=basePath%>plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="<%=basePath%>plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="<%=basePath%>plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="<%=basePath%>plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<%=basePath%>plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="<%=basePath%>plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="<%=basePath%>plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<%=basePath%>plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="<%=basePath%>plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=basePath%>plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<%=basePath%>dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>dist/js/demo.js"></script>
</body>
</html>
