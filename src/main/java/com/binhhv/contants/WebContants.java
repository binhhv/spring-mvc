package com.binhhv.contants;

import java.util.ArrayList;
import java.util.List;

public class WebContants {

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
	
}
