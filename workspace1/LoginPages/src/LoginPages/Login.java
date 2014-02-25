package LoginPages;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Login extends JFrame {
	public static JButton button1 , button2;

	public JTextField text1;
	public JPasswordField pass;
		 
		public static void main(String[] args) {
		final Login logi = new Login();
		
		logi.setLayout(new GridLayout(3,2));
		logi.setSize(500,500);
		logi.setBounds(100, 100, 300, 250);
		logi.setVisible(true);
		
		logi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("User:");
        logi.add(label1);
        final JTextField text1 = new JTextField();
        logi.add(text1);
        JLabel label2 = new JLabel("Password:");
        logi.add(label2);
        final JPasswordField pass = new JPasswordField();
        logi.add(pass);
        button1 = new JButton("Login");	
        logi.add(button1);
        
        button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button1) {
					String user = text1.getText();
					String passw = pass.getText();
					String passwo = null;
					try {
						passwo = veriBul(user);
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(passw.equals(passwo)){
					    JOptionPane.showMessageDialog(null, "Baþarýlý Login");
					    }
					else{
			            JOptionPane.showMessageDialog(null, "Hatalý User/Password ");
					}
				}
			}
		});
        final JButton button2 = new JButton("Register");
        logi.add(button2);
        button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button2) {
				
				Register reg = new Register();
				reg.main(null);
				logi.setVisible(false);
				
				}
				
				}
				
		});
        logi.pack();
		}
		public static String password;
		public static String veriBul(String user) throws ClassNotFoundException, SQLException{
			  Connection con;
			  ResultSet rs = null;
			  
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","esra");
            rs = con.createStatement().executeQuery("SELECT * FROM TEST1 WHERE USER='"+user+"'");
 	       while(rs.next()) {
 	           password = rs.getString("password");
 	       }
 	       
 	       
 	      return password;
		}
		
        	
}