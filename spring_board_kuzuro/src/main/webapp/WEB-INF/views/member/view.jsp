<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
<div class="container">
	<div id="header">
		<%@ include file="../include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<div class="board">
		<div class="board-info">
			 <div class="form-group">
			 	<label for="bno" class="control-label">글 번호</label>
			 	<input type="text" id="bno" class="form-control" value="${board.bno}" readonly="readonly" />
			 </div>
			 <div class="form-group">
			 	<label for="title" class="control-label">글 제목</label>
			 	<input type="text" id="title" class="form-control" value="${board.title}" readonly="readonly" />
			 </div>
			 <div class="form-group">	
			 	<label for="content" class="control-label">글 내용</label>
			 	<textarea id="content" class="form-control" rows="5" cols="50" readonly="readonly">${board.content}</textarea>
			 </div>
			 <div class="form-group">	
			 	<label for="writer" class="control-label">작성자</label>
			 	<input type="text" id="writer" class="form-control" value="${board.writer}" readonly="readonly" />
			 </div>
			 <div class="form-group">	
			 	<label for="regDate" class="col-sm-1 control-label">작성일자</label>
			 	<input type="text" id="regDate" class="form-control" value="<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/>" readonly="readonly" />
			 </div>
		 </div>
		 
		 <div class="board-btn" style="text-align: center;">
			 <div class="form-group">
			 	<a class="btn btn-primary" href="/board/listPageSearch?num=1">게시물 목록</a>
			 	<a class="btn btn-warning" href="/board/modify?bno=${board.bno}">게시물 수정</a>
			 	<a class="btn btn-danger" href="/board/delete?bno=${board.bno}">게시물 삭제</a>
			 </div>
		 </div>
	 </div>
	 
	<!-- 댓글 작성 폼 시작 -->
	<div class="reply">
		<div class="replyForm">
			<!-- action을 지정하지 않았을 경우, 현재의 url로 데이터를 보냄 -->
			<form method="post" action="/reply/write" class="form-horizontal">
				<div class="form-group">
					<label for="writer" class="col-sm-1 control-label">댓글 작성자</label>
					<div class="col-sm-11">
						<input type="text" name="writer" id="writer" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="content" class="col-sm-1 control-label">댓글 내용</label>
					<div class="col-sm-11">
						<textarea rows="5" cols="50" name="content" id="content" class="form-control"></textarea>
					</div>
				</div>
				<!-- 댓글 작성 버튼 -->
				<div class="form-group" style="text-align: center;">
					<input type="hidden" name="bno" value="${board.bno}" />
					<button type="submit" class="repSubmit btn btn-success">댓글 작성</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 댓글 작성 폼 끝 -->
	
	<!-- 댓글 시작 -->
	<div id="reply">
		<ul class="replyList">
			<c:forEach items="${replyList}" var="reply">
			<li>
				<div>
					<div class="form-group">
						<p>
				 			<span class="glyphicon glyphicon-user"></span>
				 			${reply.writer} (<fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/>)
					 		<a class="btn btn-warning btn-xs" href="/reply/modify">수정</a>
					 		<a class="btn btn-danger btn-xs"  href="/reply/delete?bno=${reply.bno}&rno=${reply.rno}" >삭제</a>
				 		</p>
			 		</div>
			 		<div class="form-group">
				 		<p class="bg-info">${reply.content}</p>
			 		</div>
			 	</div>
			 </li>
			 </c:forEach>
		</ul>
	</div>
	<!-- 댓글 끝 -->
	
	<div id="footer">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>
</body>
</html>