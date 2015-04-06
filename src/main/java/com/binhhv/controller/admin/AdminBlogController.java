package com.binhhv.controller.admin;

import java.beans.PropertyEditorSupport;
import java.lang.ProcessBuilder.Redirect;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binhhv.contants.WebContants;
import com.binhhv.contants.WebContantsAdmin;
import com.binhhv.model.Blog;
import com.binhhv.model.Category;
import com.binhhv.model.json.JsonResponse;
import com.binhhv.service.BlogService;
import com.binhhv.service.CategoryService;
import com.binhhv.validator.BlogCreateForm;
import com.binhhv.validator.BlogCreateFormValidator;
import com.binhhv.validator.CategoryCreateForm;

@Controller
@RequestMapping(value={"/admin","/admin/"})
public class AdminBlogController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BlogService blogService;
	private BlogCreateFormValidator blogCreateFormValidator;
	
	
	@Autowired
	public AdminBlogController(BlogService blogService,  BlogCreateFormValidator blogCreateFormValidator){
		this.blogService = blogService;
		this.blogCreateFormValidator = blogCreateFormValidator;
	}
	
	@InitBinder("form")
	/*public void initBinder(WebDataBinder binder){
		binder.addValidators(blogCreateFormValidator);
	} 
	@InitBinder*/
    protected void initBinder(WebDataBinder binder) {
		binder.addValidators(blogCreateFormValidator);
		binder.registerCustomEditor(Category.class, "category", new PropertyEditorSupport() {
		    @Override
		    public void setAsText(String text) {
		        Category category = categoryService.findCategoryById(Integer.parseInt(text));
		        setValue(category);
		    }
		    });
    }
	@RequestMapping(value="/blog",method=RequestMethod.GET)
	public ModelAndView getNameCategoryCreate(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("admin.blog","form",new Blog());
		mv.addObject("blogs", blogService.getAllBlogs());
		mv.addObject("categories", categoryService.getAllCategories());
		mv.addObject("scripts", WebContantsAdmin.BLOG_SCRIPT);
		return mv;
	}
	
	@RequestMapping(value="/blog",method=RequestMethod.POST)
	public @ResponseBody JsonResponse handleCreateCategory( @Valid @ModelAttribute("form")  Blog blog,BindingResult bindingResult){
		JsonResponse res = new JsonResponse();
		if (bindingResult.hasErrors()) {
			res.setStatus("FAIL");
			res.setResult(bindingResult.getAllErrors());
			
			System.out.print("error----" + blog.getCategory());
		}else{
			blogService.addBlog(blog);
			res.setStatus("SUCCESS");
		}
		return res;
	}
	
	@RequestMapping("/blog/get/{blogId}")
	public String getBook(@PathVariable int blogId, Map<String, Object> map) {
		Blog blog = blogService.findBlogById(blogId);
		map.put("form", blog);
		map.put("categories", categoryService.getAllCategories());
		return "admin.blogForm";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/blog/delete/{blogId}")
	public String deleteBlog(@PathVariable("blogId") int blogId){
		blogService.deleteBlog(blogId);
		return "redirect:/admin/blog.html";
	}
}
