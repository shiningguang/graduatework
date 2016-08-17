<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	<link href="/staticRes/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet" >
    <link href="/staticRes/css/navbar-fixed-top.css" rel="stylesheet">
  </head>
  <body style="background-color:#fff;background:url(/staticRes/img/home_alone_dribbble_1x.jpg) ">
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="/home.action">智能小区管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
			<li role="presentation" class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">物业基础管理<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="/house/listHouse.action">住房管理</a></li>
                <li><a href="/house/pubLive.action">公共生活</a></li>
              </ul>
            </li> 
            <li class="dropdown">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">维护管理<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="/fix/priFix.action?status=false">住宅报修</a></li>
                <li><a href="/fix/pubFix.action?status=true">公共设施报修</a></li>
              </ul>
            </li>
            <shiro:hasRole name="admin">
			<li class="dropdown">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">系统管理<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="/admin/listAccount.action">住户管理</a></li>
              </ul>
            </li>
            </shiro:hasRole> 
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/admin/setting.action">欢迎您：${user.name }<i class="fa fa-user"></i></a></li>
            <li><a href="/logout.action">退出管理<i class="fa fa-share-square-o"></i></a></li>
          </ul>
        </div>
      </div>
    </nav>