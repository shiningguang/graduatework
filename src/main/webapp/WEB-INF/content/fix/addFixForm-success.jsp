<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>

		
			<!-- <form class="form-inline" role="form">
			  <div class="form-group">
				<label class="sr-only" for="exampleInputEmail2">姓名</label>
				<input type="email" class="form-control" id="exampleInputEmail2" placeholder="姓名">
			  </div>
			  <div class="form-group">
				<div class="input-group">
				  <div class="input-group-addon">@</div>
				  <input class="form-control" type="email" placeholder="邮箱">
				</div>
			  </div>
			  <div class="form-group">
				<label class="sr-only" for="exampleInputPassword2">身份证</label>
				<input type="password" class="form-control" id="exampleInputPassword2" placeholder="身份证">
			  </div>
			  <button type="submit" class="btn btn-success">搜索</button>
			</form> -->

		
		<br/>
		<div class="container">

		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/fix/addFixForm.action">新增</a></button>

			<div class="row">
			<span class="col-md-2"></span>
			<span class="col-md-10">
				<h3><strong>新增维护信息</strong></h3>
				<form action="/fix/addFix.action" method="post" role="form">
				  <div class="form-group">
					<label for="exampleInputEmail1">名称</label>
					<input type="text" name="fix.name" class="form-control" style="width:50%" id="exampleInputEmail1" placeholder="名称" />
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">建议</label>
					<input type="text" name="fix.advice" class="form-control" style="width:50%"  id="exampleInputPassword1" placeholder="建议" />
				  </div>
				  <div class="form-group">
					<label for="exampleInputEmail1">是否公共</label>
						<label class="radio">
						  <input type="radio" name="fix.status" id="optionsRadios1" value="false" checked>否
						</label>
						<label class="radio">
						  <input type="radio" name="fix.status" id="optionsRadios2" value="true">是
						</label>
				  </div>
				  <button type="submit" class="btn btn-success">确认</button>
				  <button type="button" class="btn btn-danger">取消</button>
				  <br/>
				  <br/>
				</form>
				</span>
			  </div>
			
		</div> 

<%@ include file="/footer.jsp" %>
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){


});
</script>