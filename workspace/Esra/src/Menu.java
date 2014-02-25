

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Menu extends JFrame {
	String[] Corba = {"mercimek = 6TL", "domates = 5TL", "ezogelin = 7TL"};
	String[] ana_yemek = {"pilav = 8TL", "bulgur = 7.5TL"};
	String[] tatli = {"revani = 3TL", "sutlac = 3.5 TL", "baklava = 6TL"};
	String[] icecek = {"Kola = 1.5TL","Ayran = 1TL","Fanta = 1.5TL"};
	String[] sorular = {"kanuni kaç yýl saltanat sürmüþtür","havza genelgesi mayýsýn kaçýnda ilan edildi?","bir civciv yumurtadan kaç gün sonra çýkar ?"};
	String[] cevaplar = {"38","28","21"};
	String a = " ", b=" ";
	static double fiyat = 0.0;
	HashSet hs = new HashSet();
	JFrame frame; 
	JComboBox comboBox1;
	JComboBox comboBox2;
	JComboBox comboBox3;
	JComboBox comboBox4;
	JLabel greeting, name, label, label1, label2, label3, label4;
	JButton but1,but2,but3,but4;
	JTextField text1,text2,text3,text4,text5;
	static String isim ;
	int l = sorular.length;
	int le = 0;
	
	public Menu(){
		new JFrame("Menu");
		setLayout(new GridLayout(5,4));
		ActionListener dinleyici = (ActionListener) new Cmb();
		greeting = new JLabel("Hoþ Geldiniz");
		add(greeting);
		label = new JLabel("OZDÝL Restorant Masa 3");
		add(label);
		name = new JLabel("isminiz  = ");
		add(name);
		text1 = new JTextField(10);
		add(text1);
		isim = (String) (text1).getText();
		label1 = new JLabel("ÇORBALAR =");
		add(label1);
		comboBox1 = new JComboBox(Corba);
		comboBox1.setMaximumRowCount(5);
		add(comboBox1);
		comboBox1.addActionListener(dinleyici);
		label2 = new JLabel("ANA YEMEK = ");
		add(label2);
		comboBox2 = new JComboBox(ana_yemek);
		comboBox2.setMaximumRowCount(5);
		add(comboBox2);
		comboBox2.addActionListener(dinleyici);
		label3 = new JLabel("TATLILAR =");
		add(label3);
		comboBox3 = new JComboBox(tatli);
		comboBox3.setMaximumRowCount(5);
		add(comboBox3);
		label4 = new JLabel("ÝÇECEKLER = ");
		add(label4);
		comboBox4 = new JComboBox(icecek);
		comboBox4.setMaximumRowCount(5);
		add(comboBox4);
		comboBox4.addActionListener(dinleyici);
		comboBox3.addActionListener(dinleyici);
		text2 = new JTextField(30);
		add(text2);
		text3 = new JTextField();
		add(text3);
		text4 = new JTextField("Soruyu bil %10 indirim kazan (soru 0.5kr)");
		add(text4);
		text5 = new JTextField();
		add(text5);
		but3 = new JButton("Sor");
		but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				le = (int)(Math.random()*(l));
					if (sorular[le]==null){
						le = (int)(Math.random()*(l));
					}
					else{
						fiyat += 0.5;
						text3.setText(" "+fiyat);
						text4.setText(sorular[le]);
						sorular[le] = null;
						
					}
				
				
				
			}
			
		});
		
		
		but1 = new JButton("Kaydet");
		 but1.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {	               
	               
	                try {
						FileWriter fw = new FileWriter("D:\\siparis.txt");
						BufferedWriter bw = new BufferedWriter(fw);
						String isim = text1.getText();
						if(isim.equals(null)){
							JOptionPane.showMessageDialog(null, "isminizi giriniz","uyarý",JOptionPane.WARNING_MESSAGE);
						}
						else{
							if(hs.isEmpty()){
								JOptionPane.showMessageDialog(null, "menünüzü seçmediniz","uyarý",JOptionPane.WARNING_MESSAGE);
							}
							else{
								JOptionPane.showMessageDialog(null, hs,"menünüz",JOptionPane.INFORMATION_MESSAGE);
								bw.write(isim+" ");
								Iterator it=hs.iterator();

						        while(it.hasNext())
						        {
						            String value =(String)it.next();

						           bw.write(" "+value);
						          
						        }
						        bw.write(" fiyat = "+fiyat);
						        bw.close();
								
							}
							
							
						}
						

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	          
	            
	            
	        });
		 but2 = new JButton("SÝL");
		 but2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 int uz = hs.size();
				 hs.clear();
				 a = "";
				 text2.setText(a);
				 text3.setText(a);
				 text4.setText(a);
				 text5.setText(a);
				 but3.setEnabled(true);
				 fiyat = 0.0;
				 
			 }
		 });
		 
		 but4 = new JButton("Cevapla");
		 but4.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 String d = text5.getText();
				 if(cevaplar[le].equals(d)){
						but3.setEnabled(false);
						text4.setText("Tebrikler %10 indirim kazandýnýz");
						double indirim = fiyat*10/100;
						fiyat = fiyat-indirim;
						text3.setText(" "+fiyat);
						
					}
					else{
						JOptionPane.showMessageDialog(null,"cevabýnýz yanlýþ tekrar oynamak için 'Sor' a basabilirsiniz","bilgilendirme",JOptionPane.INFORMATION_MESSAGE);
						text4.setText("Soruyu bil %10 indirim kazan (soru 0.5kr)");
						text5.setText("Cevabýn Buraya");
					}
			 }});
		 
	add(but1);
	add(but2);
	add(but3);
	add(but4);
	}
	private class Cmb implements ActionListener  {
	public void actionPerformed(ActionEvent e) {     
		String k = (String) ((JComboBox) e.getSource()).getSelectedItem();
		hs.add(((JComboBox)e.getSource()).getSelectedItem());
		a += ((JComboBox) e.getSource()).getSelectedItem() + ",";
		text2.setText(a);
		if (k == "mercimek = 6TL")
			fiyat += 6.0;
		if (k == "domates = 5TL")
			fiyat += 5.0;
		if (k == "ezogelin = 7TL")
			fiyat += 7.0;
		if (k == "pilav = 8TL")
			fiyat += 8.0;
		if (k == "revani = 3TL")
			fiyat += 3.0;
		if (k == "sutlac = 3.5 TL")
			fiyat += 3.5;
		if (k == "bulgur = 7.5TL")
			fiyat += 7.5;
		if (k == "baklava = 6TL")
			fiyat += 6;
		if (k == "Kola = 1.5TL")
			fiyat += 1.5;
		if (k == "Ayran = 1TL")
			fiyat += 1.0;
		if (k == "Fanta = 1.5TL")
			fiyat += 1.5;
		text3.setText(" "+fiyat);
		
	}
	}




public static void main (String args[]){
	Menu m = new Menu();
	m.setVisible(true);
	m.pack();
	m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
	}
