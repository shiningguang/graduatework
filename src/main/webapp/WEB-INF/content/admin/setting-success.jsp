<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>

<style type="text/css">

.a{color:red}

</style>
	<br/>
		<div class="container">
		
		<shiro:hasRole name="admin">
		<button type="button" class="btn btn-default btn-sm"><a href="/admin/setting.action" >个人详情</a></button>
		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/admin/addAccount.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/admin/listAccount.action">查看</a></button>
		</shiro:hasRole>
		
			<div class="row">
		<span class="col-md-2"></span>
		<span class="col-md-10">
			<h3><strong>修改人员信息</strong></h3>
			<form action="/admin/saveAccount.action" id="setting" method="post" role="form">
			<input type="hidden" name="oldP"  value="${user.password }" />
			  <div class="form-group">
				<label for="exampleInputEmail1">姓名</label>
				<input type="text" name="user.name" class="form-control" style="width:50%" id="exampleInputEmail1" placeholder="姓名" value="${user.name }">
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">电话</label>
				<input type="text" name="user.tel" class="form-control" style="width:50%"  id="exampleInputPassword1" placeholder="电话" value="${user.tel }">
			  </div>
			  <label for="exampleInputEmail1">性别</label>
				<div class="radio">
				  <label>
					<input type="radio" name="flag" id="optionsRadios1" value="1" ><input id="flag" value="${flag }" type="hidden" >
					男
				  </label>
				  <label>
					<input type="radio" name="flag" id="optionsRadios2" value="0"  >
					女
				  </label>
				</div>
				<div class="form-group">
				<label for="exampleInputEmail1">住址</label>
				<input type="text" class="form-control" name="user.address" style="width:50%" id="exampleInputEmail1" placeholder="住址" value="${user.address }" />
			  </div>
			  <div class="form-group">
				<label for="exampleInputEmail1">邮箱</label>
				<input type="email" class="form-control" name="user.email" style="width:50%" id="exampleInputEmail1" placeholder="邮箱" value="${user.email }" readonly="readonly" />
			  </div>
			  <div class="form-group">
				<label for="exampleInputEmail1">密码</label>
				<input type="password" class="form-control" name="user.password" style="width:50%" id="exampleInputEmail1" placeholder="密码"/>
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">描述</label>
				<textarea type="text" class="form-control" name="user.descript" style="width:50%"  id="exampleInputPassword1" placeholder="对人的描述">${user.descript }</textarea>
			  </div>
			  <input name="user.id" value="${user.id }" type="hidden" />
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
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){

	var flag = $j("#flag").val();
	if ($j("#optionsRadios1").val() == flag) {
		$j("#optionsRadios1").attr("checked",true); 
	} else {
		$j("#optionsRadios2").attr("checked",true); 
	}
	
	$j("#setting").validate({
		errorElement:'span',
		errorClass:'error help-inline',
		
		rules:{
			
			'user.name':{
				required:true,
				minlength:1
			},
			'user.tel':{
				required:true,
				rangelength:[11,11]
			},
			'user.password':{
				rangelength:[8,18]
			},
		},
		messages:{
			
			'user.name':{
				required:'请输入用户名',
				minlength:'最少1个字符'
			},
			'user.tel':{
				required:'请输入正确的手机号',
				rangelength:'手机长度11位'
			},
			'user.password':{
				rangelength:'密码长度8-18位'
			},
		}
	});
	
	
});
</script> 
