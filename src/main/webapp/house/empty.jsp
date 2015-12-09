<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
<script src="/js/jquery.min.js" type="text/javascript"></script>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">查看可租房屋</h1>
  </div>

</div>
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        房屋信息
      </div>

      <div class="panel-body">
        <div class="dataTable_wrapper">
          <table style="font-size: 14px;color: #34495E" class="table table-striped table-bordered table-hover" id="dataTables-example">
            <thead style="color: black">
            <tr>
              <th>编号</th>
              <th>名称</th>
              <th>类型</th>
              <th>户主编号</th>
              <th>户主姓名</th>
              <th>大小</th>
              <th>出租价格</th>
              <th>位置</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.houses}" var="houses" varStatus="status">

              <tr >
                <td>${status.current.id}</td>
                <td><a href="/house/${status.current.id}/show.do">${status.current.name}</a></td>
                <td>${status.current.type}</td>
                <td >${status.current.ownerid}</td>
                <td >${status.current.ownername}</td>
                <td>${status.current.size}</td>
                <td >${status.current.price}</td>
                <td >
                ${status.current.postion}
                </td>
                <td>

                  <c:choose>
                  <c:when test="${false eq user.isadmin}">无权限</c:when>
                  <c:when test="${true eq user.isadmin}">
                  <button class="btn btn-xs btn-danger" onclick="delete_house('${status.current.id}')">删除</button>
                  <a type="button" href="/house/edit.do?id=${status.current.id}" class="btn btn-xs btn-info">修改</a>
                  <button class="btn btn-xs btn-primary" onclick="not_empty_house('${status.current.id}')">设为不可出租</button>
                </c:when>
                </c:choose>

                </td>
              </tr>
            </c:forEach>




            </tbody>
          </table>
        </div>

      </div>

    </div>

  </div>

</div>
<script>
  $(document).ready(function() {
    $('#dataTables-example').DataTable({
      responsive: true
    });
  });

  function delete_house(id){

    if(confirm("确认删除?")){

      $.ajax({
        url:'/house/delete.do',
        type:'post',
        data:{"id":id},
        success:function(data){

          window.location.href=data.path;
        }
      })

    }

  }
  function not_empty_house(id){

    if(confirm("确认设置?")){

      $.ajax({
        url:'/house/not_empty.do',
        type:'post',
        data:{"id":id},
        success:function(data){

          if(data.msg){

            alert(data.msg);

          }else{

            window.location.href=data.path;
          }


        }
      })

    }

  }

</script>