
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="mall/commodityTypeAdd.jsp">商品类型增加</a><br>
    <a href="mall/commodityProperty.jsp">商品属性管理</a><br>
    <a href="mall/register.jsp">商城注册</a><br>
    <a href="mall/login.jsp">商城登录</a><br>
    <a href="supermarket/register.jsp">超市注册</a><br>
    <a href="supermarket/login.jsp">超市登录</a><br>
  </body>
</html>
