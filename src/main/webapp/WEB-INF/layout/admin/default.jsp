<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/layout/includes.jsp" %>

<html>
  <head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="title" /></title>
    <%@ include file="styles.jsp" %>
  </head>
  <body class="skin-blue">
    <div class="wrapper">
      
      <header class="main-header">
        <tiles:insertAttribute name="nav" />
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
       <tiles:insertAttribute name="menu" />
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
         <tiles:insertAttribute name="content-header" />
        </section>

        <!-- Main content -->
        <section class="content">
          <tiles:insertAttribute name="content" />
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>
    </div><!-- ./wrapper -->

    <tiles:insertAttribute name="footer" />
  </body>
</html>