<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
 <link rel="stylesheet" href="public/styles/addStudent.css" />
  <link rel="stylesheet" href="public/styles/adminHome.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    />
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   // Retrieve a session attribute
   String username = (String) session.getAttribute("username");
%>
	 <nav class="sidebar">
      <a href="#" class="logo">
        <i class="fa-solid fa-gauge fa-spin"></i>
        Dashboard
      </a>

      <div class="menu-content">
        <ul class="menu-items">
          <li class="item">
            <a href="profile.do">
              <i class="fa-solid fa-address-card"></i>
              Profile</a
            >
          </li>

          <li class="item selected-item">
            <a href="studentPage.do">
              <i class="fa-solid fa-users"></i>
              Student Informations</a
            >
          </li>

          <li class="item">
            <a href="addExamPage.do">
              <i class="fa-solid fa-book-open"></i>
              Examination</a
            >
          </li>
          <li class="item">
            <a href="notificationPage.do">
              <i class="fa-solid fa-bell"></i>
              Notification</a>
          </li>

          <li class="item">
            <a href="logout.do">
              <i class="fa-solid fa-right-from-bracket"></i>
              Logout</a
            >
          </li>
        </ul>
      </div>
    </nav>

    <nav class="navbar">
      <i class="fa-solid fa-bars" id="sidebar-close"></i>
      <div class="hellotext">Hello <%= username %></div>
    </nav>

    <main class="main">
      <div class="uploader">
        <div class="box">
          <form action="addUser.do" method="post" onsubmit="manageFormSubmit()">
            <div class="form-group">
              <label for="name">Name:</label>
              <input type="text" id="name" name="name" required />
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <input type="email" id="email" name="email" required />
            </div>
            <div class="form-group">
              <label for="roll">Roll Number:</label>
              <input type="text" id="roll" name="roll" required />
            </div>
            <div class="submit-button">
              <input type="submit" value="Submit" />
            </div>
          </form>
        </div>
        <div class="or-class">OR</div>
        <div class="box2">
          <form
            action="uploadCSV.do"
            method="post"
            enctype="multipart/form-data"
          >
            <input type="file" name="file" accept=".csv" />
            <input type="submit" value="Upload csv" class="upload-button" />
          </form>
        </div>
      </div>

      <div class="student_details">
        <table>
          <thead>
            <tr>
              <th>Student Name</th>
              <th>Roll Number</th>
              <th>Email ID</th>
              <th>Role</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="student" items="${studentlist}">
           	<tr>
              <td>${student.uname}</td>
              <td>${student.uroll}</td>
              <td>${student.email}</td>
              <td>${student.urole}</td>
              <td>
              <c:if test='${student.urole.equals("Admin") }'>
				    <button class="delete-button2" >Delete</button>
			</c:if>
		    	<c:if test='${student.urole.equals("Student") }'>
				     <button class="delete-button" onclick="deleteStudentById('${student.uid}')">Delete</button>
			  </c:if>   
              </td>
            </tr>
            </c:forEach>
            <!-- Add more rows here -->
          </tbody>
        </table>
      </div>
    </main>
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="public/js/addStudent.js"></script>
</body>
</html>