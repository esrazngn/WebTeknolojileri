import java.math.BigInteger;


public class asd {
	public static void main(String args[])
	{
		BigInteger x ,y , z;
		x = new BigInteger("3");
		y = new BigInteger("10");
		 z = asd.pow(x, y);
		 System.out.println(z);
		
	}
	public static BigInteger pow(BigInteger x, BigInteger y) {  
		  if (y.compareTo(BigInteger.ZERO) < 0)  
		    throw new IllegalArgumentException();  
		  BigInteger z = x; // z will successively become x^2, x^4, x^8, x^16, x^32...  
		  BigInteger result = BigInteger.ONE;  
		  byte[] bytes = y.toByteArray();  
		  for (int i = bytes.length - 1; i >= 0; i--) {  
		    byte bits = bytes[i];  
		    for (int j = 0; j < 8; j++) {  
		      if ((bits & 1) != 0)  
		        result = result.multiply(z);  
		      // short cut out if there are no more bits to handle:  
		      if ((bits >>= 1) == 0 && i == 0)  
		        return result;  
		      z = z.multiply(z);  
		    }  
		  }  
		  return result;  
		} 
}
