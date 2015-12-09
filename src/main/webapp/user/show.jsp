<%--
  Created by IntelliJ IDEA.
  User: icepoint1999
  Date: 12/7/15
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">个人信息</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>

<div class="col-lg-12">

  <div class="profile-panel">
    <div class="form-horizontal">
      <div class="form-group">
        <label  class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
          <label class="show-label control-label">${user.username}</label>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-10">
         <label class="show-label control-label">${user.email}</label>
        </div>
      </div>
      <div class="form-group">

          <label class="col-sm-2 control-label">电话</label>
          <div class="col-sm-10">
            <label class="show-label control-label">${user.phone}</label>
          </div>
      </div>

    </div>


  </div>



</div>
