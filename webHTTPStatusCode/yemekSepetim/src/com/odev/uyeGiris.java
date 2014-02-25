package com.odev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/uyeGiris")
public class uyeGiris extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uyeGiris() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

}
	    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");;
	    response.setContentType("text/html");
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    String title = "Üye Giriş Ekranı";
	    out.println(docType +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<body>"+
	                "<fieldset><legend><h1>Üye Girişi </h1> </legend> "+
	                "<form name='giris' action='uyeGirisEkrani'> "+
	                "<table border=0  cellpadding=1 >"+
	                "	<TR><TD colspan=5> userid : <input type='text' name='userid' value = ''> </TD> 	</TR>"+
	                "<TR><TD colspan=5> password : <input type='password'  name='password' value = '' ></TD></TR>"+
	                " </table>"+	
	                "<input type='checkbox' name='hatirla' value='check' checked /><span>Beni Hatırla.<br/><br/></span>"+
	                "<input type='submit'  />"+
	                "</fielset></form>                </body> </html>");
	                
	                
	                
	       
	}

}
