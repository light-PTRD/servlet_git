<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/"/>
  <title>都市信息网-后台管理</title>
  <link type="text/css" rel="stylesheet" href=resources/css/style.css">
</head>
<body >
   
        <table border="0" width="920px" cellspacing="0" height="auto" bgcolor="white" align="center" >
			<!-- 页眉 -->
            <tr>
				<td colspan="2">
					<iframe src="resources/admin/top.jsp" frameBorder="0" width="920px" scrolling="no" height="100px" ></iframe>
				</td>
			</tr>
			<!-- 分隔行 -->
            <tr height="10px" bgcolor="lightgrey">
				<td colspan="2"></td>
			</tr>
			<!-- 内容区域 -->
            <tr>
                <td width="700px" align="center" valign="top">
					<!-- main -->
					<iframe src="resources/admin/main.jsp" frameBorder="0" width="688px" scrolling="no" height="400px" ></iframe>
				</td>
				<td width="200px" align="center" valign="top">
					<!-- 右侧栏 -->
					<iframe src="resources/admin/right.jsp" frameBorder="0" width="240px" scrolling="no" height="570px" ></iframe>
				</td>
            </tr>
			<!-- 分隔行 -->
			<tr height="10px" bgcolor="lightgrey">
				<td colspan="2"></td>
			</tr>
			<!-- 页脚 -->
            <tr>
				<td colspan="2">
					<iframe src="resources/admin/end.jsp" frameBorder="0" width="920px" scrolling="no" height="70px" style="margin-top:0"></iframe>
				</td>
			</tr>
			
        </table>        
    
</body>
</html>