<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	pageContext.setAttribute("basePath", basePath);
	%>
	<!--写base标签，永远固定相对路径跳转的结果-->
		<base href="<%=basePath%>">
		<link type="text/css" rel="stylesheet" href="static/css/style.css" >
		<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</body>
</html>