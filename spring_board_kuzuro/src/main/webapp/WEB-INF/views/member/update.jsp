<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<div class="container">
	<div id="header">
		<%@ include file="../include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<div class="member-regist-form">
		<form method="post" class="form-horizontal">
			<div class="form-group">
				<label for="userId" class="col-sm-4 control-label">아이디</label>
				<div class="col-sm-3">
					<input type="text" name="userId" id="userId" class="form-control" value="${member.userId}" readonly="readonly" />
				</div>
			</div>
			<div class="form-group">
				<label for="userPw" class="col-sm-4 control-label">패스워드</label>
				<div class="col-sm-3">
					<input type="password" name="userPw" id="userPw" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="userNm" class="col-sm-4 control-label">이름</label>
				<div class="col-sm-3">
					<input type="text" name="userNm" id="userNm" class="form-control" value="${member.userNm}" />
				</div>
			</div>
			<c:if test="${msg == false}">
				<p style="color:#f00; text-align:center;">
					패스워드가 일치하지 않습니다. 패스워드를 확인 해주세요.
				</p>
			</c:if>
			<div class="form-group">
				<div style="text-align:center;">
					<button type="submit" class="btn btn-success">회원 정보 수정</button>
					<a href="javascript:history.back();" class="btn btn-default">취소</a>
					<a href="/" class="btn btn-default">처음으로</a>
				</div>
			</div>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>
</body>
</html>