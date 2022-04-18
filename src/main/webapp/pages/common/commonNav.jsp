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
	<div id="page_nav">
		<c:if test="${requestScope.page.pageNumber>1 }">
			<a href="${requestScope.page.url}&pageNumber=1">首页</a>
			<a
				href="${requestScope.page.url}&pageNumber=${ requestScope.page.pageNumber-1}">上一页</a>
		</c:if>
		<c:choose>
			<%--Case 1, total pages less or equal to 5 --%>
			<c:when test="${requestScope.page.totalPages<=5}">
				<c:forEach begin="1" end="${requestScope.page.totalPages}" var="i">
					<c:if test="${i==requestScope.page.pageNumber}">
						[${i}]
					</c:if>
					<c:if test="${i!=requestScope.page.pageNumber}">
						<a href="${requestScope.page.url}&pageNumber=${i}">${i}</a>
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
				<c:forEach begin="${begin}" end="${end}" var="i">
				<c:if test="${i==requestScope.page.pageNumber}">
									[${i}]
								</c:if>
				<c:if test="${i!=requestScope.page.pageNumber}">
					<a href="${requestScope.page.url}&pageNumber=${i}">${i}</a>
				</c:if>
			</c:forEach>
			</c:when>
		</c:choose>
		
		<c:if
			test="${requestScope.page.pageNumber<requestScope.page.totalPages }">
			<a
				href="${requestScope.page.url}&pageNumber=${ requestScope.page.pageNumber+1}">下一页</a>
			<a
				href="${requestScope.page.url}&pageNumber=${ requestScope.page.totalPages}">末页</a>
		</c:if>
		共${ requestScope.page.totalPages}页，${ requestScope.page.itemsNumber}条记录
		到第<input value=${requestScope.page.pageNumber } name="pn"
			id="pn_input" />页 <input id="changePageBtn" type="button" value="确定">
		<script type="text/javascript">
				$(function(){
					$("#changePageBtn").click(function(){
						var pageNumber = $("#pn_input").val();
						if(pageNumber<1||pageNumber>${requestScope.page.totalPages}){
							alert("page number beyond the range.")
							return false;
						}
						location.href = "${requestScope.basePath}${requestScope.page.url}&pageNumber="+pageNumber;
					});
				});
				</script>
	</div>
	</div>
</body>
</html>