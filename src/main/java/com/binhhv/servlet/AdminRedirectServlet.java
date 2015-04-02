package com.binhhv.servlet;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Redirect /admin to /admin/index.wp
 * 
 * @author Thanh.Nguyen
 */
public class AdminRedirectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String redirectUri = request.getContextPath() + "/" + "admin" + "/"
               ;
        response.sendRedirect(redirectUri);
    }
}
