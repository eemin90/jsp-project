<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${not empty message}">
		<br>
		<div class="alert alert-danger" role="alert">
			${message}
			<%-- <c:remove var="message" scope="session" /> --%>
			<c:remove var="message" />
		</div>
	</c:when>
	<c:when test="${not empty modifyFailedMsg}">
		<br>
		<div class="alert alert-danger" role="alert">
			${modifyFailedMsg}
			<c:remove var="modifyFailedMsg" />
		</div>
	</c:when>
	<c:when test="${not empty modifyMsg}">
		<br>
		<div class="alert alert-success" role="alert">
			${modifyMsg}
			<c:remove var="modifyMsg" />
		</div>
	</c:when>
</c:choose>