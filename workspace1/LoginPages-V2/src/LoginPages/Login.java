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
						
						DataBaseConnection data = new DataBaseConnection();
						data.connect();
						passwo = data.veriBul(user);
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(passw.equals(passwo)){
					    JOptionPane.showMessageDialog(null, "Baþarýlý Login");
					    System.exit(1);
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
}