

public class VeriTipleri {

	public static void main(String[] args) {
		Deneme d= new Deneme();
		d.x=50;
		System.out.println("Say�n�n ilk de�eri:"+d.x);
		carp(d);
		System.out.println("Say�n�n ilk de�eri:"+d.x);
		}
	
	public static void carp(Deneme d){
		d.x=d.x*2;
	}
}
class Deneme{
	public int x;
}
