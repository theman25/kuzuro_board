<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body><!-- <div id="root"> -->
<div id="container">
	<div id="header">
		<%@ include file="../include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
	
	<section>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>작성자</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="list">
					<tr>
						<td>${list.bno}</td>
						<td>
							<a href="/board/view?bno=${list.bno}">
							${list.title}
						</a>
						</td>
						<td>
							<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/>
						</td>
						<!-- 여기서는 jstl방식으로 처리 만약 js(자바스크립트)만 이용다면 js의 Date형식 or moment.js -->
						<td>${list.writer}</td>
						<td>${list.viewCnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<!-- 페이징 -->
	<div style="text-align: center;">
		<ul class="pagination">
			<c:if test="${page.prev}">
				<li>
					<a href="/board/listPage?num=${page.startPageNum - 1}">[이전]</a>
				</li>
			</c:if>
			<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
				<li <c:out value="${select == num ? 'class=active' : ''}"/>>
					<a href="/board/listPage?num=${num}">${num}</a>
				</li>
			</c:forEach>
			<c:if test="${page.next}">
				<li>
					<a href="/board/listPage?num=${page.endPageNum + 1}">[다음]</a>
				</li>
			</c:if>
		</ul>
		<%-- 
		<c:forEach begin="1" end="${pageNum}" var="num">
			<span>
				<a href="/board/listPage?num=${num}">${num}</a>
			</span>
		</c:forEach>
		 --%>
	</div>	
	
	<div id="footer">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>
</body>
</html>