<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="public/styles/studentHome.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Student Home</title>
</head>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   // Retrieve a session attribute
   String username = (String) session.getAttribute("uname");
%> 
<nav class="sidebar">
      <a href="#" class="logo">
        <i class="fa-solid fa-chalkboard-user fa-beat"></i>
        Dashboard
      </a>

      <div class="menu-content">
        <ul class="menu-items">
          <li class="item">
          <li class="item  selected-item">
            <a href="profile.do">
              <i class="fa-solid fa-address-card"></i>
              Profile</a>
          </li>

          <li class="item">
            <a href="studentExams.do">
                <i class="fa-solid fa-list"></i>
              Exams</a>
          </li>

          <li class="item">
            <a href="result.do">
            <i class="fa-solid fa-square-poll-vertical"></i>
              Result</a>
          </li>

          <li class="item">
            <a href="logout.do">
              <i class="fa-solid fa-right-from-bracket"></i>
              Logout</a>
          </li>
        </ul>
      </div>
    </nav>

    <nav class="navbar">
      <i class="fa-solid fa-bars" id="sidebar-close"></i>

      <div class="hellotext">Hello <%= username %></div>
    </nav>

    <main class="main">
      <h1>Student Profile</h1>
    </main>

    <script src="public/js/studentHome.js"></script>
    
</body>
</html>