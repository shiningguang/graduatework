<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>


<!-- <div class="container">
		
			<form class="form-inline" role="form">
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
			  
			  <div class="checkbox">
				<label>
				  <input type="checkbox"> Remember me
				</label>
			  </div>
			 
			  <button type="submit" class="btn btn-success">搜索</button>
			</form>

		</div> -->
		
		<br/>
		<div class="container">

		<button type="button" class="btn btn-default btn-sm"><a href="/admin/setting.action" >个人详情</a></button>
		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/admin/addAccount.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/admin/listAccount.action">查看</a></button>

			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<td width="15%">#</td>
						<td width="15%">姓名</td>
						<td width="20%">邮箱</td>
						<td width="20%">电话</td>
						<td width="20%">住址</td>
						<td width="10%">操作</td>
					</tr>
				</thead>
				
				
				<tbody class="text-center">
					<c:forEach items="${list}"  var="account" varStatus="i" >
						<tr>
						
						
						
							<td><c:out value="${i.count }"></c:out></td>
							<td><c:out value="${account.name }"></c:out></td>
							<td><c:out value="${account.email }"></c:out></td>
							<td><c:out value="${account.tel }"></c:out></td>
							<td><c:out value="${account.address }"></c:out></td>
							<td>
								<c:if test="${account.role.id ne 1 or account.id eq user.id}">
									<a href="/admin/updateAccountForm.action?accountId=${account.id }" type="button" class="btn btn-link btn-sm">修改</a>
									<a href="/admin/delAccount.action?accountId=${account.id }" type="button" class="btn btn-link btn-sm">删除</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					
					
				</tbody>
				
			</table>
			
			<!-- <nav class="text-center">
			  <ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			  </ul>
			</nav> -->

		</div> 

<%@ include file="/footer.jsp" %>
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){

});
</script>


  