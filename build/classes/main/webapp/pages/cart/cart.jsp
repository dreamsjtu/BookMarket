<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
<script type="text/javascript">
	$(function() {
		$("a.deleteItem").click(
				function() {
					return confirm("Are you sure to delete "
							+ $(this).parent().parent().find("td:first").text()
							+ " ?");
				});

		$("#clearCart").click(function() {
			return confirm("Are you sure to clear the shopping cart?");
		});

		$(".updateCount")
				.change(
						function() {
							var count = this.value;
							var name = $(this).parent().parent().find(
									"td:first").text();
							var itemid = $(this).attr("itemid");
							if (confirm("Are you sure to change item " + name
									+ "'s quantity to " + count + " ?")) {
								location.href = "http://localhost:8080/BookMarket/CartServlet?action=updateCount&itemid="
										+ itemid + "&count=" + count;
							} else {
								this.value = this.defaultValue;
							}
						});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">购物车</span>
		<%@ include file="/pages/common/commonUserMenu.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items }">
				<tr>
					<td colspan="5"><a href="index.jsp">Shopping cart is empty, check our home page out</a>
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items }">
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td><input class="updateCount" value="${entry.value.count}"
						style="width: 30px;" itemid="${entry.value.id }"></td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem"
						href="${basePath}CartServlet?action=deleteItem&itemid=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items }">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品
			</span> <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元
			</span> <span class="cart_span"><a id="clearCart"
				href="${basePath}CartServlet?action=clearCart">清空购物车</a></span> <span
				class="cart_span"><a href="${basePath}OrderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>
	</div>
	<%@ include file="/pages/common/commonFooter.jsp"%>
</body>
</html>