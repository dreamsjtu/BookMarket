<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/pages/common/commonHeadContent.jsp"%>
<script type="text/javascript">
	$(function(){
		$("a.deleteItem").click(function(){		
			return confirm("Sure to delete "+$(this).parent().parent().find("td:first").text()+" ?");
		});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">图书管理系统</span>
		<%@ include file="/pages/common/commonManageMenu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>


			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a
						href="Manager/BookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
					<td><a class="deleteItem"
						href="Manager/BookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>
			</tr>
		</table>
		<div id="page_nav">
			<c:if test="${requestScope.page.pageNumber>1 }">
				<a href="Manager/BookServlet?action=page&pageNumber=1">首页</a>
				<a
					href="Manager/BookServlet?action=page&pageNumber=${ requestScope.page.pageNumber-1}">上一页</a>
			</c:if>
			<c:choose>
				<%--Case 1, total pages less or equal to 5 --%>
				<c:when test="${requestScope.page.totalPages<=5}">
					<c:forEach begin="1" end="${requestScope.page.totalPages}" var="i">
						<c:if test="${i==requestScope.page.pageNumber}">
						[${i}]
					</c:if>
						<c:if test="${i!=requestScope.page.pageNumber}">
							<a href="Manager/BookServlet?action=page&pageNumber=${i}">${i}</a>
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
					<a href="Manager/BookServlet?action=page&pageNumber=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.page.pageNumber<requestScope.page.totalPages }">
				<a
					href="Manager/BookServlet?action=page&pageNumber=${ requestScope.page.pageNumber+1}">下一页</a>
				<a
					href="Manager/BookServlet?action=page&pageNumber=${ requestScope.page.totalPages}">末页</a>
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
						location.href = "${requestScope.basePath}Manager/BookServlet?action=page&pageNumber="+pageNumber;
					});
				});
				</script>
		</div>
	</div>

	<%@ include file="/pages/common/commonFooter.jsp"%>
</body>
</html>