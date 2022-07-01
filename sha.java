import java.security.MessageDigest;
import java.math.BigInteger;
public class sha {
	public static void main(String args[]) throws Exception
	{
	
	MessageDigest md=MessageDigest.getInstance("SHA-1");
	System.out.println("message digest object Info");
	System.out.println("Algorithm="+md.getAlgorithm());
	System.out.println("provider="+md.getProvider());
	System.out.println("Tostring="+md.toString());
	String input="";
	md.update(input.getBytes());
	byte[] output=md.digest();
	System.out.println("SHA-1"+"("+input+")="+Bytestohex(output));
	input="abc";
	md.update(input.getBytes());
	output=md.digest();
	System.out.println("SHA-1"+"("+input+")="+Bytestohex(output));
	input="abcdefghijklmnopqrstuvwxyz";
	md.update(input.getBytes());
	output=md.digest();
	System.out.println("SHA-1"+"("+input+")="+Bytestohex(output));
	}
	public static String Bytestohex(byte[]output)
	{
		BigInteger num=new BigInteger(1,output);
		String hashtext=num.toString(16);
		return hashtext;
	}
	
}
