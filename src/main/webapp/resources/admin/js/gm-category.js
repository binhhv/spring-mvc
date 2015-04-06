/**
 * 
 */
/*jQuery(function($) {
	//setPostionModal();
	//$("#error-category").hide();
	$('#table-category').dataTable();
	
});*/
 $(function () {
	 //$("#error-category").hide();  
	 $("#table-category").dataTable();
	 //addCSSRule("#error-category", 'display: :"none;"');
	 //$("#error-category").hide();
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

function submitCategory(){
	 var form = $('#categoryForm-id').serialize();
	
	  $.ajax({  
	    type: "POST",  
	    url: contextPath + "/admin/category.html",  
	    data: form, 
	    dataType: 'json',
	    success: function(response){
	    	if(response.status == "SUCCESS"){
	    		window.location.href = contextPath +"/admin/category.html";
	    	}
	    	else{
	    		
	    		//alert("myObject is " + JSON.stringify(response.result[0]));
	    		var errorInfo="";
	    		for(i =0 ; i < response.result.length ; i++){
		    		  errorInfo +=  (i + 1) +". " + response.result[i].code +"\n" ;
		    	  }
	    		//alert(errorInfo);
	    		$("#error-category").show();
	    		$("#error-category").text(errorInfo);
	    	}
	    		
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  }); 
}
function editCategory(id) {

	$.get(contextPath +"/admin/category/get/" + id+".html", function(result) {

		$("#categoryDialog").html(result);
		/*$('.modal').on('show.bs.modal', centerModal);*/
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
function resetDialog(form) {

	$('#error-category').css("display","none");
	form.find("input[type=text]").val("");
}

