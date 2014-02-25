

public class VeriTipleri {

	public static void main(String[] args) {
		Deneme d= new Deneme();
		d.x=50;
		System.out.println("Sayýnýn ilk deðeri:"+d.x);
		carp(d);
		System.out.println("Sayýnýn ilk deðeri:"+d.x);
		}
	
	public static void carp(Deneme d){
		d.x=d.x*2;
	}
}
class Deneme{
	public int x;
}
