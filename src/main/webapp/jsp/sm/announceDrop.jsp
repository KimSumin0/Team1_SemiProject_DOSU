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

<div>
	<form class="login">
		<h2>ȸ�� Ż�� �ȳ�</h2><br><br>
		<p style="font-size: 6pt; text-align: left;">
		ȸ�� Ż�� ��û�ϱ� ���� �ȳ� ������ �� Ȯ�����ּ���.<br>
		ȸ���Բ��� ����ϰ� ��� ���̵�(${sessionScope.accountInfo.user_id })�� Ż���� ��� ���� �� ������ �Ұ����մϴ�.<br><br>
		�� Ż���� ���̵�� ���ΰ� Ÿ�� ��� ���� �� ������ �Ұ��Ͽ��� �����ϰ� �����Ͻñ� �ٶ��ϴ�.<br><br>
		�� Ż�� �� ȸ������ �� ������ ���� �̿����� ��� �����˴ϴ�.<br><br>
		�� Ż�� �Ŀ��� �Խ��� ���񽺿� ����� �Խù��� �״�� ���� �ֽ��ϴ�.<br>������ ���ϴ� �Խñ��� �ִٸ� �ݵ�� Ż�� �� �����Ͻñ� �ٶ��ϴ�.<br><br>
		�� Ż�� �Ŀ��� ���̵�(${sessionScope.accountInfo.user_id }) �� �ٽ� ������ �� �����ϴ�.	<br><br><br>	
	<label for="agree">
		<input type="checkbox" id="agree" name="agree" onchange="aaa()">
		�ȳ� ������ ��� Ȯ���Ͽ�����, �̿� �����մϴ�.
	</label><br><br>		
  		<button type="button" id="checkButton" name="checkButton" disabled="disabled"
  		 style="font-size: 10pt;" onclick="location.href='AccountDropController2'">ȸ�� Ż��</button>	
	</form>
</div>

<script type="text/javascript">
function aaa() {
	let btn = document.getElementById('checkButton');
	let asd = btn.disabled;
	if(asd){
	btn.disabled = false;
	}else{
	btn.disabled = true;		
	}	
}
</script>
</body>
</html>