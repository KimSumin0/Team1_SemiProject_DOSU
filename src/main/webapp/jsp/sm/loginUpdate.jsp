<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="jsp/sm/reg.js"></script>
<script type="text/javascript" src="jsp/sm/validCheck.js"></script>
</head>
<body>

<div>
	<form action="InfoEditCotroller" method="post" class="login" name="updateForm" onsubmit="return update()">
	
		<h2>My Page</h2><br><br>
		<p style="font-size: 6px; text-align: left;">���̵�</p>
		<p style="font-size: 6px; text-align: left;">${sessionScope.accountInfo.user_id }</p><br>
		
		<p style="font-size: 6px; text-align: left;">���� ��й�ȣ</p>
		<p style="font-size: 6px; text-align: left;">${sessionScope.accountInfo.user_pw }</p><br>
		
		<p style="font-size: 6px; text-align: left;">���� ��й�ȣ</p>
		<p style="font-size: 6px; text-align: left;">
		<input type="text" name="pw2"></p><br>
		
		<p style="font-size: 6px; text-align: left;">���� ��й�ȣ ��Ȯ��</p>
		<p style="font-size: 6px; text-align: left;">
		<input type="text" name="pw3"></p><br>
		
		<p style="font-size: 6px; text-align: left;">�̸�</p>
		<p style="font-size: 6px; text-align: left;">${sessionScope.accountInfo.user_name }</p><br>
 		 		
		<p style="font-size: 6px; text-align: left;">����</p>
		<p style="font-size: 6px; text-align: left;">${sessionScope.accountInfo.user_gender }</p><br>
  		
		<p style="font-size: 6px; text-align: left;">�ּ�</p>
		<p style="font-size: 6px; text-align: left;">
		<input type="text" name="addr" placeholder="${sessionScope.accountInfo.user_addr }"></p><br>

		<p style="font-size: 6px; text-align: left;">����ó</p>
		<p style="font-size: 6px; text-align: left;">
		<input type="text" name="phoneNum" placeholder="${sessionScope.accountInfo.user_phoneNumber }" maxlength="11"></p><br>

		<p style="font-size: 6px; text-align: left;">����</p>
		<p style="font-size: 6px; text-align: left;">${sessionScope.accountInfo.user_age }</p><br>
							
  		<br><button>�����ϱ�</button><br>
  		<a href="AccountDropController">
  		<p style="font-size: 6px; text-align: right; color: gray;">Ż���ϱ�</p></a>
	</form>
		
</div>

</body>
</html>