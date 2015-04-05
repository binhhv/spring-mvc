<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp"%>
<div class="box">
	<div class="box-header">
		<h3 class="box-title">Blog List</h3>
		
		<div class="pull-right box-tools">
			<button type="button" class="btn btn-primary btn-sm iframe cboxElement" data-toggle="modal"
	data-target="#blogModal" onclick="addBlog()">
				<span class="fa fa-plus-circle"></span> Create
			</button>
			<!-- <a href="#" onclick="oTable.fnReloadAjax()" class="btn btn-primary btn-sm"><i class="fa fa-refresh"></i></a> -->
		</div>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<table id="table-blog" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th width="50">No</th>
					<th>Title</th>
					<th>Content</th>
					<th width="150">Category</th>
					<th>Date</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${blogs }" var="blog" varStatus="loop">
					<tr>
						<td><c:out value="${loop.index + 1}" /></td>
						<td><c:out value="${fn:substring(blog.title, 0, 20)}" /><c:if test="${blog.title.length() > 20 }">...</c:if></td>
						<td><c:out value="${fn:substring(blog.content, 0, 20)}" /><c:if test="${blog.content.length() > 20 }">...</c:if></td>
						<td><c:out value="${blog.category.name }" /></td>
						<td><c:out value="${blog.created_at }" /></td>
						<td width="200"><button class="btn btn-success"
								onclick="viewBlog(${blog.id});">View</button>&nbsp;
						<button class="btn btn-primary"
								onclick="editBlog(${blog.id});">Edit</button> <%-- <a href="${APP_CONTEXT }/category/${category.id }.html?edit" class="btn btn-primary" >Edit</a> --%>
							&nbsp;
							<button id="category-delete-id-${blog.id}"
								data-url="${APP_CONTEXT }/blog/delete/${blog.id }.html"
								class="btn btn-danger" onclick="deleteBlog(${blog.id});">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>No</th>
					<th>Title</th>
					<th>Content</th>
					<th>Category</th>
					<th>Date</th>
					<th></th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- /.box-body -->
</div>

<div id="blogDialog">
			<%@ include file="form/formBlog.jsp" %>
</div>


<!-- Modal -->
<div class="modal fade" id="modalRemoveBlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Category</h4>
      </div>
      <div class="modal-body">
        Do you want to delete blog ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cance</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>