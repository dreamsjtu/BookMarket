<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">后台管理系统</span>
		<%@ include file="/pages/common/commonManageMenu.jsp"%>
	</div>

	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@ include file = "/pages/common/commonFooter.jsp"%>
</body>
</html>