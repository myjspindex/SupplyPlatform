<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    
      <form action="mall/mallUser_mallRegister.action" method="post">
    	   用户名：<input name="mall.userName"><br>
  		    密 码：<input name="mall.pwd"><br>
  		 真实姓名 ：<input name="mall.name"><br>
  		 联系电话  ：<input name="mall.phoneNumber" size='15'><br>
  		地址：<input name="mall.address" size="50"><br>
  		 备注：<textarea rows="5" cols="30" name="mall.remark"></textarea>
      <input type="submit" value="提 交">
      <input type="reset"  value="取 消">
    </form>
  </body>
</html>
