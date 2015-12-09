<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: icepoint1999
  Date: 12/8/15
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">查看房屋信息</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>

<div class="row">

  <div  class="col-lg-6">
    <div class="panel panel-default">
      <div class="panel-heading">
       <p class="text-danger">${house.name}</p>
      </div>
      <div class="panel-body">
        <h4>房产名称</h4>
        <blockquote>
          <p class="text-primary">${house.name}</p>
        </blockquote>
        <h4>房产所有人</h4>
        <blockquote>
          <p class="text-primary">${house.ownername}</p>
          <small>电话:${house_owner.phone}

        </small>
          <small>邮箱:${house_owner.email}

          </small>
        </blockquote>
        <h4>房产位置</h4>
        <blockquote>
          <p class="text-primary">${house.postion}</p>
        </blockquote>

        <h4>房产价位</h4>
        <blockquote>
          <p class="text-primary">${house.price}<p class="text-success">RMB/月</p></p>
        </blockquote>

        <h4>房产介绍</h4>
        <blockquote>
          <p class="text-primary">${house.info}</p>
        </blockquote>

      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>

  <div class="col-lg-4">
    <div class="chat-panel panel panel-default">
      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i>
        用户评论

      </div>

      <div class="panel-body">

        <ul class="chat">
<c:forEach items="${requestScope.comments}" var="comments" varStatus="status">
          <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="/image/avatar.jpg" alt="User Avatar" class="img-circle">
                                    </span>
            <div class="chat-body clearfix">
              <div class="header">
                <strong class="primary-font">${status.current.username}</strong>
                <small class="pull-right text-muted">
                  <i class="fa fa-clock-o fa-fw"></i> ${status.current.createdat}
                </small>
              </div>
              <p>
${status.current.comment}
              </p>
            </div>
          </li>
</c:forEach>
        </ul>
      </div>

      <div class="panel-footer">
        <div class="input-group">

          <input  type="text" id="comment" name="comment" class="form-control input-sm" placeholder="Type your message here...">
                                <span class="input-group-btn">
                                    <button   onclick="submit_comment('${house.id}')" class="btn btn-warning btn-sm" id="btn-chat">
                                      发送
                                    </button>
                                </span>

        </div>
      </div>
      <!-- /.panel-footer -->
    </div>
  </div>
</div>
<script>
  function submit_comment(house_id){

    var comment=document.getElementById("comment").value;
    console.log(comment);

    if(comment==""){

      alert("请输入内容!");
    }else{

      $.ajax({
        url:'/house/comment.do',
        type:'post',
        data:{"comment":comment,"houseid":house_id},
        success:function(data){
          window.location.href=data.path
        },
        error:function(data){
          console.log(data)

        }
      })

    }

  }

</script>

