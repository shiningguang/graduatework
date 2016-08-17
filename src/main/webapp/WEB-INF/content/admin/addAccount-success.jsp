<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/nav.jsp" %>

<br/>
		
		<div class="container">
		
		<button type="button" class="btn btn-default btn-sm"><a href="/admin/setting.action" >个人详情</a></button>
		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/admin/addAccount.action">新增</a></button>
		<button type="button" class="btn btn-info btn-sm"><a style="color:white" href="/admin/listAccount.action">查看</a></button>
		
			<div class="row">
		<span class="col-md-2"></span>
		<span class="col-md-10">
			<h3><strong>添加人员信息</strong></h3>
			<form action="/admin/add.action" method="post" id="addAccount" role="form">
			  <div class="form-group">
				<label for="exampleInputEmail1">姓名</label>
				<input type="text" class="form-control" name="account.name" style="width:50%" id="username" placeholder="姓名">
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">电话</label>
				<input type="text" class="form-control" name="account.tel" style="width:50%"  id="tel" placeholder="电话">
			  </div>
			  <label for="exampleInputEmail1">性别</label>
				<div class="radio">
				<label>
					<input type="radio" name="flag" id="optionsRadios1" value="1"  checked>
					男
				  </label>
				  <label>
					<input type="radio" name="flag" id="optionsRadios2" value="0"  >
					女
				  </label>
				</div>
				<div class="form-group">
				<label for="exampleInputEmail1">住址</label>
				<input type="text" class="form-control" name="account.address" style="width:50%" id="address" placeholder="住址">
			  </div>
			  <div class="form-group">
				<label for="exampleInputEmail1">邮箱</label>
				<input type="text" class="form-control" name="account.email" style="width:50%" id="email" placeholder="邮箱">
			  </div>
			  <div class="form-group">
			  		<label for="exampleInputEmail1">用户类型</label>
					<select name="roleId" class="form-control" style="width:50%">
						<c:if test="${not empty roleList }">
						<c:forEach items="${roleList  }" var="role">
						<option value="${role.id }" <c:if test="${role.id eq 2 }">selected</c:if> >${role.chinesename }</option>
						</c:forEach>
						</c:if>
					</select>
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">描述</label>
				<textarea type="text" class="form-control" style="width:50%"  name="account.descript"   id="exampleInputPassword1" placeholder="请描述一下"></textarea>
			  </div>
			  <button type="submit" class="btn btn-success">确认</button>
			  <button type="button" class="btn btn-danger">取消</button>
			</form>
			</span>
			  </div>
		</div>
	</div>
	
	
	
<%@ include file="/footer.jsp" %>  

<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){
	 $j("#addAccount").validate({
		errorElement:'span',
		errorClass:'error help-inline',
		
		rules:{
			
			'account.name':{
				required:true,
				minlength:1
			},
			'account.tel':{
				required:true,
				rangelength:[11,11]
			},
			'account.email':{
				required:true,
				/* remote:{
					url: 'localhost:8080/admin/validateEmail.action',
					type:'post',
					data:{
						email:function(){
							alert($j("#email").val());
							return $j("#email").val();
						}
					}
				} */
			}, 
		},
		messages:{
			
			'account.name':{
				required:'请输入用户名',
				minlength:'最少1个字符'
			},
			'account.tel':{
				required:'请输入正确的手机号',
				rangelength:'手机长度11位'
			},
			'account.email':{
				required:'请输入邮箱',
				/* remote:'邮箱已被占用，请更换邮箱' */
			}
		}
	});  
	
	

});
</script>