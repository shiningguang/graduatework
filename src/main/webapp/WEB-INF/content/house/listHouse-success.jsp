<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>

<div class="container">
		
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

		</div>
		
		<br/>
		<div class="container">

<shiro:hasRole name="admin">
		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/house/addHouse.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/house/listHouse.action">查看</a></button>
</shiro:hasRole>

			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<td width="15%">#</td>
						<td width="15%">房屋</td>
						<td width="20%">面积</td>
						<td width="20%">详细</td>
						<td width="20%">户主</td>
						<shiro:hasRole name="admin">
						<td width="10%">操作</td>
						</shiro:hasRole>
					</tr>
				</thead>
				
				
				<tbody class="text-center">
					<c:forEach items="${list}"  var="house" varStatus="i" >
						
								<tr>
									<td><c:out value="${i.count }"></c:out></td>
									<td><c:out value="${house.room }"></c:out></td>
									<td><c:out value="${house.area }"></c:out></td>
									<td><c:out value="${house.detail }"></c:out></td>
									<td><c:out value="${house.account.name }"></c:out></td>
									<shiro:hasRole name="admin">
									<td>
										<a href="/house/updateHouseForm.action?houseId=${house.id }" type="button" class="btn btn-link btn-sm">修改</a>
									</td>
									</shiro:hasRole>
								</tr>
							
						
						
					</c:forEach>
					
					
				</tbody>
				
			</table>
			
		</div> 

<%@ include file="/footer.jsp" %>
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){


});
</script>