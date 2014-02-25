package LoginPages;
import java.sql.*;

import javax.swing.JOptionPane;
public class DataBaseConnection {
	public static String password;
    public static Connection con;
    public static ResultSet rs = null;
    public static Statement st;
    public static DataBaseConnection bag;
    static void main(String args[]) throws ClassNotFoundException, SQLException{
    bag = new DataBaseConnection();
     	   	
    	   }
	public static String veriBul(String user) throws ClassNotFoundException, SQLException{
		
		rs = con.createStatement().executeQuery("SELECT * FROM TEST1 WHERE USER='"+user+"'");
       while(rs.next()) {
           password = rs.getString("password");
       }
      return password;
      
	}
	
   	

     public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            

        } catch (ClassNotFoundException e) {
        
        e.printStackTrace();
        }
 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","esra");
            

        } catch (SQLException e) {
          
            e.printStackTrace();
        }
 
        return con;
    }

     public static void veriKayit (String user, String password) throws ClassNotFoundException{
 		try {
 		    String sorgu = "INSERT INTO test1 (user, password)";
 		    st = con.createStatement();
 		    st.executeUpdate(sorgu+"values('"+user+"','"+password+"')");

 	} catch (SQLException e) {
 	    e.printStackTrace();
 	}
 	}
 	
}
    

