<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");


%>

<fieldset>
	<h5>���̵� �ߺ� üũ</h5>
	<form action="../joinIdCheckController" method="post" name="wfr">
		ID : <input type="text" name="userid" value="<%=id%>">
		<input type="submit" value="�ߺ� Ȯ��">
	</form>
</fieldset>


</body>
</html>