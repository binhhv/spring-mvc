package com.binhhv.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class RedirectPage extends SimpleUrlAuthenticationFailureHandler{
	public void redirectToPage( HttpServletRequest request, HttpServletResponse response, String url) throws IOException{
		getRedirectStrategy().sendRedirect(request, response, url);
	}
}
