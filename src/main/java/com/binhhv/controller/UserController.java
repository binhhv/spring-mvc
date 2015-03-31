package com.binhhv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.binhhv.contants.WebContants;
import com.binhhv.model.User;
import com.binhhv.service.UserService;
import com.binhhv.serviceImpl.UserDetailsServiceImpl;
import com.binhhv.utils.AuthenticateUser;
import com.binhhv.utils.RedirectPage;
import com.binhhv.validator.UserCreateForm;
import com.binhhv.validator.UserCreateFormValidator;







@Controller
public class UserController {
	private static final List<String> INDEX_CSS = WebContants.INDEX_CSS;
	private static final List<String> INDEX_SCRIPT = WebContants.INDEX_SCRIPT;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private  UserService userService;
	//@Autowired
	private  UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserCreateFormValidator userCreateFormValidator;
    
    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;
    
    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage(@RequestParam(value = "code", required = false) String code,
    		HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.debug("Getting user create form");
        ModelAndView mv =  new ModelAndView("register", "form", new UserCreateForm());
       // mv.addObject("styles", INDEX_CSS);
        //mv.addObject("scripts", INDEX_SCRIPT);
        if(code != null){
        	//mv.addObject("success",2);
        	User user = userService.activeUser(code);
        	if(user != null){
        		 
        		Authentication authentication =  new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        		LOGGER.debug("Logging in with {}", authentication.getPrincipal());
        		SecurityContextHolder.getContext().setAuthentication(authentication);	
        		new RedirectPage().redirectToPage(request, response, "/login.html");
        		//response.sendRedirect("/"+request.getContextPath()+"/login.html");
        		 //mv.addObject("success",3);
        	}
        	else mv.addObject("success",3);
        }
        else mv.addObject("success",0);
        //mv.addObject("listUsers", userService.getAllUsers());
        return mv;
        
    }
    
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult,
    		HttpServletRequest request,HttpServletResponse response) throws IOException {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        ModelAndView mv = new ModelAndView("register");
        
    	//mv.addObject("styles", INDEX_CSS);
    	//mv.addObject("scripts", INDEX_SCRIPT);
        if (bindingResult.hasErrors()) {
            // failed validation
        	mv.addObject("success",0);
            return mv;
        }
        try {
            if(userService.create(form)){
            	User user = userService.getUserByUsername(form.getUsername());
            mv.addObject("success",1);
//            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(form.getUsername());
//
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            	Authentication authentication =  new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            	System.out.print("Logging in with { %}" + authentication.getPrincipal());
            	SecurityContextHolder.getContext().setAuthentication(authentication);	
            	new RedirectPage().redirectToPage(request, response, "/");
            }
            else{
            	mv.addObject("success",0);
            }
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            mv.addObject("success",0);
            return mv;
        }
        // ok, redirect
       
        return mv;
    }
    
    @SuppressWarnings("unused")
	private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
    private void doAutoLogin(String username, String password, HttpServletRequest request) {

    	UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // Create a new session and add the security context.
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

    }
}
