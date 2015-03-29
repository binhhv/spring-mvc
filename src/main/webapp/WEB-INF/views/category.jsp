<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${success == 0 }">
<spring:bind path="form">
	<c:if test="${status.error }">
		<div class="error">
			<c:forEach items="${status.errorMessages }" var="error">
				<c:out value="${error }" />
			</c:forEach>
		</div>
	</c:if>
</spring:bind>

<div class="row">
<form role="form" name="form" action="" method="post">
            <div class="col-lg-6 col-lg-offset-3">
                
                <div class="form-group">
                    <label for="InputName">Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="name" id="name" value="${form.name}"  placeholder="Enter Username" required autofocus />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form>
        
        </div>
        </c:when>
        <c:when test="${success ==1 }">
        <div class="msg">
        	Category have created.
        	
        </div>
        </c:when>
 </c:choose>