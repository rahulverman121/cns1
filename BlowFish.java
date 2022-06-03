
import javax.crypto.*;
import java.util.*;
public class BlowFish 
{
	public static void main(String args[])throws Exception
	{
		KeyGenerator keyGenerator=KeyGenerator.getInstance("BLOWFISH");
		SecretKey secretKey=keyGenerator.generateKey();
		Cipher cipher=Cipher.getInstance("BLOWFISH");
		cipher.init(Cipher.ENCRYPT_MODE,secretKey);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the words want you to be encrypt:");
		String inputText=sc.nextLine();
		byte[]encrypt=cipher.doFinal(inputText.getBytes());
		cipher.init(Cipher.DECRYPT_MODE,secretKey);
		byte[]decrypt=cipher.doFinal(encrypt);
		System.out.println("Words after encryption:"+new String(encrypt));
		System.out.println("Words ater decryption:"+new String(decrypt));
	}
}
