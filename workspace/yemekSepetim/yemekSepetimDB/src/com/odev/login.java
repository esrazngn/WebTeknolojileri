package com.odev;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;

public class login extends HttpServlet{ 
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "user_register";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "root";

		   String username="";
		   String userpass="";
		   String strQuery= ""; 
			Statement st=null;
			ResultSet rs=null;
			HttpSession session = request.getSession(true);

			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
				if(request.getParameter("username")!=null && request.getParameter("username")!="" && request.getParameter("password")!=null && request.getParameter("password")!="")
				{
					username = request.getParameter("username").toString();
					userpass = request.getParameter("password").toString();
                    strQuery="select * from userregister where username='"+username+"' and  password='"+userpass+"'";
					 System.out.println(strQuery);
					st = conn.createStatement();
					rs = st.executeQuery(strQuery);
					int count=0;
					while(rs.next())
					{
					  
						session.setAttribute("username",rs.getString(2));
						count++;
					}

                    if(count>0)
					{
						response.sendRedirect("welcome.jsp");
					}
					else
					{
                       response.sendRedirect("login.jsp");
					}
			
				  
				}
				else
				{
					 response.sendRedirect("login.jsp");
				}

				System.out.println("Connected to the database");
				 
				
				conn.close();
				System.out.println("Disconnected from database");
			} catch (Exception e) {
			e.printStackTrace();
			}
  }
}