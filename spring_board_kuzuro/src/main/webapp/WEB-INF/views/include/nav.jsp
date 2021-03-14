<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<c:set value="${sessionScope.member}" var="member"/>

<div class="form-group">
	<ul class="nav nav-pills">
		<c:if test="${member != null}">
			<li class="col-sm-2"><b>[${member.userNm}] 님 환영합니다.</b></li>
		</c:if>
	</ul>
	<ul class="nav nav-pills">
		<c:if test="${member == null}">
			<li><a href="/member/regist">회원가입</a></li>
			<li><a href="/member/list?num=1">회원목록</a></li>
			<li><a href="/member/login">로그인</a></li>
		</c:if>
		<c:if test="${member != null}">
			<li><a href="/member/logout">로그아웃</a></li>
		</c:if>
	</ul>
	<ul class="nav nav-pills">
		<c:if test="${member != null}">
			<li><a href="/board/write">글 작성</a></li>
		</c:if>
		<li><a href="/board/list">글 목록</a></li>
		<li><a href="/board/listPage?num=1">글 목록(페이징)</a></li>
		<li><a href="/board/listPageSearch?num=1">글 목록(페이징 + 검색)</a></li>
	</ul>
	<hr />
</div>