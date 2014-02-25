package com.servlet;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Browser
 */
@WebServlet("/Browser")
public class Browser extends HttpServlet {
	
	@Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String message = null;
    String  browserDetails  =   request.getHeader("User-Agent");
    String  userAgent       =   browserDetails;
    String  user            =   userAgent.toLowerCase();
    String os ;
    
    //=================OS=======================
     if (userAgent.toLowerCase().indexOf("windows") >= 0 )
     {
         os = "Windows";
     }
     else if(userAgent.toLowerCase().indexOf("mac") >= 0)
     {
         os = "Mac";
     }
     else if(userAgent.toLowerCase().indexOf("x11") >= 0)
     {
         os = "Unix";
     }else if(userAgent.toLowerCase().indexOf("android") >= 0)
     {
         os = "Android";
     }
     else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
     {
         os = "IPhone";
     }else{
         os = "UnKnown, More-Info: "+userAgent;
     }
     //===============Browser===========================
    if (user.contains("msie"))
    {
        String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
        message=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
    }
    else if (user.contains("safari") && user.contains("version"))
    {
        message=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
    }
    else if ( user.contains("opr") || user.contains("opera"))
    {
        if(user.contains("opera"))
            message=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        else if(user.contains("opr"))
            message=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
    }
    else if (user.contains("chrome"))
    {
        message=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
    }
    else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
    {
        //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
       message = "Netscape-?";

    }
    else if (user.contains("firefox"))
    {
        message=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
    }
    else
    {
        message = "UnKnown, More-Info: "+userAgent;
    }
    
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD></HEAD>" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" +
                message + "\n" + os+
                "</BODY></HTML>");
  }

  }

