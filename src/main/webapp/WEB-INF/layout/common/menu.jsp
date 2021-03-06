<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>
<!-- MENU SECTION -->
<div id="side-menu">

	<ul>
		<li style="border-bottom: 0px;"><a
			href='<spring:url value="/" />' title="close"> <i
				class="fa fa-close fa-2x menu-close-icon b-clr"></i></a></li>
		<li><a href='<spring:url value="/" />' title="Home"> <i
				class="fa fa-home fa-2x "></i> <span>Home</span>
		</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href='<spring:url value="/users.html" />'
				title="Users management"> <i class="fa fa-user fa-1x "></i> <span
					class="menu-title">Users</span>
			</a></li>
			<li><a href='<spring:url value="/category.html" />'
				title="Users management"> <i class="fa fa-user fa-1x "></i> <span
					class="menu-title">Category</span>
			</a></li>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			
			<li><a href='<spring:url value="/login.html" />' title="Login"><i
					class="fa fa-sign-in fa-2x "></i> <span>Login</span> </a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li><a href='<spring:url value="/logout" />' title="Login"><i
					class="fa fa-sign-out fa-2x "></i> <span>Logout</span> </a></li>
		</sec:authorize>

	</ul>

</div>
<!--MENU SECTION END-->