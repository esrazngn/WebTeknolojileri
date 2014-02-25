package com.odev;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


import java.util.*;


@WebServlet("/uyeBilgileri")
public class uyeBilgileri extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean wrong=true;
	 boolean parolaEslesme = false;
	  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = "Hesap Bilgileriniz", parola = null;
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TH> <TH>Bilgileriniz");
    Enumeration<String> paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String[] paramValues =
    	        request.getParameterValues(paramName);
      if ((paramName.equals("password") || paramName.equals("password2")) & parola == null){
    	  parola = paramValues[0];
      }
      else if ((paramName.equals("password") || paramName.equals("password2")) & !(parola == null)) {
    	  if(paramValues[0].equals(parola))
    		  parolaEslesme = true;
      }
      else{
      out.print("<TR><TD BORDER=1>" + paramName + "\n<TD>");
      
      if (paramName.equals("email")){
    	  control td = new control();
    	  boolean durum = td.epostaControl(request.getParameter(paramName));
    	  System.out.println(durum);
    	    if(durum ==false ){
    	    	wrong=false;
    	    }else{
    	    	wrong=true;
    	    }
      }
     
      if (paramValues.length == 1) {
        String paramValue = paramValues[0];
        if (paramValue.length() == 0)
          out.println("<I>No Value</I>");
        else
          out.println(paramValue);
      } 
      
    		  else {
        out.println("<UL>");
        for(int i=0; i<paramValues.length; i++) {
          out.println("<LI>" + paramValues[i]);
        }
        out.println("</UL>");
      }
    }}
    
    out.println("</TABLE>\n</BODY></HTML>");
    if(wrong==false || parolaEslesme==false){
    out.println("Email adresinde hata var.  " );
    out.println("Parolalar eşleşmiyor. " );
    out.println("Lütfen bilgilerinizi doğru giriniz. " );
    out.println("Geri dönmek için <a href = 'http://localhost:8080/yemekSepetim/uyeKayit.jsp'> tıklayınız</a>" );
    }
    else{
        out.println("Giriş ekranına gitmek  için <a href = 'http://localhost:8080/yemekSepetim/uyeGiris.jsp'> tıklaynız</a>" );

    }
    
	out.println("</BODY></HTML>");
  }

  @Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
 
  }

