package com.binhhv.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.binhhv.contants.WebContants;
import com.binhhv.service.UserService;
import com.binhhv.validator.UserCreateForm;
import com.binhhv.validator.UserCreateFormValidator;







@Controller
public class UserController extends AbstractController{
	private static final List<String> INDEX_CSS = WebContants.INDEX_CSS;
	private static final List<String> INDEX_SCRIPT = WebContants.INDEX_SCRIPT;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
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
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        ModelAndView mv =  new ModelAndView("register", "form", new UserCreateForm());
        mv.addObject("styles", INDEX_CSS);
        mv.addObject("scripts", INDEX_SCRIPT);
        mv.addObject("success",0);
        return mv;
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        ModelAndView mv = new ModelAndView("register");
        
    	mv.addObject("styles", INDEX_CSS);
    	mv.addObject("scripts", INDEX_SCRIPT);
        if (bindingResult.hasErrors()) {
            // failed validation
        	mv.addObject("success",0);
            //return "register";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            mv.addObject("success",0);
        }
        // ok, redirect
        mv.addObject("success",1);
        return mv;
    }
}
