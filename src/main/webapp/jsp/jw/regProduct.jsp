<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>��ǰ���</h1>
	<form action="ProductDAO"  method = "post" enctype="multipart/form-data">
	<table id = "productTbl">
			<tr>
				<td>��ǰ �̸�</td>
				<td><input name = title></td>
			</tr>
			<tr>
				<td>�ǸŰ�</td>
				<td><input name = "price"></td>
			</tr>
			<tr>
				<td>��ǥ �̹���</td> 
				<td> <input type="file" name = "file"></td> 
			</tr>
			<tr>
				<td>�̹���1</td> 
				<td> <input type="file" name = "file1"></td> 
			</tr>
			<tr>
				<td>�̹���2</td> 
				<td> <input type="file" name = "file2"></td> 
			</tr>
			<tr>
				<td>�̹���3</td> 
				<td> <input type="file" name = "file3"></td> 
			</tr>
			<tr>
				<td>�󼼳���</td>
				<td><textarea name = "exp"></textarea></td>
			</tr>
			<tr>
				<td>�ؽ��±�</td>
				<td><input name = "tag"></td>
			</tr>
			<tr>
				<td colspan="2"><button>���</button></td>
			</tr>
	</table>
	</form>
</body>
</html>