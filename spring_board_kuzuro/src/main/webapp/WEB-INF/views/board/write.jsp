<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>

<div class="container">
	<div id="header">
		<%@ include file="../include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<div class="board-write-form">
		<c:if test="${msg == null}">
			<form method="post" class="form-horizontal">
				<div class="form-group">
					<label for="title" class="col-sm-1 control-label">제목</label>
					<div class="col-sm-11">
						<input type="text" name="title" id="title" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="writer" class="col-sm-1 control-label">작성자</label>
					<div class="col-sm-11">
						<input type="text" name="writer" id="writer" class="form-control" value="${member.userNm}" readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<label for="content" class="col-sm-1 control-label">내용</label>
					<div class="col-sm-11">
						<textarea rows="5" cols="50" name="content" id="content" class="form-control" ></textarea>
					</div>
				</div>
				<div class="form-group">
					<div style="text-align:center;">
						<button type="submit" class="btn btn-success">작성</button>
						<a href="javascript:history.back();" class="btn btn-default">취소</a>
					</div>
				</div>
			</form>
		</c:if>
		<c:if test="${msg == false}">
			<p>로그인이 필요한 서비스 입니다.</p>
			<p><a href="/meber/login">로그인 화면으로 이동</a>
		</c:if>
	</div>
	
	<div id="footer">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>
</body>
</html>