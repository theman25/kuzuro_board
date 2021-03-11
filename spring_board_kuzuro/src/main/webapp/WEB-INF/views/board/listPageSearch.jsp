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
	
	<!-- 페이징 -->
	<div>
		<c:if test="${page.prev}">
			<span>
				<a href="/board/listPageSearch?num=${page.startPageNum - 1}">[이전]</a>
			</span>
		</c:if>
		<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
			<span>
				<c:if test="${select != num}">
					<a href="/board/listPageSearch?num=${num}">${num}</a>
				</c:if>
				<c:if test="${select == num}">
					<b style="color: red;">${num}</b>
				</c:if>
			</span>
		</c:forEach>
		<c:if test="${page.next}">
			<span>
				<a href="/board/listPageSearch?num=${page.endPageNum + 1}">[다음]</a>
			</span>
		</c:if>
	</div>
	
	<!-- 검색 -->
	<div>
		<select name="searchType">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="title_content">제목+내용</option>
			<option value="writer">작성자</option>
		</select>
		
		<input type="text" name="keyword" />
		
		<button type="button" id="btnSearch">검색</button>
	</div>
<script type="text/javascript">
	document.getElementById("btnSearch").onclick = function(){
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword =  document.getElementsByName("keyword")[0].value;
		
		//console.log("searchType : " + searchType);
		//console.log("keyword : " + keyword);
		location.href = "/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;   
	};
</script>
</body>
</html>