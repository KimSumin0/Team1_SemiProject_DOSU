<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body style="background-color: rgb(240, 242, 241);">
<div>
	<form action="LoginMainController" class="login" style="height:330px;">
		회원님의 아이디는<br><br><p style="font-weight: 1000">${searchId }</p><br>입니다.<br><br><br>
		<button>LOGIN PAGE</button><br><br><br>
  		<a href="searchPwC" style="color:gray; font-size: 6pt;" class="signup">비밀번호 찾기</a>
	</form>
</div>

</body>
</html>