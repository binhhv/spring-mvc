<%@ include file="/WEB-INF/layout/includes.jsp" %>
<!-- FOOTER -->
<section class="footer-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">&copy; Binhhv</div>

		</div>
	</div>
</section>
<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
<!-- CORE JQUERY  -->
<script src="${APP_CONTEXT }/resources/common/js/jquery-1.11.1.js"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="${APP_CONTEXT }/resources/common/bootstrap/js/bootstrap.js"></script>
<!-- CUSTOM SCRIPTS  -->
<script src="${APP_CONTEXT }/resources/common/js/custom.js"></script>
<script src="${APP_CONTEXT }/resources/common/js/gm-bacic.js"></script>
<script src="${APP_CONTEXT }/resources/common/js/gm-common.js"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"  type="text/javascript"></script>
<script src="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.js"  type="text/javascript"></script>


<!-- END FOOTER -->
<c:forEach items="${scripts }" var="script">
	<script src="<c:out value="${APP_CONTEXT }/${script }" />"></script>
</c:forEach>