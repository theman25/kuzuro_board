<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
	
	<table border="1" >
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
						<a href="/board/view?bno=${list.bno}">${list.title}</a>
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
	
	<div>
		<c:if test="${prev}">
			<span>
				<a href="/board/listPage?num=${startPageNum - 1}">[이전]</a>
			</span>
		</c:if>
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
			<span>
				<c:if test="${select != num}">
					<a href="/board/listPage?num=${num}">${num}</a>
				</c:if>
				<c:if test="${select == num}">
					<b style="color: red;">${num}</b>
				</c:if>
			</span>
		</c:forEach>
		<c:if test="${next}">
			<span>
				<a href="/board/listPage?num=${endPageNum + 1}">[다음]</a>
			</span>
		</c:if>
		<%-- 
		<c:forEach begin="1" end="${pageNum}" var="num">
			<span>
				<a href="/board/listPage?num=${num}">${num}</a>
			</span>
		</c:forEach>
		 --%>
	</div>
</body>
</html>