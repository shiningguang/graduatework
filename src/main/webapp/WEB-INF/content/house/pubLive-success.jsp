<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="/nav.jsp" %>
    <div class="container">
    
    	<shiro:hasRole name="admin">
   	 		<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/house/addNoticeForm.action">新增</a></button>
      	</shiro:hasRole>
      	<c:if test="${empty noticeList }">
      	<div>没有公告哦</div>
      	
      	</c:if>
      	<c:if test="${not empty noticeList }">
      	<c:forEach items="${noticeList }" var="notice" varStatus="i">
      	<div class="container">
      		<h3 align="center"><strong><c:out value="${notice.title }"></c:out></strong></h3>
      		<p align="center"><c:out value="${notice.content }"></c:out></p>
      	</div>
      	</c:forEach>
      	</c:if>
    </div> 
<%@ include file="/footer.jsp" %>    
