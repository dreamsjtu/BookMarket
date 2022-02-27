<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>å°ç¡è°·ä¼åç»å½é¡µé¢</title>
<base href="http://localhost:8080/BookMarket/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">æ¬¢è¿ç»å½</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>å°ç¡è°·ä¼å</h1>
								<a href="regist.jsp">ç«å³æ³¨å</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">è¯·è¾å¥ç¨æ·ååå¯ç </span>
							</div>
							<div class="form">
								<form action="LoginServlet" method = "post">
									<label>ç¨æ·åç§°ï¼</label>
									<input class="itxt" type="text" placeholder="è¯·è¾å¥ç¨æ·å" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>ç¨æ·å¯ç ï¼</label>
									<input class="itxt" type="password" placeholder="è¯·è¾å¥å¯ç " autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="ç»å½" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				å°ç¡è°·ä¹¦å.Copyright &copy;2015
			</span>
		</div>
</body>
</html>