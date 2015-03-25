/**
 * 
 */
jQuery(function($) {
	
	var ctx = getContextPath();
	$(".fa-user").html('<img src="'+ctx+'/resources/common/images/users.png" style="width:30px;height: 30px">').css("margin-left","0px");
	addCSSRule(".fa-user::before", 'content:""');
	
	$(".fa-sign-out").html('<img src="'+ctx+'/resources/common/images/logout.png" style="width:30px;height: 30px">').css("margin-left","0px");
	addCSSRule(".fa-sign-out::before", 'content:""');
	
	
});
function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}

function addCSSRule(selector, css) {  
 var sheets = document.styleSheets;
 var last = (sheets.length-1);
 
 if(sheets[last].insertRule) { 
	 sheets[last].insertRule(selector + '{' +  css + '}', sheets[last].cssRules); 
 }else if(sheets[last].addRule) { 
	 sheets[last].addRule(selector, css, -1); 
 } 
} 
