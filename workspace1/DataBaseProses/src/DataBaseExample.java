

import java.io.*;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DataBaseExample
 */
@WebServlet("/DataBaseExample")
public class DataBaseExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataBaseExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			doProcess(request, response);
		}
		catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			doProcess (request , response);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("hata4");
		} catch (InstantiationException e) {
			System.out.println("hata1");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("hata2");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("hata3");
			e.printStackTrace();
		}
	}
	private void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
	    Connection con = null;
	    ResultSet rs = null;
	    Statement st = null;
	    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            System.out.println("set connection : URL : jdbc:mysql://localhost:3306/test");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","esra");
            
            System.out.println("Create Statement.");
            st =con.createStatement();
            
            System.out.println("Do database proces");
            rs=st.executeQuery("SELECT * FROM TEST");
            
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>merhabaaa</body></html>");
			/*out.print("<HTML>");
            out.print("<HEAD>");
            out.print("<TITLE>DATABASE CONNECTION</TITLE>");
            out.print("</HEAD>");
            out.print("<BODY>");
            out.print("<H1> NAME FROM DATABASE </H1>");
            out.print("<BR/>");
            
            System.out.println("ger value from tablo test.");
            while (rs.next()){
            	out.print("User: "+rs.getString("user"));
            	out.print("Password: "+rs.getString("password"));
            	out.print("<BR/>");
            }
            out.print("</BODY>");
            out.print("</HTML>");
            out.flush();*/
                        
           } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
        	if(st != null){
        		st.close();
        	}
        	if (con != null){
        		con.close();
        	}
 
        
    }
	}

}
