package com.odev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class uyeGirisEkrani
 */
@WebServlet("/uyeGirisEkrani")
public class uyeGirisEkrani extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uyeGirisEkrani() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setCharacterEncoding("utf-8");
	    
				 String userid = request.getParameter("userid");
			        String password = request.getParameter("password");

			        if(userid.equals("nano") && password.equals("nano"))
			        {
			            request.getSession().setAttribute("userid", userid);
			            response.sendRedirect("erisimEkrani.jsp");        
			        }
			        else
			        {
			            response.getWriter().write("kullanıcı girişi başarısız…");
			        }
	}

}
