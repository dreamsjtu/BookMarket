<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">订单管理系统</span>
		<%@ include file="/pages/common/commonManageMenu.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>

			</tr>
			<c:forEach items="${requestScope.allOrders}" var="order">
				<tr>
					<td>${order.createDate}</td>
					<td>${order.price}</td>
					<td><a href="${basePath}OrderServlet?action=showOrderDetails&orderId=${order.orderId}">Check details</a></td>
					<c:if test="${order.status==0}">
					<td><a href="${basePath}OrderServlet?action=shipOrder&orderId=${order.orderId}">Send out the order</a></td>
					</c:if>
					<c:if test="${order.status==1}">
					<td>Shipped</td>
					</c:if>
					<c:if test="${order.status==2}">
					<td>Completed</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/pages/common/commonFooter.jsp"%>
</body>
</html>