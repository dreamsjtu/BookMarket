<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<span>Welcome<span class="um_span">${sessionScope.user.username}</span> to online bookmarket
		</span> <a href="${basePath}OrderServlet?action=showMyOrders">My orders</a> <a href="UserServlet?action=logout">Log out</a>&nbsp;&nbsp;
		<a href="index.jsp">Back</a>
	</div>
</body>
</html>