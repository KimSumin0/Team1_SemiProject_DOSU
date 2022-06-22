<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form class="login" style="height:500px; width:1000px;">
<table id="tbl_board_title">
	<tr style="font-weight: 1000;">
		<td class="board_td_title">�����Խ��� �˻� ���&emsp;&emsp;</td>
		<td class="board_td_title"><a href="FreeRegC">�۾���&emsp;&emsp;</a></td>
		<td style="width: 400px"></td>
		<td><select class="form-control" name="searchField">
				<option value="board_title">����</option>
				<option value="board_txt">����</option>
				<option value="user_id">�ۼ���</option>
			</select></td>
		<td><input type="text" class="form-control"
			placeholder="�˻��� �Է�" name="searchText" maxlength="10"></td>
		<td><button type="submit" class="btn btn-success">�˻�</button></td>

</table><hr><br><br>

<table>
<c:forEach var="p" items="${posts }">


	<tr class="f_tr1">
		<td class="f_td1" style="width:5%;">${p.board_num }</td>
		<td class="f_td1" style="width:30%; text-align: center;" onclick="location.href='boardFreeDetailC?No=${p.board_num }'">${p.board_title }</td>
		<td class="f_td1">${p.user_id }</td>
		<td class="f_td1"><fmt:formatDate value="${p.board_date }" type="both" dateStyle="short" timeStyle="short"/></td>
	</tr>
</c:forEach>
</table>

</form>




</body>
</html>