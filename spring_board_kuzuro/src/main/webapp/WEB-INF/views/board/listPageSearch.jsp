<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
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
					<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if> >제목</option>
					<option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if> >내용</option>
					<option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if> >제목+내용</option>
					<option value="writer" <c:if test="${page.searchType eq 'writer'}">selected</c:if> >작성자</option>
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
									<c:if test="${list.replyCnt > 0}">
										<span style="color:red;">[${list.replyCnt}]</span>
									</c:if>
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
		location.href = "/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;   
	};
</script>
</body>
</html>