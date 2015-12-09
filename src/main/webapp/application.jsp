<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html >
<%String path=request.getContextPath();
   String url =request.getServletPath();
 String real= request.getRequestURI();
  %>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>房屋租代管理系统</title>

  <!-- Bootstrap Core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="/css/metisMenu.css" rel="stylesheet">

  <!-- Timeline CSS -->
  <link href="/css/timeline.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="/css/sb-admin-2.css" rel="stylesheet">

  <!-- Morris Charts CSS -->
  <link href="/css/morris.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <link href="/css/dataTables.bootstrap.css" type="text/css" rel="stylesheet">



</head>

<body>

<div id="wrapper">

<jsp:include page="/layouts/nav.jsp"></jsp:include>

  <div id="page-wrapper">

    <jsp:include page="${RelativeUrl}"></jsp:include>



  </div>
  <!-- /#page-wrapper -->


</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/js/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="../bower_components/raphael/raphael-min.js"></script>
<script src="../bower_components/morrisjs/morris.min.js"></script>
<script src="../js/morris-data.js"></script>

<%--datatable--%>

<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/js/sb-admin-2.js"></script>

</body>

</html>
