<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<div>
			<a href="pages/user/login.jsp">登录</a> | <a
				href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp; <a
				href="pages/cart/cart.jsp">购物车</a> <a
				href="pages/manager/manager.jsp">后台管理</a>
		</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="" method="get">
					价格：<input id="min" type="text" name="min" value=""> 元 - <input
						id="max" type="text" name="max" value=""> 元 <input
						type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>
			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src=${book.imgPath} />
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
						<button>加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

		<div id="page_nav">
			<c:if test="${requestScope.page.pageNumber>1 }">
				<a href="Client/ClientBookServlet?action=page&pageNumber=1">首页</a>
				<a
					href="Client/ClientBookServlet?action=page&pageNumber=${ requestScope.page.pageNumber-1}">上一页</a>
			</c:if>
			<c:choose>
				<%--Case 1, total pages less or equal to 5 --%>
				<c:when test="${requestScope.page.totalPages<=5}">
					<c:forEach begin="1" end="${requestScope.page.totalPages}" var="i">
						<c:if test="${i==requestScope.page.pageNumber}">
						[${i}]
					</c:if>
						<c:if test="${i!=requestScope.page.pageNumber}">
							<a href="Client/ClientBookServlet?action=page&pageNumber=${i}">${i}</a>
						</c:if>
					</c:forEach>
				</c:when>
				<%--Case 2, total pages more than 5--%>
				<c:when test="${requestScope.page.totalPages>5}">
					<c:choose>
						<%--Case 2.1, current page 1,2,3--%>
						<c:when test="${requestScope.page.pageNumber<=3}">
							<c:set var="begin" value="1" />
							<c:set var="end" value="5" />
						</c:when>
						<%--Case 2.2, current page is the last 3 pages--%>
						<c:when
							test="${requestScope.page.pageNumber>requestScope.page.totalPages-3}">
							<c:set var="begin" value="${requestScope.page.totalPages-4}" />
							<c:set var="end" value="${requestScope.page.totalPages}" />
						</c:when>
						<%--Case 2.3, current page is the middle page--%>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNumber-2}" />
							<c:set var="end" value="${requestScope.page.pageNumber+2}" />
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
			<c:forEach begin="${begin}" end="${end}" var="i">
				<c:if test="${i==requestScope.page.pageNumber}">
									[${i}]
								</c:if>
				<c:if test="${i!=requestScope.page.pageNumber}">
					<a href="Client/ClientBookServlet?action=page&pageNumber=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.page.pageNumber<requestScope.page.totalPages }">
				<a
					href="Client/ClientBookServlet?action=page&pageNumber=${ requestScope.page.pageNumber+1}">下一页</a>
				<a
					href="Client/ClientBookServlet?action=page&pageNumber=${ requestScope.page.totalPages}">末页</a>
			</c:if>
			共${ requestScope.page.totalPages}页，${ requestScope.page.itemsNumber}条记录
			到第<input value=${requestScope.page.pageNumber } name="pn"
				id="pn_input" />页 <input id="changePageBtn" type="button"
				value="确定">
			<script type="text/javascript">
				$(function(){
					$("#changePageBtn").click(function(){
						var pageNumber = $("#pn_input").val();
						if(pageNumber<1||pageNumber>${requestScope.page.totalPages}){
							alert("page number beyond the range.")
							return false;
						}
						location.href = "${requestScope.basePath}Client/ClientBookServlet?action=page&pageNumber="+pageNumber;
					});
				});
				</script>
		</div>
	</div>

	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>