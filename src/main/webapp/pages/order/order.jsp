<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
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
			class="wel_word">MyOrders</span>
		<%@ include file = "/pages/common/commonUserMenu.jsp"%>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>PurchaseDate</td>
				<td>Price</td>
				<td>Status</td>
				<td>Action</td>
				<td>Details</td>
			</tr>
			<c:forEach items="${requestScope.myOrders}" var="order">
			<tr>
				<td>${order.createDate}</td>
				<td>${order.price}</td>
				<c:if test="${order.status==0}">
					<td>ProcessingOrder</td>
					<td></td>
					</c:if>
					<c:if test="${order.status==1}">
					<td>Shipped</td>
					<td><a href="${basePath}OrderServlet?action=receiveOrder&orderId=${order.orderId}">order received</a></td>
					</c:if>
					<c:if test="${order.status==2}">
					<td>Completed</td>
					<td></td>
					</c:if>
				<td><a href="${basePath}OrderServlet?action=showOrderDetails&orderId=${order.orderId}">Check details</a></td>
			</tr>
			</c:forEach>
		</table>


	</div>

	<%@ include file = "/pages/common/commonFooter.jsp"%>
</body>
</html>