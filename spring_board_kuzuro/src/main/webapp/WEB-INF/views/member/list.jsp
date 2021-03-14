<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>

</head>
<body>
<!-- <div id="root"> -->
<div id="container">
	<div id="header">
		<%@ include file="../include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
	
	<div class="board">
		<!-- 검색 -->
		<div  class="search row">
			<div class="col-xs-2 col-sm-2">
				<select class="form-control" name="searchType">
					<option value="userId" <c:if test="${page.searchType eq 'userId'}">selected</c:if> >아이디</option>
					<option value="userNm" <c:if test="${page.searchType eq 'userNm'}">selected</c:if> >이름</option>
					<option value="all" <c:if test="${page.searchType eq ''}">selected</c:if> >아이디+이름</option>
				</select>
			</div>
			<div class="col-xs-10 col-sm-10">
				<div class="input-group">
					<input type="text" class="form-control" name="keyword" value="${page.keyword}" />
					<span class="input-group-btn">
						<button type="button" class="btn btn-default" id="btnSearch">검색</button>
					</span>
				</div>
			</div>
		</div>
		<hr />
		
		<section>
			<table class="table table-hover">
				<thead>
					<tr>
						<td>아이디</td>
						<td>패스워드</td>
						<td>이름</td>
						<td>가입일자</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList}" var="list">
						<tr>
							<td>${list.userId}</td>
							<td>${list.userPw}</td>
							<td>${list.userNm}</td>
							<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
							<!-- 여기서는 jstl방식으로 처리 만약 js(자바스크립트)만 이용다면 js의 Date형식 or moment.js -->
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
						<a href="/board/listPageSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">[이전]</a>
					</li>
				</c:if>
				<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
					<li <c:out value="${select == num ? 'class=active' : ''}"/>>
						<a href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
					</li>
				</c:forEach>
				<c:if test="${page.next}">
					<li>
						<a href="/board/listPageSearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}">[다음]</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>
<script type="text/javascript">
	document.getElementById("btnSearch").onclick = function(){
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword =  document.getElementsByName("keyword")[0].value;
		
		//console.log("searchType : " + searchType);
		//console.log("keyword : " + keyword);
		location.href = "/member/list?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;   
	};
</script>
</body>
</html>