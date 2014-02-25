package LoginPages;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class Register extends JFrame {
	public static JButton button;
	public static JLabel label1, label2, label3;
	public static  JTextField text;
	public static JPasswordField pass1, pass2;
	public static void main(String args[]){
		Register reg = new Register();
		reg.setLayout(new GridLayout(4,2));
		reg.setSize(500,500);
		reg.setBounds(100, 100, 300, 250);
		reg.setVisible(true);
		
		reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label1 = new JLabel("User:");
        reg.add(label1);
        text = new JTextField();
        reg.add(text);
        label2 = new JLabel("Password:");
        reg.add(label2);
        pass1 = new JPasswordField();
        reg.add(pass1);
        label3 = new JLabel("Confirm Password : ");
        reg.add(label3);
        pass2 = new JPasswordField();
        reg.add(pass2);
        button = new JButton("Register");
        reg.add(button);	
		reg.pack();
	
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				String user = text.getText();
				String passw1 = pass1.getText();
				String passw2 = pass2.getText();
				if(passw1.equals(passw2)){
					try {
						DataBaseConnection data = new DataBaseConnection();
						data.connect();
						data.veriKayit(user, passw1);
					    JOptionPane.showMessageDialog(null, "Register Baþarýlý");
					    System.exit(1);

					} catch (ClassNotFoundException e1) {
						
					    JOptionPane.showMessageDialog(null, "Sistemde oluþan bag nedeniyle þuan hizmet veremiyoruz..");

						e1.printStackTrace();
					}
				}
				else{
		            JOptionPane.showMessageDialog(null, "Hatalý Password ");
				}
				
			}
		}
	});
	
	}
	
}

