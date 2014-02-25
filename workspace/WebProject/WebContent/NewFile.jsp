&lt;% String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost/esra";
Connection con = null; %&gt;


&lt;%try {
Class.forName(driver);
out.println("JDBC surucu basari ile yüklendi.");
} catch (Exception e) {
out.println("JDBC surucu Yüklenemedi.");
System.exit(0);
}%&gt;[/sourcecode]
 
[sourcecode language="csharp"]&lt;%try {
con = DriverManager.getConnection(url, "root", "esra");
out.println("Veritabanına bağlanıldı.");
} catch (Exception e) {
System.out.println("Bağlantı Kurulamadı"");
System.exit(0);
}%&gt;