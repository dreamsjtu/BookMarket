<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		$(".addToCart")
				.click(
						function() {
							location.href = "${basePath}CartServlet?action=addItem&itemid="
									+ $(this).attr("itemid");
							System.out.println(location.href);
						});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">Online book market</span>
		<div>
			<c:if test="${empty sessionScope.user.username}">
				<a href="pages/user/login.jsp">Login</a> | <a
					href="pages/user/regist.jsp">Register</a>
			</c:if>
			<c:if test="${not empty sessionScope.user.username}">
				<span>Welcome<span class="um_span">${sessionScope.user.username}</span>to
					online book market
				</span>
				<a href="${basePath}OrderServlet?action=showMyOrders">MyOrders</a>
				<a href="UserServlet?action=logout">LogOut</a>
			</c:if>
			&nbsp;&nbsp; <a href="pages/cart/cart.jsp">ShoppingCart</a> <a
				href="pages/manager/manager.jsp">Backstage-management</a>
		</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="Client/ClientBookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice"}>
					价格： <input id="min" type="text" name="min" value=${param.min}>
					元 - <input id="max" type="text" name="max" value=${param.max}>
					元 <input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<span> </span>
					<div>
						<span style="color: red">当前购物车为空</span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
					<div>
						您刚刚将<span style="color: red">${sessionScope.lastAddedItem}</span>加入到了购物车中
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
							<span class="sp1">书名:</span> <span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span> <span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span> <span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span> <span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span> <span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="addToCart" itemid="${book.id}">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%@ include file="/pages/common/commonNav.jsp"%>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>