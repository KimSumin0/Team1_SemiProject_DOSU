<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<!-- �α��� ������/�α��� ȸ������/LoginController�� �̵��ؼ� �� ó�� -->

<div>
	<form action="LoginController" method="post" class="login">
		<input type="text" placeholder="User Id" name="id">
 		<input type="password" placeholder="User Password" name="pw">
  		<td><button>Login</button>
  		<button onclick="location.href='RegAccountC'">Sign Up</button></td>
	</form>
</div>

</body>
</html>