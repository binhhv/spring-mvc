package com.binhhv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.binhhv.service.UserService;

@Component
public class AdminUserCreateFormValidator implements Validator{

	private UserService userService;
	public AdminUserCreateFormValidator(UserService userService){
		this.userService = userService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(AdminUserCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
	

}
