 


import java.io.IOException;
import java.io.PrintWriter;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class VGpin extends HttpServlet {
    
      public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "gpa";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "";

		   String user="";
		   String pass="";
                   String us="";
                   String pw="";
                   String role="";
                   String p1="";
                   String p2="";
                   String p3="";
                  
		   
		   String strQuery= ""; 
                   String str= ""; 
			Statement st=null;
			ResultSet rs=null;
			HttpSession session = request.getSession(true);

			try {
				Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
				
					user = request.getParameter("pin").toString();
					pass = request.getParameter("pin1").toString();
                                        p1 = request.getParameter("pin2").toString();
                                        p2 = request.getParameter("user").toString();
                                       
                                  String ipsd= user+pass+p1;    
					 
              strQuery="select * from register where email='"+p2+"'";
					 System.out.println(strQuery);
					
					 st = conn.createStatement();
					rs = st.executeQuery(strQuery);
					while(rs.next())
                                        {
                                      us=rs.getString("email");
					 pw=rs.getString("gpin");
                                         System.out.println("u2");
                                       // System.out.println(p2);
                                        }
                                      // request.setAttribute("uname",us);
					  
                                        if(ipsd.equals(pw) ){
                                            request.setAttribute("data",us);
                                            RequestDispatcher rd=request.getRequestDispatcher("/Vimg.jsp");
                                            rd.forward(request, response);
                                            //System.out.println("ret-forward");		 
                                        }else {
                                             out.println("<script>alert('Invalid PIN'); "
                                                    + "window.location.href='Home.jsp';</script>");
                                        }
				
				System.out.println("Connected to the database");
				

				
//				conn.close();
			System.out.println("Disconnected from database");
				
			} catch (Exception e) {
			e.printStackTrace();
			}
                                        }
                        }
    
      

