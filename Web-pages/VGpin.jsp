<%-- 
    Document   : Login
    Created on : Apr 11, 2024, 11:21:43 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" />
        
        <style>
           .img-container{
  display: flex;
  justify-content: center;
  padding-bottom: 40px;
  padding-left:30%;
  flex-direction: column;
    flex-wrap: wrap;
    align-item: center;
}
.grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: .5rem;
  width: calc(100% - 4rem);
  max-width: 480px;
  z-index: 1;
}
.grid__figure {
  position: relative;
  width: 100%;
  height: auto;
  margin-left: 0%;
  aspect-ratio: 1;
  border-radius: .25rem;
  filter: brightness(.75) grayscale(.25);
  cursor: pointer;
  overflow: hidden;
}
.grid__image {
  width: 100%;
  height: auto;
  aspect-ratio: 1;
  vertical-align: middle;
  object-fit: cover;
}

.input-cont {
  display: flex;
  justify-content: center;
  padding-top: 40px;
  padding-bottom: 40px;
  flex-direction: column;
    flex-wrap: wrap;
    align-content: center;
}
.input-cont h2{
    font-size:30px;
    color:#FF416C; 
}

input {
  width: 350px;
  border: 2px solid rgb(207, 207, 207);
  border-radius: 6px;
  height: 50px;
  padding-left: 10px;
}

input::placeholder {
  font-size: 16px;
  opacity: 0.4;
}

input:focus {
  outline-color: rgb(124, 176, 236);
}
 button{
                    display: inline-block;
                    outline: none;
                    cursor: pointer;
                    font-size: 14px;
                    line-height: 1;
                    border-radius: 500px;
                    transition-property: background-color,border-color,color,box-shadow,filter;
                    transition-duration: .3s;
                    border: 1px solid transparent;
                    letter-spacing: 2px;
                    min-width: 160px;
                    text-transform: uppercase;
                    white-space: normal;
                    font-weight: 700;
                    text-align: center;
                    padding: 17px 48px;
                    color: #fff;
                    background-color: #1ED760;
                    height: 48px;
                    :hover{
                        transform: scale(1.04);
                        background-color: #21e065;
                    }
                
        </style>
    </head>
    <body>
          <h1> GRAPHICAL PASSWORD AUTHENTICATION 
 
</h1>
    <header>
    <nav>
      <ul>
        <li><a href="Home.jsp">Home</a></li>
        <li><a href="Home.jsp">Login</a></li>
        <li><a href="Register.jsp">Register</a></li>
      </ul>
    </nav> 
    </header>
        <div class="input-cont">
            <h2>ENTER GRAPHICAL PIN</h2>
            <form class="pwd"  method="post" action="VGpin">
                <input type="password" placeholder="pin" name="pin" style="width:50px; height:50px; margin-left: 70px;" required>
                <input type="password" placeholder="pin" name="pin1" style="width:50px; height:50px;" required>
                
                <input type="password" placeholder="pin" name="pin2" style="width:50px; height:50px;" required>
               <input type="hidden" placeholder="pede" name="user" value="<%=request.getAttribute("data")%>"><br><br>
                <button style="margin-left: 80px;">Submit</button>
            </form>
        </div>
          
      
      




    </body>
</html>
