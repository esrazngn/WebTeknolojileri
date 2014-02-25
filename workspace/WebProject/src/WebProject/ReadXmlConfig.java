package WebProject;

import java.io.IOException;

import java.io.PrintWriter;

 

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 
public class ReadXmlConfig extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ReadXmlConfig() {

        super();

        // TODO Auto-generated constructor stub

    }

     

   public String deger;

     

    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        deger = config.getInitParameter("Ad");

 

      }

 

 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter yaz = response.getWriter();

        yaz.write(deger);

    }

 

     

 

}
