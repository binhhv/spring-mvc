/**
 * 
 */
jQuery(function($) {
	//setPostionModal();
	
	
});
function deleteCategory(id){
	//alert($("#category-delete-id-"+id).data("url"));
	 $("#modalRemoveCategory").modal('show');
	 $("#modalRemoveCategory a.removeBtn").on("click", function(e) {
		 //alert($("#category-delete-id-"+id).data("url"));
		 $("#modalRemoveCategory a.removeBtn").attr("href",$("#category-delete-id-"+id).data("url"));
         //alert($("#modalRemoveCategory a.removeBtn").attr("href"));
		 //$("#modalRemoveCategory").modal('hide');     // dismiss the dialog
     });
}
function addCategory(){
	//$('#myModal').modal('show');	
	resetDialog($("#categoryForm-id"));
}

function editCategory(id) {

	$.get("get/" + id+".html", function(result) {

		$("#categoryDialog").html(result);
		$('.modal').on('show.bs.modal', centerModal);
		$('#myModal').modal('show');	
	});
}
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
function resetDialog(form) {

	form.find("input[type=text]").val("");
}

