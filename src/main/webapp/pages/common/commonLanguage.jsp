<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty param.locale}">
		<fmt:setLocale value="en_US" scope="session"/>
	</c:if>
	<c:if test="${not empty param.locale}">
		<fmt:setLocale value="${param.locale}" scope="session"/>
	</c:if>
	<fmt:setBundle basename="i18n" />
	<div id="languageSetting">
		<span><a href="index.jsp?locale=en_US">English</a> </span><span><a
			href="index.jsp?locale=zh_CN">中文</a></span>
	</div>
</body>
</html>