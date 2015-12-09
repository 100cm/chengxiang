<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
<script src="/js/jquery.min.js" type="text/javascript"></script>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">过期合同处理</h1>
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
              <th>甲方姓名</th>
              <th>乙方姓名</th>
              <th>生效时间</th>
              <th>结束时间</th>
              <th>总租金</th>
              <th>审核状态</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.contracts}" var="contractss" varStatus="status">

              <tr >
                <td>${status.current.id}</td>
                <td><a href="/house/${status.current.id}/show.do">${status.current.useraname}</a> </td>
                <td>${status.current.userbname}</td>
                <td >${status.current.starttime}</td>
                <td >${status.current.endtime}</td>
                <td>${status.current.totalprice}</td>
                <td >
                  <c:choose>
                    <c:when test="${'0' eq status.current.ispassed}">未审核</c:when>
                    <c:when test="${'1' eq status.current.ispassed}">已通过</c:when>
                    <c:when test="${'2' eq status.current.ispassed}">已拒绝</c:when>
                  </c:choose>
                </td>
                <td>
<c:choose>
                  <c:when test="${false eq user.isadmin}">无权限</c:when>
  <c:when test="${true eq user.isadmin}">
                  <button class="btn btn-xs btn-danger" onclick="delete_contract('${status.current.id}')">删除</button>

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

  function delete_contract(id){

    if(confirm("确认删除?")){

      $.ajax({
        url:'/contract/delete.do',
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