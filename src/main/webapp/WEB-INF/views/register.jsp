<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
    <div class="col-lg-6 col-lg-offset-3"><h1>Registration user </h1></div>
</div>
<c:forEach items="${listUsers }" var ="user">
	<c:out value="${user }" /> <br>
</c:forEach>
<c:choose>
<c:when test="${success == 0 }">
<div class="row">
<div class="col-lg-6 col-lg-offset-3">
<div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
 <spring:bind path="form">
         <c:if test="${status.error}">
          <div class="error">
                <c:forEach items="${status.errorMessages}" var="error">
                   <c:out value="${error}"/><br>
                </c:forEach>
          </div>
          </c:if>
    </spring:bind>
</div>
</div>
<div class="row">
<form role="form" name="form" action="" method="post">
            <div class="col-lg-6 col-lg-offset-3">
                
                <div class="form-group">
                    <label for="InputName">Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" id="username" value="${form.username}"  placeholder="Enter Username" required autofocus />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" type="email" name="email" id="email" value="${form.email}"  placeholder="Enter Email" required autofocus />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" name="password" id="password"  placeholder="Enter Password" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Confirm Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" name="passwordRepeated" id="passwordRepeated" placeholder="Enter Confirm Password" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form>
        
        </div>
        </c:when>
        <c:when test="${success == 1 }">
        	<div class="msg">
        	Register success. Please check your email and get password to login website.
        	</div>
        </c:when>
        <c:when test="${success == 2 }">
        	<div class="msg">
        	Your acount have registered. <a href='<spring:url value="/" />'>Click</a> go to home page.
        	</div>
        </c:when>
        <c:when test="${success == 3 }">
        	<div class="error">
        	We could not activate your account because this web address is not valid. Make sure that you have the entire address from the email, and that your email client has not split the address over several lines.

			Please try again with the full address from the email that you received. If it still does not work, try filling in the activation form:
		
			If you do not know your activation code, you can find it in the email that was sent to you when you first registered. To have it sent again, please click here:
			<a href="#">Send new email with activation code.</a>
			If all else fails, <a href="#">email the administrator</a>, making sure that you include your registered email address and username.

        	</div>
        </c:when>
   </c:choose>     