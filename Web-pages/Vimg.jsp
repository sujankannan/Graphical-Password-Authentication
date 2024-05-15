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
            <form class="pwd"  method="post" action="Vimg">
                <input type="password" placeholder="Genrated Password" name="password" required>
                <input type="password" placeholder="Password" name="password1" required>
                
                <input type="password" placeholder="Password" name="password2" required>
                <input type="text" placeholder="pede" name="user" value="<%=request.getAttribute("data")%>">
                <button>Submit</button>
            </form>
        </div>
           <div class="img-container">
  <div class="grid">
  
    
    <figure class="grid__figure" id="figure-one">
      <img src="images/0.jpg" alt="" class="grid__image" onclick= "document.forms[0].elements['password'].value = 'boat'">
     
    </figure>
    
    <figure class="grid__figure" id="figure-two">
      <img src="images/1.jpg" alt="" class="grid__image" onclick= "document.forms[0].elements['password'].value = 'paper'">
     
    </figure>
    
    <figure class="grid__figure" id="figure-three">
      <img src="images/2.jpg" class="grid__image" onclick= "document.forms[0].elements['password'].value = 'books'">
     
    </figure>
    
    <figure class="grid__figure" id="figure-four">
      <img src="images/3.jpg" alt="" class="grid__image" onclick= "document.forms[0].elements['password1'].value = 'fish'">
     
    </figure>
    
    <figure class="grid__figure" id="figure-five">
      <img src="images/4.jpg" alt="" class="grid__image"  onclick= "document.forms[0].elements['password1'].value = 'pet'" >
     
    </figure>
    
    <figure class="grid__figure" id="figure-six">
      <img src="images/5.jpg" alt="" class="grid__image"  onclick= "document.forms[0].elements['password1'].value = 'water'">
     
    </figure>
       <figure class="grid__figure" id="figure-six">
      <img src="images/6.jpg" alt="" class="grid__image"  onclick= "document.forms[0].elements['password2'].value = 'train'">
     
    </figure>
       <figure class="grid__figure" id="figure-six">
      <img src="images/7.jpg" alt="" class="grid__image"  onclick= "document.forms[0].elements['password2'].value = 'jeep'">
     
    </figure>
       <figure class="grid__figure" id="figure-six">
      <img src="images/8.jpg" alt="" class="grid__image"  onclick= "document.forms[0].elements['password2'].value = 'car'">
     
  
    
   
  
</div>
       </div>
      
      
      



<script type="text/javascript">
  $(document).ready(function(){
  $("#img-txt").click(function(){
    $("input").append(" <b>Appended text</b>.");
  });
  
});
}
</script>
    </body>
</html>
