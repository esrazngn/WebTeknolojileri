package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


import java.util.*;


@WebServlet("/show")
public class Show extends HttpServlet {
	boolean wrong=true;
	  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = "Hesap Bilgileriniz";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");
    Enumeration<String> paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      out.print("<TR><TD>" + paramName + "\n<TD>");
      String[] paramValues =
        request.getParameterValues(paramName);
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
    }
    
    out.println("</TABLE>\n</BODY></HTML>");
    if(wrong==false){
    out.println("email adresinde hata var");
	out.println("<a href='http://localhost:8080/Odev/index.html'>Tekara denemek icin tiklayiniz. </a>");
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

