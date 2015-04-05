package com.binhhv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.binhhv.model.Blog;

@Component
public class BlogCreateFormValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Blog.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmpty(errors, "title", "Title is not empty.");
		 ValidationUtils.rejectIfEmpty(errors, "content", "Content is not empty.");
	}

	

}
