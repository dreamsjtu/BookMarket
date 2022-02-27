<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>å°ç¡è°·ä¼åæ³¨åé¡µé¢</title>
<base href = "http://localhost:8080/BookMarket/">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sub_btn").click(function(){
			//Create a regular expression pattern for verifying the username and password.
			var verifyPatt = /^\w{5,12}$/;
			//verify the username, consists of letters, numbers and hyphens, length between 5-12
				//Get the username
				var usernameText = $("#username").val();
				//Check if the username match the pattern
				//if not, show error message and return false.
				if(!verifyPatt.test(usernameText)){
					$("div:.tit span:.errorMsg").text("Wrong username");
					return false;
				}
			//verify the password, consists of letters, numbers and hyphens, length between 5-12
				//Get the password
				var passwordText = $("#password").val();
				//Check if the password match the pattern
				//If not, show error message and return false.
				if(!verifyPatt.test(passwordText)){
					$("div:.tit span:.errorMsg").text("Wrong password");
					return false;
				}
			//verify the confirmation password, same to password.
				//Check if the confirmation password same to password
				//If not, show error message and return false
				if($("#repwd").val()!=passwordText){
					$("div:.tit span:.errorMsg").text("Please confirm password");
					return false;
				}
			//Verify the email address, follow this format: xxxxx@xxx.com
				//Create a regular expression pattern for verifying the email address
				//Check if the email address match the pattern
				//If not, show error message and return false
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emailPatt.test($("#email").val())){
					$("div:.tit span:.errorMsg").text("Please input correct email");
					return false;
				}
			//Check the verification code, currently only check if it's not empty.
				//Get the verification code
				var verifyCodeText = $("#code").val();
				//Trim the verification code
				verifyCodeText = $.trim(verifyCodeText);
				//Check if the trimmed verification code is null or empty
				//If yes, show error message and return false.
				if(verifyCodeText==null||verifyCodeText==""){
					$("div:.tit span:.errorMsg").text("Please input correct verification code");
					return false;
				}
				//clear the error message
				$("div:.tit span:.errorMsg").text("");
		});

	
	})
</script>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/img/logo.gif">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">æ¬¢è¿æ³¨å</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>æ³¨åå°ç¡è°·ä¼å</h1>
						<span class="errorMsg"></span>
					</div>
					<div class="form">
						<form action="RegisterServlet" method = "post">
							<label>ç¨æ·åç§°ï¼</label> <input class="itxt" type="text"
								placeholder="è¯·è¾å¥ç¨æ·å" autocomplete="off" tabindex="1"
								name="username" id="username" /> <br /> <br /> <label>ç¨æ·å¯ç ï¼</label>
							<input class="itxt" type="password" placeholder="è¯·è¾å¥å¯ç "
								autocomplete="off" tabindex="1" name="password" id="password" />
							<br /> <br /> <label>ç¡®è®¤å¯ç ï¼</label> <input class="itxt"
								type="password" placeholder="ç¡®è®¤å¯ç " autocomplete="off"
								tabindex="1" name="repwd" id="repwd" /> <br /> <br /> <label>çµå­é®ä»¶ï¼</label>
							<input class="itxt" type="text" placeholder="è¯·è¾å¥é®ç®±å°å"
								autocomplete="off" tabindex="1" name="email" id="email" /> <br />
							<br /> <label>éªè¯ç ï¼</label> <input class="itxt" type="text"
								style="width: 150px;" name = "code" id="code" /> <img alt=""
								src="static/img/code.bmp"
								style="float: right; margin-right: 40px"> <br /> <br />
							<input type="submit" value="æ³¨å" id="sub_btn" />

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span> å°ç¡è°·ä¹¦å.Copyright &copy;2015 </span>
	</div>
</body>
</html>