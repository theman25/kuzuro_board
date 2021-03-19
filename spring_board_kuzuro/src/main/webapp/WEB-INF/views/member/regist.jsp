<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
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
					<input type="text" name="userId" id="userId" class="form-control" />
				</div>
				<div class="col-sm-3">
					<button type="button" id="btnCheckId" class="btn btn-default" >아이디 확인</button>
				</div>
			</div>
					<p class="result">
						<span class="msg">아이디를 입력해주세요.</span>
					</p>
			<div class="form-group">
				<label for="userPw" class="col-sm-4 control-label">패스워드</label>
				<div class="col-sm-3">
					<input type="password" name="userPw" id="userPw" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="userNm" class="col-sm-4 control-label">이름</label>
				<div class="col-sm-3">
					<input type="text" name="userNm" id="userNm" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div style="text-align:center;">
					<button type="submit" class="btn btn-success" id="submit" disabled="disabled">회원 가입</button>
					<!-- <a href="javascript:history.back();" class="btn btn-default">취소</a> -->
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
<script type="text/javascript">
	$("#btnCheckId").click(function(){
		var query = {userId : $("#userId").val()};
		$.ajax({
			url : "/member/checkId",
			type : "post",
			data : query,
			success : function(data){
				console.log("data : " + data);
				if(data == 1){
					$(".result .msg").text("사용 불가");
					$(".result .msg").attr("style", "color:#f00");
					$("#submit").attr("disabled", "disabled");
				} else {
					$(".result .msg").text("사용 가능");
					$(".result .msg").attr("style", "color:#00f");
					$("#submit").removeAttr("disabled");
				}
			},
			error : function(request,status,error){
				console.log("code : " + request.status + "\n"
							+ "message : " + request.responseText + "\n"
							+ "error : " + error);
			}
		});
	});
</script>
</html>