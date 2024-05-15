<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	
<link rel="stylesheet" type="text/css" href="css/st.css">
</head>
<body>
      <header>
    <!--   <a href="index.html" class="logo"><img src="logo.jpg"></a>-->
      <div class="menu">
        <div class="btn">
          <i class="fas fa-times close-btn"></i>
        </div>
        <a href="Home.jsp">Home</a>
        <a href="Register.jsp">Register</a>
        
        
      </div>
      <div class="btn">
        <i class="fas fa-bars menu-btn"></i>
      </div>
    </header>
  <div class="loginbox">
  <!--	<a href="index.html"><img src="logo.jpg" class="logo"></a>-->
  	<h1>Login</h1>
  	  <form  method="post" action="Login">
  		<p></p>
                <input type="text" name="email" placeholder="Enter Username" required>
  		<p></p>
  		<input type="Password" name="pwd" placeholder="Enter Password" required>
                <input type="file" name="imgpwd"  required>
  		<input type="submit" name="pwd" value="login">
                 
		  <a href="Register.jsp">Don't have an account?</a>
		  
  	</form>
</body>
</html>