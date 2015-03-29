/**
 * 
 */
jQuery(function($) {
	
	var ctx = getContextPath();
	$(".fa-user").html('<img src="'+ctx+'/resources/common/images/users.png" style="width:30px;height: 30px">').css("margin-left","0px");
	addCSSRule(".fa-user::before", 'content:""');
	
	$(".fa-sign-out").html('<img src="'+ctx+'/resources/common/images/logout.png" style="width:30px;height: 30px">').css("margin-left","0px");
	addCSSRule(".fa-sign-out::before", 'content:""');
	
	

		
		var check = $("#myModal").data("success");
		if(check == 2){
			$('#myModal').modal('show');	
		}

	
});
function centerModal() {
    $(this).css('display', 'block');
    var $dialog = $(this).find(".modal-dialog");
    var offset = ($(window).height() - $dialog.height()) / 2;
    // Center modal vertically in window
    $dialog.css("margin-top", offset);
}

$('.modal').on('show.bs.modal', centerModal);
$(window).on("resize", function () {
    $('.modal:visible').each(centerModal);
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
