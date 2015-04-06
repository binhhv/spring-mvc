/**
 * 
 */
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
	 $("#table-blog").dataTable();
	 //$('#error-blog').css("display","none");
	 //addCSSRule("#error-category", 'display: :"none;"');
	 //$("#error-category").hide();
      });
function deleteBlog(id){
	//alert($("#category-delete-id-"+id).data("url"));
	 $("#modalRemoveBlog").modal('show');
	 $("#modalRemoveBlog a.removeBtn").on("click", function(e) {
		 //alert($("#category-delete-id-"+id).data("url"));
		 $("#modalRemoveBlog a.removeBtn").attr("href",$("#blog-delete-id-"+id).data("url"));
         //alert($("#modalRemoveCategory a.removeBtn").attr("href"));
		 //$("#modalRemoveCategory").modal('hide');     // dismiss the dialog
     });
}
function addBlog(){
	//$('#myModal').modal('show');	
	resetDialog($("#blogForm-id"));
}

function submitBlog(){
	 var form = $('#blogForm-id').serialize();
	
	  $.ajax({  
	    type: "POST",  
	    url: getContextPath() + "/admin/blog.html",  
	    data: form, 
	    dataType: 'json',
	    success: function(response){
	    	if(response.status == "SUCCESS"){
	    		
	    		window.location.href = getContextPath()+"/admin/blog.html";
	    		
	    	}
	    	else{
	    		//alert(response.result);
	    		//alert("myObject is " + JSON.stringify(response.result[0]));
	    		var errorInfo="";
	    		for(i =0 ; i < response.result.length ; i++){
		    		  errorInfo +=  (i + 1) +". " + response.result[i].code +"<br>" ;
		    	  }
	    		//alert(errorInfo);
	    		$("#error-blog").show();
	    		$("#error-blog").html(errorInfo);
	    	}
	    		
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  }); 
}
function editBlog(id) {

	$.get(getContextPath() +"/admin/blog/get/" + id+".html", function(result) {

		$("#blogDialog").html(result);
		$('#error-blog').css("display","none");
		/*$('.modal').on('show.bs.modal', centerModal);*/
		$("#blogModal").modal('show');	
	});
}

function resetDialog(form) {

	$('#error-blog').css("display","none");
	form.find("input[type=text]").val("");
	form.find("textarea").val("");
}

