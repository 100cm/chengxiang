<%--
  Created by IntelliJ IDEA.
  User: icepoint1999
  Date: 12/8/15
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<script>

  var checkvalue = function(e){
    var el = e.target;
    var isvalid = el.checkValidity();
    if(isvalid){
      el.parentElement.className="form-group has-success";
      $("#alert-div").hide()

    }else{
      $("#error-msg").html("请填写红框内容")
      $("#alert-div").show()
      el.parentElement.className="form-group has-error";
    }
    e.stopPropagation();
    e.preventDefault();
  }
  //定义表单验证方法
  function invalidHandler(evt) {
    checkvalue(evt);
  }
  function loadDemo() {
    var myform = document.getElementById("add-house-form");
    //注册表单的oninvlid事件
    myform.addEventListener("invalid", invalidHandler, true);
    for(var i=0;i< myform.elements.length-1;i++){
//      注册表单元素的onchange事件，优化用户体验
      myform.elements[i].addEventListener("change",checkvalue,false);
    }
  }
  //在页面初始化事件（onload）时注册的自定义事件
  window.addEventListener("load", loadDemo, false);
</script>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">添加合同</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>

<div class="row" style="padding: 10px">
  <p style="color:red">
    ${msg}
  </p>

  <div class="col-lg-10">
    <form class="form-horizontal " id="add-house-form" method="post" action="/contract/create.do">
      <div class="alert alert-warning alert-dismissible" id="alert-div" style="display: none" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <p id="error-msg"></p>
      </div>

      <div class="form-group">

        <label>甲方:</label>

        <input class="form-control" type="number" name="useraid" placeholder="甲方编号" required>
      </div>

      <div class="form-group">

        <label>房子编号:</label>

        <input class="form-control"  type="number" name="houseid" placeholder="房子编号" required>
      </div>
      <div class="form-group">

        <label>乙方编号:</label>

        <input class="form-control"  type="number" name="userbid" placeholder="乙方编号" required>
      </div>

      <div class="form-group">

        <label>生效日期:</label>

        <input class="form-control" type="date" name="starttime" placeholder="生效日期" required>
      </div>

      <div class="form-group">

        <label>结束日期:</label>

        <input class="form-control"    name="endtime"  type="date" placeholder="结束日期" required>
      </div>


      <div class="form-group">

        <label>总租金:</label>

        <input  class="form-control" name="totalprice" placeholder="价格">
      </div>

      <div class="form-group">

        <label>其他条款</label>
                <textarea  name="info" class="form-control">



                </textarea>
      </div>

      <button type="submit"  class="btn btn-primary" >提交</button>


    </form>
  </div>
</div>


