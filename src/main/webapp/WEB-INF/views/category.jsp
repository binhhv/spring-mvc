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
	data-target="#myModal">New Category</button></span>
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
				<td><a href="${APP_CONTEXT }/category/${category.id }.html?edit" class="btn btn-primary" >Edit</a>&nbsp;<a href="${APP_CONTEXT }/category/${category.id }.html?delete" class="btn btn-danger"  >Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!-- Button trigger modal -->


<!-- Modal -->
<form role="form" name="form" action="" method="post">
	<div class="modal fade modal-category" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		data-success="${success }">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Category</h4>
				</div>
				<div class="modal-body">
					<spring:bind path="form">
						<c:if test="${status.error }">
							<div class="error">
								<c:forEach items="${status.errorMessages }" var="error">
									<c:out value="${error }" />
								</c:forEach>
							</div>
						</c:if>
					</spring:bind>
					<div class="form-group">
						<label for="InputName">Name</label>
						<div class="input-group">
							<input type="text" class="form-control" name="name" id="name"
								value="${form.name}" placeholder="Enter Username" required
								autofocus /> <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" name="submit" id="submit" value="Submit"
						class="btn btn-info pull-right">
				</div>
			</div>
		</div>
	</div>
</form>
