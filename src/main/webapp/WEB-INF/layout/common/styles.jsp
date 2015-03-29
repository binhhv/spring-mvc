
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authorize access="isAuthenticated()">
<meta http-equiv="refresh" content="60; url=${APP_CONTEXT}/logout" >
</sec:authorize>
<!-- content="100;URL=/logout"> -->
<link rel="stylesheet"
	href="${APP_CONTEXT }/resources/common/bootstrap/css/bootstrap.min.css">
<link href="${APP_CONTEXT }/resources/common/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE CSS -->
<link href="${APP_CONTEXT }/resources/common/css/style.css" rel="stylesheet" />
<link href="${APP_CONTEXT }/resources/common/css/gm-basic.css" rel="stylesheet" />
<!-- GOOGLE FONT CSS -->
<link href='http://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css' />
<c:forEach items="${styles }" var="style">
	<link rel="stylesheet"
		href="<c:out value="${APP_CONTEXT }/${style }" />">
</c:forEach>
