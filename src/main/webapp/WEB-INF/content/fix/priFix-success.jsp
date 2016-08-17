<%@page import="com.intelligentCommunity.util.DateTimeUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ include file="/nav.jsp" %>
    <div class="container">
   	 	<button type="button" class="btn btn-success btn-sm"><a style="color:white" href="/fix/addFixForm.action">新增</a></button>
      	
      	<c:if test="${empty fixList }">
      	<div>没有公告哦</div>
      	
      	</c:if>
      	<c:if test="${not empty fixList }">
      	
	      	<table class="table table-hover">
					<thead>
						<tr class="text-center">
							<td width="20%">#</td>
							<td width="40%">报修</td>
							<td width="20%">是否处理</td>
							<!-- <td width="20%">报修时间</td> -->
							<td width="20%">操作</td>
						</tr>
					</thead>
					
					
					<tbody class="text-center">
						<c:forEach items="${fixList }" var="fix" varStatus="i">
						<c:if test="${fix[5] eq 0 }">
							<tr>
								<td><c:out value="${i.count }" /></td>
								<td>${fix[1] }</td>
								<td><c:out value="${fix[2] eq 1 ? '是':'否' }" /></td>
								<%-- <td><fmt:formatDate value="${fix[7] }" pattern="yyyy-MM-dd"/></td> --%>
								<%-- <c:set value="${fix[7] }" var="t" />
								
								<%
									Long l = pageContext.getAttribute("t");
									String s = DateTimeUtil.LongToStringTime(l);
									pageContext.setAttribute("time",s);
								%> 
								<c:out value="${time }" /> --%>
								
								<td>
									<a href="/fix/fixDetail.action?fixId=${fix[0] }" type="button" class="btn btn-link btn-sm">详情</a>
									
									<!-- 管理员才可以参与修改 -->
									<shiro:hasRole name="admin">
									<c:choose>
										<c:when test="${fix[2] eq 0}"><a href="/fix/updateFix.action?fixId=${fix[0] }" type="button" class="btn btn-link btn-sm">处理</a></c:when>
										<c:otherwise><a href="javascripe:void(0)" type="button" class="btn btn-link btn-sm">已处理</a></c:otherwise>
									</c:choose>
									</shiro:hasRole>
									
									
								</td>
							</tr>
						</c:if>
						</c:forEach>
						
						
					</tbody>
					
				</table>
      	</c:if>
    </div> 
<%@ include file="/footer.jsp" %>    
