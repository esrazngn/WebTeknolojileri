package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class adminCheck
 */
@WebServlet("/adminCheck")
public class adminCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        System.out.println("Checking admin login");
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "yemeksepetim";
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUser = "root";
        String dbPass = "test";
        String username = "";
        String userpass = "";
        String strQuery = "";
        Statement st = null;
        ResultSet rs = null;
        HttpSession session = req.getSession(true);
        try {
            Class.forName(dbDriver).newInstance();
            conn = (Connection) DriverManager.getConnection(url + dbName, dbUser, dbPass);
            if (req.getParameter("usrnm") != null && req.getParameter("username") != ""
                    && req.getParameter("pwd") != null && req.getParameter("password") != "") {
                username = req.getParameter("usrnm").toString();
                userpass = req.getParameter("pwd").toString();
                strQuery = "select * from tb_kullanicilar where userid='" + username + "' and  sifre='" + userpass + "'";
                System.out.println(strQuery);
                st = (Statement) conn.createStatement();
                rs = (ResultSet) st.executeQuery(strQuery);
                int count = 0;
                while (rs.next()) {
                    session.setAttribute("username", rs.getString(2));
                    count++;
                }
                if (count > 0) {
                    res.sendRedirect("adminHome.jsp");
                } else {
                    res.sendRedirect("index.jsp");
                }
            } else {
                res.sendRedirect("login.jsp");
            }
            System.out.println("Connected to the database");
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            throw new ServletException("Login failed", e);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
