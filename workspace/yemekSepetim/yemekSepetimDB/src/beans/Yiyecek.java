package beans;

public class Yiyecek {
	private String key;
	private double value;
	private int id, adet;

public void Yiyecek(){
	
}
	public void setKey(String key)
	{
		this.key = key;

	}

	public String getKey() 
	{
		return key;
	}

	public void setValue(Double value)
	{
		this.value = value;

	}

	public Double getValue() 
	{
		return value;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	
	public int getAdet()
	{
		return adet;
	}
	
	public void setAdet(int adet)
	{
		this.adet = adet;
	}
}
