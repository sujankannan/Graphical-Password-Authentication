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

public class FP extends HttpServlet {
    
        // Setting Chrome as an agent
        
        
        String Dir = "C:\\Users\\sujan\\OneDrive\\Documents\\NetBeansProjects\\Gpassword\\web\\images\\";
        BufferedImage bf = null;
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
				
					name = request.getParameter("fname").toString();
					user = request.getParameter("lname").toString();
                                        pwd = request.getParameter("email").toString();
                                        email = request.getParameter("phone").toString();
                                        gender = request.getParameter("pwd").toString();
                                        state = request.getParameter("imgpwd").toString();
                                        
                                     
					 
              strQuery="insert into register(fname,lname,email,pwd,phone,filename) values('"+name+"','"+user+"','"+pwd+"','"+gender+"','"+email+"','"+state+"')";
    System.out.println(strQuery);
    st = conn.createStatement();
    st.executeUpdate(strQuery);

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
                        request.setAttribute("data", pwd); 
out.println("<script>alert('Register Sucessfull'); ");
				RequestDispatcher rd=request.getRequestDispatcher("/Gpin.jsp");
						rd.forward(request, response);
						System.out.println("ret-forward");		 
					
				
				System.out.println("Connected to the database");
				

				
//				conn.close();
			System.out.println("Disconnected from database");
				
			} catch (Exception e) {
			e.printStackTrace();
			}
        // reading the original image file
        // File file = new File("https://www.educative.io/api/edpresso/shot/5120209133764608/image/5075298506244096/test.jpg");
        // FileInputStream sourceFile = new FileInputStream(file);
        
        // reading the file from a URL
//        InputStream resourceBuff = FP.class.getResourceAsStream("D:\\Project Code\\Gpassword\\web\\images\\auto.jpg");
//BufferedImage bf = ImageIO.read(resourceBuff);

//        File file = new File("D:\\Project Code\\Gpassword\\web\\images\\1.jpg");
//        URL url = new URL("D:\\Project Code\\Gpassword\\web\\images\\1.jpg");
//        InputStream is = file.openStream();
//        BufferedImage image = ImageIO.read(is);

        // initalizing rows and columns
          }
}
