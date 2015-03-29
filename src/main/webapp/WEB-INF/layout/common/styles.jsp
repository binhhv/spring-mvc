
<%@ include file="/WEB-INF/layout/includes.jsp" %>
<sec:authorize access="isAuthenticated()">
<meta http-equiv="refresh" content="600; url=${APP_CONTEXT}/logout" >
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
