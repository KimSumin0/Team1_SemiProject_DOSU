<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="jsp/sm/reg.js"></script>
<script type="text/javascript" src="jsp/sm/validCheck.js"></script>
</head>
<body>
<!-- �α��� ������/�α��� ȸ������/LoginController�� �̵��ؼ� �� ó�� -->

<div>
	<form action="LoginController" method="post" class="login" style="height:330px;" name="loginForm" onsubmit="return loginform()">
		<input type="text" placeholder="User Id" name="id">
 		<input type="password" placeholder="User Password" name="pw">
  		<button class="b1">Login</button><br><br><br>
  		<a href="RegAccountC" style="color:gray;" class="signup">sign up</a><br>
  		<a style="color:gray;" class="signup">���̵� ã��</a>&nbsp;
  		<a style="color:gray;" class="signup">��й�ȣ ã��</a>
	</form>
</div>

</body>
</html>