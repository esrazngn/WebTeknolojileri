package LoginPages;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class LoginV2 extends Frame implements ActionListener{
	public static JButton button1 , button2;
	public JTextField text1;
	public JPasswordField pass
	public LoginV2(){
		setSize(400,400);
		LoginShow();	
	}
	public LoginShow(){
		setLayout(new GridLayout(3, 2));
		setSize(300, 300);
		setVisible(true);
		add(text1);
		
	}
	public static void main(String args[]){
		LoginV2 log = new LoginV2();
	}

}
