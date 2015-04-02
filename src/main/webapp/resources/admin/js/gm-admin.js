

	(function worker() {
		  $.ajax({
		    url: getContextPath()+'/admin/getParameter.html', 
		    type: "GET",  
		    dataType: 'json',
		    success: function(data) {
		     // alert(data);
		    	$("#numbers-user").text(data.numUser);
		    	$("#numbers-blog").text(data.numBlog);
		    	$("#numbers-category").text(data.numCategory);
		    },
		    complete: function() {
		      // Schedule the next request when the current one's complete
		      setTimeout(worker, 5000000);
		    }
		  });
		})();

	
	

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