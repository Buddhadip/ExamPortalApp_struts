/**
 * 
 */

 function deleteQuestion(id){
	 data= {
		  "qid":id,
	  }
  $.ajax({
      url: "deleteQuestion.do",
      type: "POST",
      data:data,
      success: function(response) {
        window.location.reload()
      },
      error: function(xhr, status, error) {
        // Handle the error
        alert("Error updating students to exam");
      }
    });
 }