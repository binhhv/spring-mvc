<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp"%>
<form role="form" name="form" action="" method="post" id="blogForm-id">
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
				<div class="error" id ="error-blog"></div>
					<div class="form-group">
						<label for="InputName">Category</label>
						
							<select class="form-control">
								<option value="one">One</option>
								<option value="two">Two</option>
								<option value="three">Three</option>
								<option value="four">Four</option>
								<option value="five">Five</option>
							</select>
						
					</div>
					<div class="form-group">
						<label for="InputName">Title</label>
						<div class="input-group">
							<input type="text" class="form-control" name="title" id="title"
								value="${form.title}" placeholder="Enter Username" required
								autofocus /> <span class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputName">Content</label>
						
							<textarea class="form-control" rows="3"></textarea>
						
					</div>

					<c:if test="${form.id != 0 }">
						<input type="hidden" name="id" value="${form.id}" />
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
</form>