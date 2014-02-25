import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;


public class HesapMain extends JFrame {
	private double sayi1;
	private double sayi2;
	private double sonuc=0;
	private JButton Topla;
	private JButton Cikar;
	private JButton Carp;
	private JButton Bol;
	private JButton Us;
	private JButton Sil;
	private JTextField kutu1;
	private JTextField kutu2, kutu3;
	private JLabel etiket;
	
public HesapMain(){
	setLayout(new GridLayout(5,2));
	Topla = new JButton("+");
	Cikar = new JButton("-");
	Carp = new JButton("*");
	Bol = new JButton("/");
	Us = new JButton("^");
	Sil = new JButton("CE");
	kutu1 = new JTextField (10);
	kutu2 = new JTextField (10);
	kutu3 = new JTextField (10);
	etiket = new JLabel (" = ");
	add(kutu1);
	add(kutu2);
	add(Topla);
	add(Cikar);
	add(Carp);
	add ( Bol );
	add(Us);
	add(Sil);
	add(etiket);
	add (kutu3);
	
	
	ButtonListener dinleyici = new ButtonListener();
	Topla.addActionListener(dinleyici);
	Cikar.addActionListener(dinleyici);
	Carp.addActionListener(dinleyici);
	Bol.addActionListener(dinleyici);
	Us.addActionListener(dinleyici);
	Sil.addActionListener(dinleyici);
}
public class ButtonListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		sayi1 = Double.parseDouble(kutu1.getText());
		sayi2 = Double.parseDouble(kutu1.getText());
		if (e.getSource()== Topla)
			sonuc = sayi1+ sayi2;
		if (e.getSource()== Cikar)
			sonuc = sayi1- sayi2;
		if (e.getSource()== Carp)
			sonuc = sayi1 * sayi2;
		if (e.getSource()== Bol)
			sonuc = sayi1/ sayi2;
		if (e.getSource()== Us)
			sonuc =Math.pow(sayi1, sayi2);
		if (e.getSource()== Sil){
			kutu1.setText("silindi");
			kutu2.setText("silindi");
			
		}
		kutu3.setText(""+sonuc);
		
	}
	
	
	
	
	
	
	
	
}
	
	


	public static void main(String[] args) {
		HesapMain h = new HesapMain ();
		h.setSize(400, 300);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h.setVisible(true);
	
	}

}
