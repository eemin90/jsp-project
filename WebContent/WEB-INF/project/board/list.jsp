<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/project" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>

<title>list</title>
</head>
<body>
<my:navbar />
<div class="container">
	<h1>글 목록</h1>
	<h6>총 ${totalNum}개의 게시글이 있습니다.</h6>
	<br>
	<my:message />
	<table class="table table-bordered table-sm">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>이름</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.boardId}</td>
					<td>
						<a href="${pageContext.request.contextPath}/project/board/detail?id=${board.boardId}">
							${board.title}
						</a>
						<c:if test="${board.numberOfComment != 0}">
							<%-- <span></i>[${board.numberOfComment}]</span> --%>
							<span class="fa-layers fa-fw">
								<i class="fas fa-comment-alt"></i>
								<span class="fa-layers-counter" style="font-size: 30px;">${board.numberOfComment}</span>
							</span>
						</c:if>
					</td>
					<td>${board.memberName}</td>
					<td>${board.timeAgo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav>
		<ul class="pagination justify-content-center">
			<c:forEach var="p" begin="1" end="${pageCnt}">
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/project/board/list?page=${p}">${p}</a></li>
			</c:forEach>
		</ul>
	</nav>
</div>
</body>
</html>