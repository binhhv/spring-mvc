<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="com.binhhv.contants.*" %>	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-signin" action="j_spring_security_check" method="POST">

	<h2 class="form-signin-heading">Please sign in</h2>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<input type="text" name="j_username" class="form-control"
		placeholder="Name" required autofocus value="<c:out value="${sessionScope.LAST_USERNAME}"/>"> <br> <input
		type="password" name="j_password" class="form-control"
		placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
		in</button>
</form>

