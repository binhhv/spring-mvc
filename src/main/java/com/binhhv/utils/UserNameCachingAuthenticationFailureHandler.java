package com.binhhv.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.binhhv.contants.WebContants;

public class UserNameCachingAuthenticationFailureHandler
extends SimpleUrlAuthenticationFailureHandler {



@Autowired
private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

@Override
public void onAuthenticationFailure(
        HttpServletRequest request, HttpServletResponse response, 
        AuthenticationException exception)
        throws IOException, ServletException {

    //super.onAuthenticationFailure(request, response, exception);

    //String usernameParameter =
        //usernamePasswordAuthenticationFilter.getUsernameParameter();
    String lastUserName = request.getParameter("j_username");

    HttpSession session = request.getSession(false);
    if (session != null || isAllowSessionCreation()) {
        request.getSession().setAttribute(WebContants.LAST_USERNAME_KEY, lastUserName);
    }
    getRedirectStrategy().sendRedirect(request, response, "/login.html?error");
}
}