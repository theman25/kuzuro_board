<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<form method="post">
		<table>
			<tr>
				<td><label>제목</label></td>
				<td><input type="text" name="title" /><br /></td>
			</tr>
			<tr>
				<td><label>작성자</label></td>
				<td><input type="text" name="writer" /><br /></td>
			</tr>
			<tr>
				<td><label>내용</label></td>
				<td><textarea rows="5" cols="50"  name="content" ></textarea><br /></td>
			</tr>
			<tr style="text-align:center;">
				<td colspan="2"><button type="submit">작성</button></td>
			</tr>
		</table>
	</form>
</body>
</html>