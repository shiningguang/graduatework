<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>

<style type="text/css">

.a{color:red}
</style>
	<br/>
		<div class="container">
		
		<button type="button" class="btn btn-default btn-sm"><a href="/admin/setting.action" >个人详情</a></button>
		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/admin/addAccount.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/admin/listAccount.action">查看</a></button>
		
			<div class="row">
		<span class="col-md-2"></span>
		<span class="col-md-10">
			<h3><strong>修改人员信息</strong></h3>
			<form action="/admin/updateAccount.action" method="post" role="form">
			  <div class="form-group">
				<label for="exampleInputEmail1">姓名</label>
				<input type="text" name="account.name" class="form-control" style="width:50%" id="exampleInputEmail1" placeholder="姓名" value="${account.name }">
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">电话</label>
				<input type="text" name="account.tel" class="form-control" style="width:50%"  id="exampleInputPassword1" placeholder="电话" value="${account.tel }">
			  </div>
			  <label for="exampleInputEmail1">性别</label>
				<div class="radio">
				  <label>
					<input type="radio" name="account.sex" id="optionsRadios1" value="true" <c:if test="${account.sex eq true }">checked</c:if> />
					男
				  </label>
				  <label>
					<input type="radio" name="account.sex" id="optionsRadios2" value="false" <c:if test="${account.sex eq false }">checked</c:if> />
					女
				  </label>
				</div>
				<div class="form-group">
				<label for="exampleInputEmail1">住址</label>
				<input type="text" class="form-control" name="account.address" style="width:50%" id="exampleInputEmail1" placeholder="住址" value="${account.address }" />
			  </div>
			  <div class="form-group">
				<label for="exampleInputEmail1">邮箱</label>
				<input type="text" class="form-control" name="account.email" style="width:50%" id="exampleInputEmail1" value="${account.email }"  readonly="readonly"/>
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">描述</label>
				<textarea type="text" class="form-control" name="account.descript" style="width:50%"  id="exampleInputPassword1" placeholder="对人的描述">${account.descript }</textarea>
			  </div>
			  <input name="account.id" value="${account.id }" type="hidden" />
			  <input name="user.role.id" value="${user.role.id }" type="hidden" />
			  <button type="submit" class="btn btn-success">确认</button>
			  <button type="button" class="btn btn-danger">取消</button>
			  <br/>
			  <br/>
			</form>
			</span>
			  </div>
		</div>
	</div>
	
	
	

	
<%@ include file="/footer.jsp" %>  
