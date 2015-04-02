<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>
<script type="text/javascript">
	var contexPath = "<%=request.getContextPath() %>";
</script>
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
				<td width="200"><button class="btn btn-primary"
									onclick="editCategory(${category.id});">Edit</button>
				<%-- <a href="${APP_CONTEXT }/category/${category.id }.html?edit" class="btn btn-primary" >Edit</a> --%>
				&nbsp;<button id ="category-delete-id-${category.id}" data-url="${APP_CONTEXT }/category/delete/${category.id }.html" class="btn btn-danger"
									onclick="deleteCategory(${category.id});">Delete</button></td>
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
<div class="modal fade" id="modalRemoveCategory" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Category</h4>
      </div>
      <div class="modal-body">
        Do you want to delete category ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cance</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

