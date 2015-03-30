<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>

<div class="row">
    <div class="col-lg-10 col-lg-offset-1"><h1>Category List </h1></div>
</div>
<div class="row">
<div class="col-md-10 col-md-offset-1">
<span class="pull-right">
<button type="button" class="btn btn-primary btn-md" data-toggle="modal"
	data-target="#myModal" onclick="addCategory()">New Category</button></span>
</div>
<div class="col-md-10 col-md-offset-1 row-category">
	<table class="table table-striped table-bordered table-hover"
		 id="table-category" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Date</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${categories }" var="category" varStatus="loop">
			<tr>
				<td><c:out value="${loop.index + 1}" /></td>
				<td><c:out value="${category.name }" /></td>
				<td><c:out value="${category.created_at }" /></td>
				<td><button class="btn btn-primary"
									onclick="editCategory(${category.id});">Edit</button>
				<%-- <a href="${APP_CONTEXT }/category/${category.id }.html?edit" class="btn btn-primary" >Edit</a> --%>
				&nbsp;<a href="${APP_CONTEXT }/category/${category.id }.html?delete" class="btn btn-danger"  >Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!-- Button trigger modal -->
<div id="categoryDialog">
			<%@ include file="form/formCategory.jsp" %>
</div>


<!-- Modal -->

