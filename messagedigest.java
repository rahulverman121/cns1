import java.math.BigInteger;
import java.security.MessageDigest;
public class messagedigest {
	public static void main(String args[])throws Exception
	{
	MessageDigest md=MessageDigest.getInstance("MD5");
	System.out.println("message digest info");
	System.out.println("algorithm is"+md.getAlgorithm());
	System.out.println("provider is"+md.getProvider());
	System.out.println("to string"+md.toString());
	String input="";
	md.update(input.getBytes());
	byte []output=md.digest();
	System.out.println("Md5"+"("+input+")="+bytestohex(output));
	input="abc";
	md.update(input.getBytes());
	output=md.digest();
	System.out.println("Md5"+"("+input+")="+bytestohex(output));
	input="abcdefghijklmnopqrstuvwxyz";
	md.update(input.getBytes());
	output=md.digest();
	System.out.println("Md5"+"("+input+")="+bytestohex(output));
	}
	public static String bytestohex(byte []output)
	{
	BigInteger no=new BigInteger(1,output);
	String hashtext=no.toString(16);
	return hashtext;
	}
}
