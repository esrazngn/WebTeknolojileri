package com.odev;
import java.util.Properties;  
import java.util.Random;

import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailSSL {  
 public static boolean mailgonder(int n, String TO) {  
  boolean durum = true;
 String to=TO;//change accordingly  
  
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("esra.zengin@bil.omu.edu.tr","şifreniz");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("ceng.esra.55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("YemekSepetim Onay Maili");  
   message.setText("Sipari�inizi tamamlamak i�in a�a��daki kodu do�rulama ekran�na giriniz.."
		   +n
		   
		   );  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
	  durum = false;
	  throw new RuntimeException(e);}  
   return durum;
 }  
 	public static int randomCode(){
 		 Random rand = new Random();
 		  int  n = rand.nextInt();
 		  return n;
 	}
} 
