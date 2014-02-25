
 
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Egemen
 */
public class DAO {
    private static Connection con;
    private static String dbURL= "jdbc:mysql://localhost:3306/dbName";
    private static String username = "root";
    private static String password = "root";
     
    public static Statement dbConnect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //My sql JDBC sürücüsü kullanýlýyor
            con = (Connection) DriverManager.getConnection(DAO.dbURL, DAO.username,DAO.password);//baðlantý açýlýyor
            return (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public void dbClose() throws Exception
    {
        con.close();
    }
}