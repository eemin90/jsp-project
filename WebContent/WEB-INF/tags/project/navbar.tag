<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
<div>
	<a href="<%= request.getContextPath() %>/project/main">메인</a>
	|
	<c:if test="${empty sessionScope.userLogined}">
		<a href="<%= request.getContextPath() %>/project/member/signup">회원가입</a>
		|
		<a href="<%= request.getContextPath() %>/project/member/login">로그인</a>
		|
	</c:if>
	
	<c:if test="${not empty sessionScope.userLogined}">
		<a href="<%= request.getContextPath() %>/project/member/logout">로그아웃</a>
		|
		<a href="<%= request.getContextPath() %>/project/member/info">정보보기</a>
		|
		<a href="<%= request.getContextPath() %>/project/board/write">글쓰기</a>
		|
		<a href="<%= request.getContextPath() %>/project/member/list">회원 목록보기</a>
		|
	</c:if>	
	<a href="<%= request.getContextPath() %>/project/board/list">글 목록보기</a>
</div>
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="<%= request.getContextPath() %>/project/main">
    	<%-- <img src="<%= request.getContextPath() %>/res/img/BrandLogo.png" width="40" height="40" alt=""> --%>
    	<i class="fas fa-chalkboard"></i>
    	<span>JSP 게시판</span>
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active">
			  <a class="nav-link" href="<%= request.getContextPath() %>/project/main">Home<span class="sr-only">(current)</span></a>
			</li>
			
			<c:if test="${empty sessionScope.userLogined}">
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/member/signup">회원가입</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/member/login">로그인</a>
				</li>
			</c:if>
			
			<c:if test="${not empty sessionScope.userLogined}">
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/member/logout">로그아웃</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/member/info">정보보기</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/board/write">글쓰기</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="<%= request.getContextPath() %>/project/member/list">회원 목록보기</a>
				</li>
			</c:if>
			
			<li class="nav-item">
			  <a class="nav-link" href="<%= request.getContextPath() %>/project/board/list">글 목록보기</a>
			</li>
		</ul>
	</div>
</nav>