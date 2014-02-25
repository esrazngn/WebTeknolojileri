package pageNumber;


import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet({ "/index", "/index/*" })
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-9");
		response.setCharacterEncoding("ISO-8859-9");
		String path = request.getPathInfo();
		if(path==null || path.trim().length()==0){
			request.getRequestDispatcher("/index.jsp").include(request, response);
			return;
		}
		path=path.substring(1);
		if(path.equals("kayitol")){ 
			request.getRequestDispatcher("/kayit.jsp").include(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cnn;
		PreparedStatement st;
		ResultSet rs;
		try{
			
		}catch (Exception e) {
			response.getWriter().print(e.getMessage());
}
		String path = request.getPathInfo();
		if(path==null || path.trim().length()==0){
			response.sendRedirect("index");
			return;
		}
		path=path.substring(1);
		if(path.equals("giris")){ 
			
		


	}

}
