<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>è´­ç©è½¦</title>
<base href="http://localhost:8080/BookStore02/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">è´­ç©è½¦</span>
			<div>
				<span>æ¬¢è¿<span class="um_span">é©æ»</span>åä¸´å°ç¡è°·ä¹¦å</span>
				<a href="pages/order/order.jsp">æçè®¢å</a>
				<a href="index.jsp">æ³¨é</a>&nbsp;&nbsp;
				<a href="index.jsp">è¿å</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>åååç§°</td>
				<td>æ°é</td>
				<td>åä»·</td>
				<td>éé¢</td>
				<td>æä½</td>
			</tr>		
			<tr>
				<td>æ¶é´ç®å²</td>
				<td>2</td>
				<td>30.00</td>
				<td>60.00</td>
				<td><a href="#">å é¤</a></td>
			</tr>	
			
			<tr>
				<td>æ¯çªçäº§åæ¤ç</td>
				<td>1</td>
				<td>10.00</td>
				<td>10.00</td>
				<td><a href="#">å é¤</a></td>
			</tr>	
			
			<tr>
				<td>ç¾å¹´å­¤ç¬</td>
				<td>1</td>
				<td>20.00</td>
				<td>20.00</td>
				<td><a href="#">å é¤</a></td>
			</tr>		
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">è´­ç©è½¦ä¸­å±æ<span class="b_count">4</span>ä»¶åå</span>
			<span class="cart_span">æ»éé¢<span class="b_price">90.00</span>å</span>
			<span class="cart_span"><a href="#">æ¸ç©ºè´­ç©è½¦</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">å»ç»è´¦</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			å°ç¡è°·ä¹¦å.Copyright &copy;2015
		</span>
	</div>
</body>
</html>