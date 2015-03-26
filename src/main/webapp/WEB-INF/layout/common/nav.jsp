<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!-- LOGO NAV BAR -->
<section class="sec-menu" >
        <div class="container">
            <div class="row">
                <div class="col-md-12">
              <span class="menu-open-icon">  <i class="fa fa-bars pull-left fa-2x b-clr"   ></i> </span> 
              <i class="pull-left">
              <span class="profile-name">SPRING</span>
              </i> 
              <i class="pull-right">
              <sec:authorize access="isAnonymous()">
              
               <a href='<spring:url value="/user/register.html" />'
				title="Login" class="profile-name">REGISTER NOW!!!</a>
               
              </sec:authorize>
             <sec:authorize access="isAuthenticated()">
             	<img alt="" src="${APP_CONTEXT }/resources/common/images/otto.png" width="50">&nbsp  <a href='<spring:url value="/user/profile.html" />' class="profile-name"><sec:authentication property="name"/></a>
             </sec:authorize>
               
               </i>   
                </div>
            </div>
        </div>
    </section>
<!-- END LOGO NAV BAR -->