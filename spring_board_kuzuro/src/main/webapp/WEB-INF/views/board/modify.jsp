<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<!-- action을 지정하지 않았을 경우, 현재의 url로 데이터를 보냄 -->
	<form method="post">
		<table>
			<tr>
				<td><label>제목</label></td>
				<td><input type="text" name="title" value="${board.title}" /><br /></td>
			</tr>
			<tr>
				<td><label>작성자</label></td>
				<td><input type="text" name="writer" value="${board.writer}" /><br /></td>
			</tr>
			<tr>
				<td><label>내용</label></td>
				<td><textarea rows="5" cols="50"  name="content" >${board.content}</textarea><br /></td>
			</tr>
			<tr style="text-align:center;">
				<td colspan="2"><button type="submit">수정</button></td>
			</tr>
		</table>
	</form>
</body>
</html>