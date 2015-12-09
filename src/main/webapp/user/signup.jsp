<%--
  Created by IntelliJ IDEA.
  User: icepoint1999
  Date: 12/7/15
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html >
<%String path=request.getContextPath();
  String url =request.getServletPath();
  String real= request.getRequestURI();
%>
<head>

  <title>房屋租代管理系统</title>

  <!-- Bootstrap Core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <link href="/css/main.css" rel="stylesheet">

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

  <script src="/js/jquery.min.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="/js/bootstrap.min.js"></script>

  <!-- Metis Menu Plugin JavaScript -->
  <script src="/js/metisMenu.min.js"></script>

  <!-- Morris Charts JavaScript -->
  <script src="../bower_components/raphael/raphael-min.js"></script>
  <script src="../bower_components/morrisjs/morris.min.js"></script>
  <script src="../js/morris-data.js"></script>

  <!-- Custom Theme JavaScript -->
  <script src="/js/sb-admin-2.js"></script>

</head>

<body>

<div id="wrapper">

  <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
    <jsp:include page="/layouts/navbar.jsp"></jsp:include>

  </nav>

  <div class="container">
    <div class="panel panel-primary devise-panel" style="margin-top:70px;margin-bottom: 100px">
      <div class="panel-title">注册</div>
      <div class="panel-body">
        <form action="/signup.do" method="post" id="signup-form">
          <div class="alert alert-warning alert-dismissible"  id="alert-div" style="display: none" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>

          </div>

          <div class="form-group">

            <label>姓名</label>
            <input class="form-control" id="username" name="username" type="text" placeholder="用户名">

          </div>
          <div class="form-group">
            <label>密码</label>
            <input class="form-control "  id="password" name="password" type="password" placeholder="密码">
          </div>

          <div class="form-group">
            <label>确认</label>
            <input class="form-control "  id="confirm_password" onblur="confirm_pass()" type="password" placeholder="确认密码">
          </div>


          <div class="form-group">
            <label>手机</label>
            <input class="form-control " id="phone" name="phone" type="number" placeholder="手机号">
          </div>

          <div class="form-group">
            <label>邮箱</label>
            <input class="form-control " id="email" name="email" type="email" placeholder="邮箱">
          </div>



          <div class="form-group">
            <button class="btn btn-primary" type="button" onclick="zhuce()">注册</button>


          </div>
          <div class="form-group">
          <p>已有账号?</p><a href="/user/login.jsp">登陆</a>

          </div>


        </form>
      </div>

    </div>



  </div>
</div>
</body>
<script>
  function zhuce(){

   if(confirm_pass()==true) {;
    if($("#username").val()==""||$("#phone").val()==""||$("#password").val()==""){

      $("#alert-div").html("必须填写内容!");

      $("#alert-div").show();


    }
    else{

      $("#signup-form").submit()
    }
   }


  }

  function confirm_pass(){


    if($("#password").val()!=$("#confirm_password").val()){

      $("#alert-div").html("密码不一致!");
      $("#alert-div").show();
    }
    else {
      $("#alert-div").hide();
      return true;

    }
  }

</script>
</html>