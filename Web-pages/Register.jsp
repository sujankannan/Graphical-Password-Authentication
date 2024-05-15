<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	
<link rel="stylesheet" type="text/css" href="css/sty.css">
</head>
<body>
      <header>
      <!-- <a href="index.html" class="logo"><img src="logo.jpg"></a>-->
      <div class="menu">
        <div class="btn">
          <i class="fas fa-times close-btn"></i>
        </div>
        <a href="Home.jsp">Home</a>
       
      </div>
      <div class="btn">
        <i class="fas fa-bars menu-btn"></i>
      </div>
    </header>
  <div class="loginbox">
  <!--	<a href="index.html"><img src="logo.jpg" class="logo"></a>-->
  	<h1>Register</h1>
  	  <form  method="post" action="FP">
  		<p></p>
                <input type="text" name="fname" placeholder="Enter FirstName" required>
  		<p></p>
                <input type="text" name="lname" placeholder="Enter Lastname" required>
                <p></p>
                <input type="text" name="email" placeholder="Enter Email" required>
  		<p></p>
                <input type="text" name="phone" placeholder="Enter PhoneNumber" required="">
                <p></p>
                <input type="password" name="pwd" placeholder="Enter Password" required>
  		<p></p>
  		<input type="file" name="imgpwd"  required>
  		<input type="submit" name="pwd" value="Register">
                 
		  <a href="Home.jsp">Already have an account?</a>
		  
  	</form>
</body>
</html>