<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>
<form:form method="post" action="" id="categoryForm-id" modelAttribute="form">
<!-- <form role="form" name="form" action="" method="post" id="categoryForm-id"> -->
	<div class="modal fade modal-category" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		>
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
						<div class="error" id ="error-category"></div>
					<%-- <spring:bind path="form">
						<c:if test="${status.error }">
							<div class="error">
								<c:forEach items="${status.errorMessages }" var="error">
									<c:out value="${error }" />
								</c:forEach>
							</div>
						</c:if>
					</spring:bind> --%>
					<div class="form-group">
						<label for="InputName">Name</label>
						<div class="input-group">
							<form:input path="name" cssClass="form-control" id="name" placeholder="Enter category name" />
							 <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
							<%-- <input type="text" class="form-control" name="name" id="name"
								value="${form.name}" placeholder="Enter Username" required
								autofocus /> <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span> --%>
						</div>
					</div>
					<c:if test="${form.id != 0 }">
						<form:hidden path="id"  />
						<form:hidden path="tempName"/>
						<%-- <input type="hidden" name="id" value="${form.id}"/>
						<input type="hidden" name="tempName" value="${form.tempName}"/> --%>
					</c:if>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="btn-close-categoryForm">Close</button>
					<input type="button" name="submit" id="submit" value="Submit"
						class="btn btn-info pull-right" onclick="submitCategory();">
				</div>
			</div>
		</div>
	</div>
<!-- </form> -->
</form:form>