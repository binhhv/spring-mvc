
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="styles.jsp"%>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tiles:insertAttribute name="nav" />
	<tiles:insertAttribute name="menu" />
	<div class="content-wrapper">
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<tiles:insertAttribute name="footer" />

</body>
</html>