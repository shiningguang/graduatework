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

		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/house/addHouse.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/house/listHouse.action">查看</a></button>

			<div class="row">
			<span class="col-md-2"></span>
			<span class="col-md-10">
				<h3><strong>新增房屋信息</strong></h3>
				<form action="/house/add.action" method="post" role="form">
				  <div class="form-group">
					<label for="exampleInputEmail1">房屋居室</label>
					<input type="text" name="house.room" class="form-control" style="width:50%" id="exampleInputEmail1" placeholder="居室" />
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">房屋面积</label>
					<input type="text" name="house.area" class="form-control" style="width:50%"  id="exampleInputPassword1" placeholder="房屋面积" />
				  </div>
					<div class="form-group">
					<label for="exampleInputEmail1">房屋位置</label>
					<input type="text" class="form-control" name="house.detail" style="width:50%" id="exampleInputEmail1" placeholder="物业坐标"  />
				  </div>
				  <div class="form-group">
				  	<label for="exampleInputEmail1">户主</label>
					<select name="accountId" class="form-control" style="width:50%">
						<option class="form-control"></option>
						<c:if test="${not empty accountList }">
						<c:forEach items="${accountList  }" var="account">
						<option value="${account.id }">${account.name }</option>
						</c:forEach>
						</c:if>
					</select>
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