<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="/nav.jsp" %>
    <div class="container">
   	 	<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/fix/addFixForm.action">新增</a></button>
      	
      	<c:if test="${empty fix }">
      	<div>没有详情</div>
      	
      	</c:if>
      	<c:if test="${not empty fix }">
      	<div class="container">
      		<h4 align="center">${fix.name }</h4>
      		<p align="center">${fix.advice }</p>
      		<br/>
      		<br/>
      		<p align="center">${fix.reply }</p>
      		
      		<h5>${fix.isOk ? '已经处理':'正在处理，请等待......' }</h5>
      	</div>
      	</c:if>
    </div> 
<%@ include file="/footer.jsp" %>    
