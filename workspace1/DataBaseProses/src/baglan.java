
import java.sql.*;

import javax.swing.JOptionPane;
public class baglan {
	public String password;
    public Connection con;
    public ResultSet rs = null;
    public Statement st;
   public static void main(String args[]){
    	baglan bag = new baglan();
    	bag.connect();
    	//bag.veriEkleme(00, "denedikkkkkk", 0);
    	//bag.veriBul("esrazngn");
    	//bag.veriGüncelleme(10, "Emineeeemmm");
    	//bag.veriSilme(10000);
    	//
    	bag.veriEkleme("esrammm", 11);
    	/*
    	
    	Personel p = new Personel();
        p.setAd("4");
        p.setSad("hanife");
        p.setTl("50");
     
        bag.setPersonel(p);
        
    */
   }
   public String veriBul (String user) {// id si bu olanýn ismini deðiþtir
		 
		 
	    try {
	    	
	    	
	       st = con.createStatement();
	       rs = st.executeQuery("SELECT * FROM TEST1 WHERE USER='"+user+"'");
	       while(rs.next()) {
	           password = rs.getString("password");
	       }
	       
	     
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return password;
	}
     public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            JOptionPane.showMessageDialog(null, "baþarýlý");

        } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","esra");
            JOptionPane.showMessageDialog(null, "baþarýlý");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return con;
    }

    

public void veriCek() {

    try {
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM test1 ");
 
        while(rs.next()) {
            System.out.println(rs. getString("user")+"-"+rs.getString("password"));
        }
        JOptionPane.showMessageDialog(null, "baþarýlý");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "baþarýsýz");
    }
}

/*
public void setPersonel(Personel personel) {
 
 
    try {
        String sql = "INSERT INTO test (id, ad, yas) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
 
        ps.setString(1, personel.getAd());
        ps.setString(2, personel.getSad());
        ps.setString(3, personel.getTl());
 
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void veriEkle(int id, String ad , int yas) {
	 
	 
    try {
        String sql = "INSERT INTO test (id, ad, yas) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
 
        ps.setLong(1, id);
        ps.setString(2, ad);
        ps.setLong(3, yas);
 
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    */
public void veriEkleme (String user, int password){
	 try {
	    String sorgu = "INSERT INTO test1 (user, password)";
	    st = con.createStatement();
	    st.executeUpdate(sorgu+"values('"+user+"','"+password+"')");

} catch (SQLException e) {
    e.printStackTrace();
}
}
public void veriGüncelleme(int id, String ad ) {// id si bu olanýn ismini deðiþtir
	 
	 
    try {
    	//String sorgu = "INSERT INTO test (id, ad, yas)";
    	
       st = con.createStatement();
       // st.executeUpdate(sorgu+"VALUES(" + id + " , " + " , " + yas + ")"); // ekler
       st.executeUpdate("UPDATE TEST SET AD ="+"'"+ad+"'"+" WHERE ID ='"+id+"'");
       //st.executeUpdate("UPDATE TEST SET YAS ="+"'"+yas+"'"+" WHERE ID ='1'");
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void veriSilme(int id ) {// id si bu olanýn ismini deðiþtir
   	 
   	 
        try {
        	//String sorgu = "INSERT INTO test (id, ad, yas)";
        	
           st = con.createStatement();
           // st.executeUpdate(sorgu+"VALUES(" + id + " , " + " , " + yas + ")"); // ekler
           st.execute("DELETE FROM TEST WHERE ID ='"+id+"'");
           //st.executeUpdate("UPDATE TEST SET YAS ="+"'"+yas+"'"+" WHERE ID ='1'");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
}}