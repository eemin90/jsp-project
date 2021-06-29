<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/project" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>

<script>
	$(document).ready(function() {
		$("#button1").click(function() {
			$("#input2, #input3, #input4").removeAttr("readonly");
			$("#submit1").removeAttr("hidden")
		});
		
		/* event 실행 방지 */
		$("#submit2").click(function(e) {
			e.preventDefault();
			
			/* var con = confirm("탈퇴 하시겠습니까?"); */
			/* if (con) { */
			if (confirm("탈퇴 하시겠습니까?")) {
				$("#form2").submit();
				alert("탈퇴 되었습니다.");
			}
			
		});
	});
</script>

</head>
<body>
<my:navbar />
<div class="container">
	<h1>회원 정보</h1>
	<br>
	<form id="form1" action="${pageContext.request.contextPath}/project/member/modify" method="post">
		<div class="form-group">
			<label for="input1">아이디</label>
			<input type="text" id="input1" name="id" value="${member.id}" class="form-control" readonly>
		</div>
		<div class="form-group">
			<label for="input2">암호</label>
			<input type="text" id="input2" name="password" value="${member.password}" class="form-control" readonly>
		</div>
		<div class="form-group">
			<label for="input3">이름</label>
			<input type="text" id="input3" name="name" value="${member.name}" class="form-control" readonly>
		</div>
		<div class="form-group">
			<label for="input4">생년월일</label>
			<input type="date" id="input4" name="birth" value="${member.birth}" class="form-control" readonly>
		</div>
		<div class="container">
			작성한 게시물 : <span>${member.numberOfBoard}</span>개
			<br>
			작성한 댓글 : <span>${member.numberOfComment}</span>개
		</div>
		<br>
		<button type="button" id="button1" class="btn btn-outline-secondary">수정</button>
		<input type="submit" id="submit1" value="전송" class="btn btn-outline-success" hidden>
	</form>
</div>


<div class="container">
	<form id="form2" action="${pageContext.request.contextPath}/project/member/remove" method="post">
		<br>
		<input type="submit" id="submit2" value="탈퇴" class="btn btn-outline-danger">
	</form>
	
	<my:message />
</div>
</body>
</html>