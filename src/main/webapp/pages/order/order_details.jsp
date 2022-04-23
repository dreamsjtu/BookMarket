<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">Order Details</span>
		<%@ include file="/pages/common/commonManageMenu.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>Product name</td>
				<td>Amount</td>
				<td>Price</td>
				<td>Total price</td>
			</tr>
			<c:forEach items="${requestScope.orderItems}" var="orderItem">
				<tr>
					<td>${orderItem.name}</td>
					<td>${orderItem.count}</td>
					<td>${orderItem.price}</td>
					<td>${orderItem.totalPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/pages/common/commonFooter.jsp"%>
</body>
</html>