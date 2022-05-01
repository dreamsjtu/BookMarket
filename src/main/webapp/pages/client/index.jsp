<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
<script type="text/javascript">
	$(function() {
		$(".addToCart").click(
				function() {
					$.getJSON("${basePath}CartServlet",
							"action=ajaxAddItem&itemid="
									+ $(this).attr("itemid"), function(data) {
						if(data.noOfItems>1){
								$("#noOfItems").text(
										"You have " + data.noOfItems + " items in cart");
						}else{
							$("#noOfItems").text(
									"You have " + data.noOfItems + " item in cart");
						}
								$("#lastAddedItem").html('You just add \'<span style="color: red">'+data.lastAddedItem+'</span>\' to shopping cart');
							})
				});
	});
</script>
</head>
<body>
<%@ include file="/pages/common/commonLanguage.jsp"%>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word"><fmt:message key="BOOK"></fmt:message></span>
		<div>
			<c:if test="${empty sessionScope.user.username}">
				<a href="pages/user/login.jsp"><fmt:message key="LOGIN"></fmt:message></a> | <a
					href="pages/user/regist.jsp"><fmt:message key="REGISTER"></fmt:message></a>
			</c:if>
			<c:if test="${not empty sessionScope.user.username}">
				<span><fmt:message key="WELCOME"></fmt:message><span class="um_span">${sessionScope.user.username}</span><fmt:message key="TO_ONLINE_BOOK_MARKET"></fmt:message>
				</span>
				<a href="${basePath}OrderServlet?action=showMyOrders"><fmt:message key="MY_ORDERS"></fmt:message></a>
				<a href="UserServlet?action=logout"><fmt:message key="LOG_OUT"></fmt:message></a>
			</c:if>
			&nbsp;&nbsp; <a href="pages/cart/cart.jsp"><fmt:message key="SHOPPING_CART"></fmt:message></a> <a
				href="pages/manager/manager.jsp"><fmt:message key="BACKSTAGE_MANAGEMENT"></fmt:message></a>
		</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="Client/ClientBookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice"}>
					<fmt:message key="PRICE"></fmt:message><input id="min" type="text" name="min" value=${param.min}>
					<fmt:message key="CURRENCY"></fmt:message> - <input id="max" type="text" name="max" value=${param.max}>
					<fmt:message key="CURRENCY"></fmt:message> <input type="submit" value="<fmt:message key="SEARCH"></fmt:message>" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<span id="noOfItems"> </span>
					<div>
						<span style="color: red" id="lastAddedItem"><fmt:message key="SHOPPING_CART_IS_EMPTY"></fmt:message></span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<span id="noOfItems"></span>
					<div id="lastAddedItem">
						<fmt:message key="YOU_JUST_ADDED"></fmt:message><span style="color: red"></span><fmt:message key="TO_SHOPPING_CART"></fmt:message>
					</div>
				</c:if>
			</div>
			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src=${book.imgPath } />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1"><fmt:message key="BOOKNAME"></fmt:message></span> <span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1"><fmt:message key="AUTHOR"></fmt:message></span> <span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1"><fmt:message key="PRICE"></fmt:message></span> <span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1"><fmt:message key="SALES"></fmt:message></span> <span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1"><fmt:message key="STOCK"></fmt:message></span> <span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="addToCart" itemid="${book.id}"><fmt:message key="ADD_TO_CART"></fmt:message></button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%@ include file="/pages/common/commonNav.jsp"%>
	</div>

	<%@ include file="/pages/common/commonFooter.jsp"%>
</body>
</html>