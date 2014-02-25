package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class echoServlet
 */
//@WebServlet("/siparisVer")

public class EchoServlet extends HttpServlet {
 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
  // Set the response message's MIME type
  response.setCharacterEncoding("utf-8");
  request.setCharacterEncoding("utf-8");
  // Allocate a output writer to write the response message into the network socket
  PrintWriter out = response.getWriter();

  // Write the response message, in an HTML page
  try {
     out.println("<!DOCTYPE html>");
     out.println("<html><head>");
     out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
     out.println("<title>Echo Servlet</title></head>");
     out.println("<body><h2>Siparisiniz</h2>");

     
     String yemek = request.getParameter("yemekler");
     // Get null if the parameter is missing from query string.
     // Get empty string or string of white spaces if user did not fill in
     if (yemek == null
           || (yemek = htmlFilter(yemek.trim())).length() == 0) {
        out.println("<p>Yemek: MISSING</p>");
     } else {
        out.println("<p>Yemek: " + yemek.replace("&nbsp", " ") + "</p>");
     }
     String yemekAdet = request.getParameter("yemekAdet");
     if (yemekAdet == null
           || (yemekAdet = htmlFilter(yemekAdet.trim())).length() == 0) {
        out.println("<p>Salata: MISSING</p>");
     } else {
        out.println("<p>YemekAdet: " + yemekAdet + "</p>");
     }
     // Retrieve the value of the query parameter "password" (from password field)
     
     String icecek = request.getParameter("icecekler");
     if (icecek == null
             || (icecek = htmlFilter(icecek.trim())).length() == 0) {
          out.println("<p>Salata: MISSING</p>");
       } else {
          out.println("<p>icecek: " + icecek + "</p>");
       }

     String icecekAdet = request.getParameter("icecekAdet");
     if (icecekAdet == null
             || (icecekAdet = htmlFilter(icecekAdet.trim())).length() == 0) {
          out.println("<p>ÝcecekAdt: MISSING</p>");
       } else {
          out.println("<p>icecekadet: " + icecekAdet + "</p>");
       }

     
     
     String salata = request.getParameter("salatalar");
     if (salata == null
           || (salata = htmlFilter(salata.trim())).length() == 0) {
        out.println("<p>Salata: MISSING</p>");
     } else {
        out.println("<p>Salata: " + salata + "</p>");
     }
     
     String salataAdet = request.getParameter("salataAdet");
     if (salataAdet == null
             || (salataAdet = htmlFilter(salataAdet.trim())).length() == 0) {
          out.println("<p>Salata: MISSING</p>");
       } else {
          out.println("<p>SalataAdet: " + salataAdet + "</p>");
       }


     // Retrieve the value of the query parameter "gender" (from radio button)
     System.err.printf(salata.replace("&nbsp", " "));
     out.println("</body></html>");
  } finally {
     out.close();  // Always close the output writer
  }
}

// Redirect POST request to GET request.
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
  doGet(request, response);
}

// Filter the string for special HTML characters to prevent
// command injection attack
private static String htmlFilter(String message) {
  if (message == null) return null;
  int len = message.length();
  StringBuffer result = new StringBuffer(len + 20);
  char aChar;

  for (int i = 0; i < len; ++i) {
     aChar = message.charAt(i);
     switch (aChar) {
         case '<': result.append("&lt;"); break;
         case '>': result.append("&gt;"); break;
        
         case '"': result.append("&quot;"); break;
         
         default: result.append(aChar);
     }
  }
  return (result.toString());
}
}