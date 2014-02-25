package WebProject;
import java.io.IOException;
	import java.io.PrintWriter;
	
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	

	public class XMLCreation extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	
	
	 public XMLCreation() {
	 super();
	
 }

	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 response.setContentType("text/xml");
	 PrintWriter yaz = response.getWriter();
	
	 yaz.write("<?xml version=\"1.0\"?>");
	 yaz.write("<Makaleler>");
	 yaz.write("<Makale>");
	 yaz.write("<Baslik>JDBC Statement Nesneleri</Baslik>");
	 yaz.write("<Yazar>M.Serhan URAS </Yazar>");
	 yaz.write("</Makale>");
	 yaz.write("<Makale>");
	 yaz.write("<Baslik>XML Nedir. Nerelerde Kullanilir</Baslik>");
	 yaz.write("<Yazar>Koray PISKINER </Yazar>");
	 yaz.write("</Makale>");
	 yaz.write("<Makale>");
	 yaz.write("<Baslik>IFrame icindeki elemanlara erisim </Baslik>");
	 yaz.write("<Yazar>Mehmet TASKOPRU </Yazar>");
	 yaz.write("</Makale>");
	 yaz.write("</Makaleler>");
	 }
	
	}

 

 

 