<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/includes.jsp" %>
<!-- jQuery 2.1.3 -->
    <%-- <script src="${APP_CONTEXT }/resources/admin/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="${APP_CONTEXT }/resources/admin/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>    
    <!-- Morris.js charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="${APP_CONTEXT }/resources/admin/plugins/morris/morris.min.js" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
    <script src="${APP_CONTEXT }/resources/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/knob/jquery.knob.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='${APP_CONTEXT }/resources/admin/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="${APP_CONTEXT }/resources/admin/dist/js/app.min.js" type="text/javascript"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="${APP_CONTEXT }/resources/admin/dist/js/pages/dashboard.js" type="text/javascript"></script>

    <!-- AdminLTE for demo purposes -->
    <script src="${APP_CONTEXT }/resources/admin/dist/js/demo.js" type="text/javascript"></script>
    <script src="${APP_CONTEXT }/resources/admin/js/gm-admin.js" type="text/javascript"></script>
    <script src="${APP_CONTEXT }/resources/admin/js/gm-category.js" type="text/javascript"></script>
    <script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"  type="text/javascript"></script>
	<script src="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.js"  type="text/javascript"></script>

     --%>
     <!-- jQuery 2.1.3 -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="${APP_CONTEXT }/resources/admin/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- DATA TABES SCRIPT -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
    <script src="${APP_CONTEXT }/resources/admin/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
    <!-- SlimScroll -->
    <script src="${APP_CONTEXT }/resources/admin/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='${APP_CONTEXT }/resources/admin/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="${APP_CONTEXT }/resources/admin/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${APP_CONTEXT }/resources/admin/dist/js/demo.js" type="text/javascript"></script>
        <script src="${APP_CONTEXT }/resources/admin/js/gm-admin.js" type="text/javascript"></script>
    <%-- <script src="${APP_CONTEXT }/resources/admin/js/gm-category.js" type="text/javascript"></script> --%>
    <c:forEach items="${scripts }" var="script">
	<script src="<c:out value="${APP_CONTEXT }/${script }" />"></script>
	</c:forEach>
    <!-- page script -->
    <!-- <script type="text/javascript">
      $(function () {
    	    $("#example1").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script> -->