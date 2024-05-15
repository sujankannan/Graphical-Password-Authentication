 


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
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
 * @author ANAND
 */
public class Login extends HttpServlet {
    
    
    String Dir = "C:\\Users\\sujan\\OneDrive\\Documents\\NetBeansProjects\\Gpassword\\web\\images\\";
        BufferedImage bf = null;
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
                   String state="";
                   String imgpwd="";
                  
		   
		   String strQuery= ""; 
                   String str= ""; 
			Statement st=null;
			ResultSet rs=null;
			HttpSession session = request.getSession(true);

			try {
				Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
				
					user = request.getParameter("email").toString();
					pass = request.getParameter("pwd").toString();
                                        state = request.getParameter("imgpwd").toString();
                                       
                                      
					 
              strQuery="select * from register where email='"+user+"'";
					 System.out.println(strQuery);
					
					 st = conn.createStatement();
					rs = st.executeQuery(strQuery);
					while(rs.next())
                                        {
                                      us=rs.getString("email");
					 pw=rs.getString("pwd");
                                         imgpwd=rs.getString("filename");
                                         System.out.println("u2");
                                       // System.out.println(p2);
                                        }
                                      // request.setAttribute("uname",us);
                                      System.out.println("image file name from  "+state);
					  System.out.println("image file name  "+imgpwd);
                                       
				System.out.println("Connected to the database");
				
                                if(user.equals(us) && pass.equals(pw)){
                                    
                                    if(state.equals(imgpwd)){
                                        System.out.println("checking image");
                                             bf = ImageIO.read(new File(Dir+state));
  int rows = 3;
        int columns = 3;

        // initializing array to hold subimages
        BufferedImage imgs[] = new BufferedImage[9];

        // Equally dividing original image into subimages
        int subimage_Width = bf.getWidth() / columns;
        int subimage_Height = bf.getHeight() / rows;
        
        int current_img = 0;
        
        // iterating over rows and columns for each sub-image
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                // Creating sub image
                imgs[current_img] = new BufferedImage(subimage_Width, subimage_Height, bf.getType());
                Graphics2D img_creator = imgs[current_img].createGraphics();

                // coordinates of source image
                int src_first_x = subimage_Width * j;
                int src_first_y = subimage_Height * i;

                // coordinates of sub-image
                int dst_corner_x = subimage_Width * j + subimage_Width;
                int dst_corner_y = subimage_Height * i + subimage_Height;
                
                img_creator.drawImage(bf, 0, 0, subimage_Width, subimage_Height, src_first_x, src_first_y, dst_corner_x, dst_corner_y, null);
                current_img++;
            }
        }

        //writing sub-images into image files
        for (int i = 0; i < 9; i++)
        {
            File outputFile = new File(Dir + i + ".jpg");
            ImageIO.write(imgs[i], "jpg", outputFile);
            
        }
        System.out.println("Sub-images have been created.");
             request.setAttribute("data",us);
                                            RequestDispatcher rd=request.getRequestDispatcher("/VGpin.jsp");
                                            rd.forward(request, response);
                                    }else{
                                         out.println("<script>alert('Invalid Image File'); "
                                                    + "window.location.href='Home.jsp';</script>");
                                    }
                                }else{
                                     out.println("<script>alert('Invalid Username And Password'); "
                                                    + "window.location.href='Home.jsp';</script>");
                                }
				
//				conn.close();
			System.out.println("Disconnected from database");
				
			} catch (Exception e) {
			e.printStackTrace();
			}
                                        }
                        }
    
      

