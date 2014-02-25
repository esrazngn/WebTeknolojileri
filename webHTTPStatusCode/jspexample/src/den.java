import java.math.BigInteger;


public class den {
	private static BigInteger modulo(BigInteger a, BigInteger b, BigInteger c) { 

	    BigInteger x = BigInteger.ONE;
	    final BigInteger TWO = new BigInteger("2", 16);

	    while(b.compareTo(BigInteger.ZERO) > 0) {

	        BigInteger compareVal = b.mod(TWO);
	        if(compareVal.compareTo(BigInteger.ONE) ==0) { 
	            x = (x.multiply(a)).mod(c);
	        }

	        a = (a.multiply(a)).mod(c);
	        b = b.divide(TWO);
	    }
	    return x.mod(c);

	}
	public static void main(String args[]){
		den d = new den();
	    final BigInteger a = new BigInteger("2", 16);
	    final BigInteger b = new BigInteger("3", 36);
	    final BigInteger c = new BigInteger("4", 8);

		System.out.println(d.modulo(a, b, c));
	}
}
