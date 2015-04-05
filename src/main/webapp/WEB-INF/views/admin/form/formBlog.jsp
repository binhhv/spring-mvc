<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp"%>
<form:form id="blogForm-id" method="post" action=""
	modelAttribute="form">
	<!-- <form role="form" name="form" action="" method="post" id="blogForm-id"> -->
	<div class="modal fade modal-category" id="blogModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Blog</h4>
				</div>
				<div class="modal-body">
					<div class="error" id="error-blog"></div>
					<div class="form-group">
						<label for="InputName">Category</label>

						<form:select path="category" cssClass="form-control">
							<%-- <form:options <c:if test="${category.id eq  categories.category.id }"> selected </c:if> items="${categories}" itemValue="id"
								itemLabel="name" /> --%>
								<c:forEach items="${categories }" var="categoryBlog">
									<c:choose>
										<c:when test="${form.category.id == categoryBlog.id }">
											<form:option value="${categoryBlog.id }" selected ="selected" ><c:out value="${categoryBlog.name }" /></form:option>
										</c:when>
										<c:when test="${form.category.id != categoryBlog.id }">
											<form:option value="${categoryBlog.id }"  ><c:out value="${categoryBlog.name }" /></form:option>
										</c:when>
									</c:choose>
								</c:forEach>
						</form:select>
						<%-- <select class="form-control" name="cbCategory">
							<c:forEach items="${categories }" var="category">
								<option <c:if test="${form.category.id == category.id } }"> selected </c:if> value='<c:out value="${category.id }" />'><c:out value= "${category.name }" /></option>
							</c:forEach>
							</select> --%>

					</div>
					<div class="form-group">
						<label for="InputName">Title</label>
						<div class="input-group">
							<form:input path="title" id="title" cssClass="form-control"
								placeholder="Enter title" />
							<%-- <input type="text" class="form-control" name="title" id="title"
								value="${form.title}" placeholder="Enter title" required
								autofocus /> --%>
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputName">Content</label>
						<div class="input-group">
							<%-- <textarea class="form-control" rows="3">${form.content }</textarea> --%>
							<form:textarea path="content" cssClass="form-control" rows="5"
								cols="10000" />
						</div>
					</div>

					<c:if test="${form.id != 0 }">
						<%-- <input type="hidden" name="id" value="${form.id}" /> --%>
						<form:hidden path="id" />
					</c:if>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						id="btn-close-categoryForm">Close</button>
					<input type="button" name="submit" id="submit" value="Submit"
						class="btn btn-info pull-right" onclick="submitBlog();">
				</div>
			</div>
		</div>
	</div>
	<!-- </form> -->
</form:form>