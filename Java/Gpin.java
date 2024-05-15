import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Gpin extends HttpServlet {
    
        // Setting Chrome as an agent
        
        
          public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
              System.setProperty("http.agent", "Chrome");
              response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "gpa";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "";

		   String name="";
		   String user="";
                   String pwd="";
                   String email="";
                   String gender="";
                   String state="";
                   String country="";
                    String role="";
                    
		   
		   String strQuery= ""; 
                   String str= ""; 
			Statement st=null;
			ResultSet rs=null;
			HttpSession session = request.getSession(true);

			try {
				Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
				
					name = request.getParameter("pin").toString();
					user = request.getParameter("pin1").toString();
                                        pwd = request.getParameter("pin2").toString();
                                          email = request.getParameter("user").toString();
                                      
                                     String ipsd = name+user+pwd;   
                                     
					 
              strQuery="UPDATE register SET gpin='"+ipsd+"' WHERE email='"+email+"';";
    System.out.println(strQuery);
    st = conn.createStatement();
    st.executeUpdate(strQuery);

                         request.setAttribute("data", email); 

				RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
						rd.forward(request, response);
						System.out.println("ret-forward");		 
					
				
				System.out.println("Connected to the database");
				

				
//				conn.close();
			System.out.println("Disconnected from database");
				
			} catch (Exception e) {
			e.printStackTrace();
			}
          }
}
