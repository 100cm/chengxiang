<%--
  Created by IntelliJ IDEA.
  User: icepoint1999
  Date: 12/7/15
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>房屋租代管理系统</title>
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



</head>

<body>

<div id="wrapper">

  <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
    <jsp:include page="/layouts/navbar.jsp"></jsp:include>

  </nav>

  <div class="container">
    <div class="panel panel-primary devise-panel" style="margin-top:100px">
      <div class="panel-title">登陆</div>
      <div class="panel-body">
        <form id="login-form">
          <div class="alert alert-warning alert-dismissible" id="alert-div" style="display: none" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <p id="error-msg"></p>
          </div>
          <div class="form-group">

            <label><p>邮箱</p></label>
            <input class="form-control"  type="email" name="email" placeholder="用户名">

          </div>
          <div class="form-group">
            <label><p>密码</p></label>
            <input class="form-control " type="password" name="password" placeholder="密码">
          </div>
          <div class="form-group">
            <button class="btn btn-primary" type="button" onclick="login()">登陆</button>
            <a  href="/user/signup.jsp" class="">注册 </a>
          </div>
        </form>
      </div>

    </div>



  </div>
</div>
<script>
  function login(){
    $.ajax({
      url:'/login.do',
      type:'post',

      data:$("#login-form").serialize(),

      success:function(data){
        console.log(data.result)

        if(data.result=="success"){
          window.location.href=data.redirect
        }
        else{
          $("#error-msg").html("账户或者密码错误");
          $("#alert-div").show();

        }




      }


    })


  }

</script>

</body>


</html>
