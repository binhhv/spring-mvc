<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- END FOOTER -->
<c:forEach items="${scripts }" var="script">
	<script src="<c:out value="${APP_CONTEXT }/${script }" />"></script>
</c:forEach>