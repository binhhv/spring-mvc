<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:forEach items="${CATEGORIES }" var="category">
<c:out value="${category.username }" />
</c:forEach>

<div class="row pad-botm">
	<div class="col-md-12">
		<h4 class="header-line">DASHBOARD</h4>

	</div>

</div>
<div class="row " style="padding-bottom: 40px;">
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-bus fa-5x "></i>
			<h5>30 Stocks Pending</h5>
		</div>
	</div>
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-paint-brush fa-5x "></i>
			<h5>5 New Designs</h5>
		</div>
	</div>
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-paypal fa-5x "></i>
			<h5>2 New Invoice</h5>
		</div>
	</div>
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-birthday-cake fa-5x "></i>
			<h5>1 Person's Birthday</h5>
		</div>
	</div>
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-bolt fa-5x "></i>
			<h5>20 New Tasks</h5>
		</div>
	</div>
	<div class="col-md-2 col-sm-2 col-xs-6">
		<div class="text-center">
			<i class="fa fa-comments fa-5x "></i>
			<h5>120 Messages</h5>
		</div>
	</div>
</div>
<hr />
<br />
<br />
<div class="row text-center ">
	<div class="col-md-4 col-sm-4 col-xs-6">
		<div class="alert alert-info text-center">
			<h4>IMPORTANT NOTICE</h4>
			<hr />
			<i class="fa fa-warning fa-4x"></i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.</p>
			<hr />
			<a href="#" class="btn btn-info">Read Full Detalis</a>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-6">
		<div class="alert alert-danger text-center">
			<h4>IMPORTANT NOTICE</h4>
			<hr />
			<i class="fa fa-warning fa-4x"></i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.</p>
			<hr />
			<a href="#" class="btn btn-danger">Read Full Detalis</a>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-6">
		<div class="alert alert-success text-center">
			<h4>IMPORTANT NOTICE</h4>
			<hr />
			<i class="fa fa-warning fa-4x"></i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit gthn.</p>
			<hr>
			<a href="#" class="btn btn-success">Read Full Detalis</a>
		</div>
	</div>
</div>
<hr />
<br />
<br />