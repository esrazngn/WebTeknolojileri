package com.odev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class uyeGirisEkrani
 */
@WebServlet("/uyeGirisEkrani")
public class uyeGirisEkrani extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean giris;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uyeGirisEkrani() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("userid");
		String password = request.getParameter("password");
		String chk = request.getParameter("hatirla");
		if (chk.equals("checked")) {
			Cookie c1 = new LongLivedCookie("firstName", username);
			response.addCookie(c1);
		}
		int yetki;
		dosyadanOku doku = new dosyadanOku();
		giris = doku.kullaniciAdiOku(username, password);
		yetki = doku.getYetki();
		if (giris) {
			if (yetki == 1) {
				request.getSession().setAttribute("userid", username);
				response.sendRedirect("erisimEkrani");
			} else {
				request.getSession().setAttribute("userid", username);
				response.sendRedirect("anasayfaGiris.jsp");
			}
		} else {

			response.sendRedirect("uyeGirisBasarisiz");
		}
	}

}
