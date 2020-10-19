<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ page import="pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/"/>
<title>后台首页</title></head>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
<body>
    <center>
    	<form action="/userUpdateServlet" method="post">
        <table border="0" cellpadding="0" cellspacing="0" width="650" height="300">
           	<% 
           		User user  = (User)request.getAttribute("user");
           	%>
           	<tr><td>用户id:</td><td><input type="text" name="userid" value="<%= user.getID() %>" readonly="readonly"></td></tr>
           	<tr><td>用户名:</td><td><input type="text" name="username" value="<%= user.getUSER_NAME() %>" readonly="readonly"></td></tr>
           	<tr><td>用户密码:</td><td><input type="password" name="password" value="<%= user.getUSER_PASSWORD() %>"></td></tr>
           	<tr><td></td><td><input type="submit" value="修改"></td></tr>
        </table>
        </form>
    </center>
</body>
</html>