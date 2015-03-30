/**
 * 
 */
jQuery(function($) {
	
});
/*function addCategory(){
	$('#myModal').modal('show');	
}*/
function editCategory(id) {

	$.get("get/" + id+".html", function(result) {

		$("#categoryDialog").html(result);
		$('#myModal').modal('show');	
	});
}
/*function centerModal() {
    $(this).css('display', 'block');
    var $dialog = $(this).find(".modal-dialog");
    var offset = ($(window).height() - $dialog.height()) / 2;
    // Center modal vertically in window
    $dialog.css("margin-top", offset);
}

$('.modal').on('show.bs.modal', centerModal);
$(window).on("resize", function () {
    $('.modal:visible').each(centerModal);
});*/
