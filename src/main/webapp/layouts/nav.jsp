
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
 <jsp:include page="navbar.jsp"></jsp:include>
  <!-- /.navbar-header -->

  <ul class="nav navbar-top-links navbar-right">

    <!-- /.dropdown -->
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <i class="fa fa-user fa-fw"></i> ${user.username} <i class="fa fa-caret-down"></i>
      </a>
      <ul class="dropdown-menu dropdown-user">
        <li><a href="/user/show.do"><i class="fa fa-user fa-fw"></i>个人信息</a>
        </li>

        <li class="divider"></li>
        <li><a href="/signout.do"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
        </li>
      </ul>
      <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
  </ul>
  <!-- /.navbar-top-links -->

  <div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
        <li class="sidebar-search">
          <div class="input-group custom-search-form">

            <!-- /input-group -->
            </div>
        </li>
        <li>
          <a href="/"><i class="fa fa-dashboard fa-fw"></i> 首页</a>
        </li>
        <li>
          <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 房产管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <c:choose>
            <c:when test="${true eq user.isadmin}">
            <li>
              <a href="/house/add.do">添加房产</a>
            </li>
              </c:when>
            </c:choose>
            <li>
              <a href="/house/show_all.do">查看所有房产</a>
            </li>
          </ul>
          <!-- /.nav-second-level -->
        </li>

        <li>
          <a href="#"><i class="fa fa-wrench fa-fw"></i>求租管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">

            <li>
              <a href="/house/show_empty.do">查询空房信息</a>
            </li>


          </ul>
          <!-- /.nav-second-level -->
        </li>
        <li>
          <a href="#"><i class="fa fa-sitemap fa-fw"></i> 合同管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <c:choose>
            <c:when test="${true eq user.isadmin}">
            <li>
              <a href="/contract/new.do">添加合同信息</a>
            </li>
              </c:when>

              </c:choose>

            <li>
              <a href="/contract/show_all.do">查看合同信息</a>
            </li>
            <li>
              <a href="/contract/timeout.do">过期合同处理</a>
            </li>

          </ul>
          <!-- /.nav-second-level -->
        </li>
        <li>
          <a href="#"><i class="fa fa-files-o fa-fw"></i> 租金管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">

            <li>
              <a href="/contract/show_pay.do">查询交租信息</a>
            </li>
          </ul>
          <!-- /.nav-second-level -->
        </li>

      </ul>
    </div>
    <!-- /.sidebar-collapse -->
  </div>
  <!-- /.navbar-static-side -->
</nav>