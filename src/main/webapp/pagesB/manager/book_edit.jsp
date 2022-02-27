<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ç¼è¾å¾ä¹¦</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">ç¼è¾å¾ä¹¦</span>
			<div>
				<a href="book_manager.jsp">å¾ä¹¦ç®¡ç</a>
				<a href="order_manager.jsp">è®¢åç®¡ç</a>
				<a href="../../index.jsp">è¿ååå</a>
			</div>
		</div>
		
		<div id="main">
			<form action="book_manager.jsp">
				<table>
					<tr>
						<td>åç§°</td>
						<td>ä»·æ ¼</td>
						<td>ä½è</td>
						<td>éé</td>
						<td>åºå­</td>
						<td colspan="2">æä½</td>
					</tr>		
					<tr>
						<td><input name="book_name" type="text" value="æ¶é´ç®å²"/></td>
						<td><input name="book_price" type="text" value="30.00"/></td>
						<td><input name="book_author" type="text" value="éé"/></td>
						<td><input name="book_sales" type="text" value="200"/></td>
						<td><input name="book_stock" type="text" value="300"/></td>
						<td><input type="submit" value="æäº¤"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				å°ç¡è°·ä¹¦å.Copyright &copy;2015
			</span>
		</div>
</body>
</html>