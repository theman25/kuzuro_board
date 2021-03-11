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
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<!-- 
	<form method="post">
		<table>
			<tr>
				<td><label>제목</label></td>
				<td><input type="text" name="title" value="${board.title}"/><br /></td>
			</tr>
			<tr>
				<td><label>작성자</label></td>
				<td><input type="text" name="writer" value="${board.writer}" /><br /></td>
			</tr>
			<tr>
				<td><label>내용</label></td>
				<td><textarea rows="5" cols="50"  name="content" >${board.content}</textarea><br /></td>
			</tr>
			<tr>
				<td><a href="/board/modify?bno=${board.bno}">수정</a></td>
				<td><a href="/board/delete?bno=${board.bno}">삭제</a></td>
			</tr>
		</table>
	</form>
	 -->
	 <h2>${board.title}</h2>
	 <hr />
	 
	 <div class="wrter">
	 	<span>작성자 : </span>${board.writer}
	 </div>
	 <hr />
	 
	 <div class="content">
	 	${board.content}
	 </div>
	 <hr />
	 
	 <div class="wrter">
	 	<a href="/board/modify?bno=${board.bno}">게시물 수정</a>
	 	<a href="/board/delete?bno=${board.bno}">게시물 삭제</a>
	 </div>
	 
	<!-- 댓글 시작 -->
	<hr />
	
	<ul>
		<!-- 
		<li>
			<div>
				<p>첫번째 댓글 작성자</p>
				<p>첫번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>두번째 댓글 작성자</p>
				<p>두번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>세번째 댓글 작성자</p>
				<p>세번째 댓글</p>
			</div>
		</li>
		 -->
		 <c:forEach items="${replyList}" var="reply">
		 <li>
		 	<div>
		 		<p>${reply.writer} / <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/></p>
		 		<p>${reply.content}</p>
		 	</div>
		 </li>
		 </c:forEach>
	</ul>
	
	<div>
		<!-- action을 지정하지 않았을 경우, 현재의 url로 데이터를 보냄 -->
		<form method="post" action="/reply/write">
			<p>
				<label>댓글 작성자</label>
				<input type="text" name="writer">
			</p>
			<p>
				<textarea rows="5" cols="50" name="content"></textarea>
			</p>
			<p>
				<input type="hidden" name="bno" value="${board.bno}" />
				<button type="submit">댓글 작성</button>
			</p>
		</form>
	</div>
	<!-- 댓글 끝 -->
</body>
</html>