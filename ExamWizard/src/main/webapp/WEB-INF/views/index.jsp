<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ExamWizard</title>
    <link rel="stylesheet" href="public/styles/index.css" />
    <!-- Unicons -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />
    
</head>
<body>

	 <!-- Header -->
    <header class="header">
      <nav class="nav">
        <a href="#" class="nav_logo">Exam Portal</a>

        <ul class="nav_items">
          <li class="nav_item">
            <a href="#" class="nav_link">Home</a>
            <a href="#" class="nav_link">Product</a>
            <a href="#" class="nav_link">Services</a>
            <a href="#" class="nav_link">Contact</a>
          </li>
        </ul>

        <button class="button" id="form-open">Login</button>
      </nav>
    </header>

    <!-- Home -->
    <section class="home">
      <div class="form_container">
        <i class="uil uil-times form_close"></i>
        <!-- Login From -->
        <div class="form login_form">
          <form id ="loginForm" action="login.do" method="post">
            <h2>Login</h2>

            <div class="input_box">
              <input type="email" id="email" name="email" placeholder="Enter your email" required />
              <i class="uil uil-envelope-alt email"></i>
            </div>
            <div class="input_box">
              <input type="password" id="uroll" name="uroll" placeholder="Enter your password" required />
              <i class="uil uil-lock password"></i>
              <i class="uil uil-eye-slash pw_hide"></i>
            </div>

		 <!-- <div class="option_field">
              <span class="checkbox">
                <input type="checkbox" id="check" />
                <label for="check">Remember me</label>
              </span>
              <a href="#" class="forgot_pw">Forgot password?</a>
            </div>
          -->   

            <button class="button" type="submit" >Login Now</button>

            <div class="login_signup">Don't have an account? <a href="#" id="signup">Signup</a></div>
          </form>
        </div>

        <!-- Signup From -->
        <div class="form signup_form">
          <form id="signupForm" action="signup.do" method="post">
            <h2>Signup</h2>

			<div class="input_box">
              <input type="text"  id="uname" name="uname" placeholder="Enter your name" required />
              <i class="uil uil-envelope-alt name"></i>
            </div>
            <div class="input_box">
              <input type="email"  id="email" name="email" placeholder="Enter your email" required />
              <i class="uil uil-envelope-alt email"></i>
            </div>
            <div class="input_box">
              <input type="text" id="uroll" name="uroll" placeholder="Enter RollNo." required />
              <i class="uil uil-user uroll_icon"></i>
            </div>
            <div class="input_box">
              <input type="date" id="dob" name="dob" placeholder="Enter your date of birth" required />
            <i class="uil uil-calendar-alt date"></i>
            </div>

            <button class="button">Signup Now</button>

            <div class="login_signup">Already have an account? <a href="#" id="login">Login</a></div>
          </form>
        </div>
      </div>
    </section>

    <script src="public\js\index.js"></script>
</body>
</html>