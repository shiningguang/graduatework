<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/staticRes/img/ico/house.ico">
    <title>IntelligentCommunity</title>
    <link href="/staticRes/bootstrap-3.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/staticRes/css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form action="/save.action" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading text-center">登录</h2>
        <label for="inputEmail" class="sr-only">邮箱</label>
        <input type="text" name="accountName" value="feng@qq.com"  id="inputEmail"  class="form-control" placeholder="邮箱" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" value="88888888" id="inputPassword"  class="form-control" placeholder="密码" required>
        <c:if test="${code == 1001 }">
		<div class="container">
          <label>
            <h5 style="color:red">用户名或密码错误请重新登录</h5>
          </label>
        </div>
        </c:if>
        <c:if test="${code == 1000 }">
		<div class="container">
          <label>
            <h5 style="color:red">请改密码后请重新登录</h5>
          </label>
        </div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block">进入系统</button>
      </form>
    </div>
  </body>
</html>