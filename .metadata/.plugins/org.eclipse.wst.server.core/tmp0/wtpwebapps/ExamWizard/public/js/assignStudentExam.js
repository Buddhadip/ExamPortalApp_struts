function submitAllStudentName() {
  var checkboxes = document.getElementsByName("studentname");
  var eid=document.getElementById("eid").value;
  var selectedStudents = [];

  for (var i = 0; i < checkboxes.length; i++) {
    if (checkboxes[i].checked) {
      selectedStudents.push(checkboxes[i].value);
    }
  }

  console.log(selectedStudents);
  
  data= {
		  "eid":eid,
	     "studentData":selectedStudents
	  }
  $.ajax({
      url: "assignStudent.do",
      type: "POST",
      data:JSON.stringify(data),
      success: function(response) {
        window.location.replace("addExamPage.do");
      },
      error: function(xhr, status, error) {
        // Handle the error
        alert("Error updating students to exam");
      }
    });
}
