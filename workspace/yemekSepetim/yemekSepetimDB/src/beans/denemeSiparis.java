package beans;

public class denemeSiparis {
	public static siparisBean siparisim = null;
	@SuppressWarnings("static-access")
	public void setSiparis(siparisBean s ){
		this.siparisim = s;
	}
	public siparisBean getSiparis(){
		return siparisim;
	}

}
