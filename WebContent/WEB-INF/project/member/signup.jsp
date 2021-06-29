<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/project" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>

<title>signup</title>

<script>
	var url = "${pageContext.request.contextPath}" + "/project/member/checkdup";

	$(document).ready(function() {
		$("#button1").click(function() {
			var id = $("#input1").val();
			
			$.post(url, {id: id}, function(data) {
				if (data == 'ok') {
					// 가입 가능 메세지
					console.log("ok");
					$("#span1").text("사용 가능");
				} else {
					// 가입 불가능 메세지
					console.log("not ok");
					$("#span1").text("사용 불가능");
				}
			});
		});
	});
</script>

</head>
<body>
<my:navbar />
<div class="container">
	<h1>회원 가입</h1>
	<br>
	<form action="${pageContext.request.contextPath}/project/member/signup" method="post">
		<div class="form-group">
			<label for="input1">아이디 </label>
			<div class="input-group mb-3">
				<input type="text" id="input1" name="id" class="form-control" required>
					<div class="input-group-append">
						<button type="button" id="button1" class="btn btn-outline-secondary">중복확인</button>
					</div>
				</div>
			<span class="form-text text-muted" id="span1"></span>
		</div>
		<div class="form-group">
			<label for="input2">암호 </label>
			<input type="text" id="input2" name="password" class="form-control" required> <br>
		</div>
		<div class="form-group">
			<label for="input3">이름 </label>
			<input type="text" id="input3" name="name" class="form-control" required> <br>
		</div>
		<div class="form-group">
			<label for="input4">생년월일 </label>
			<input type="date" id="input4" name="birth" class="form-control" required> <br>
		</div>
		<input type="submit" value="가입" class="btn btn-primary">
	</form>
	
	<my:message />
</div>
</body>
</html>