package com.binhhv.contants;

import java.util.ArrayList;
import java.util.List;

public class WebContants {

	//session login fail
	public static final String LAST_USERNAME_KEY = "LAST_USERNAME";
	
	//object
	
	public final static String MENU_CATEGORIES = "CATEGORIES";
	//error
	public final static String ACTION_ERRORS = "errors";
	public final static String ERRORS_404 = "404";
	
	public final static String MODEL_APP_CONTEXT = "APP_CONTEXT";
	
	
	//STYLES CSS AND SCRIPTS
	
	public final static List<String> INDEX_CSS = new ArrayList<String>(){/**
		 * 
		 */
		private static final long serialVersionUID = -5361393392669012074L;

	{
		add("resources/common/css/gm-basic.css");
		
	}};
	public final static List<String> INDEX_SCRIPT = new ArrayList<String>(){/**
		 * 
		 */
		private static final long serialVersionUID = -5361393392669012074L;

	{
		add("resources/common/js/gm-bacsic.js");
		add("resources/common/js/gm-common.js");
	}};
	
	public final static List<String> LOGIN_CSS = new ArrayList<String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		
		add("resources/common/css/gm-login.css");
	}};
	
}
