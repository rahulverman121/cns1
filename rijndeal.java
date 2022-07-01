

	import java.io.*;
	import java.util.Scanner;
	import javax.crypto.*;
	import java.security.*;
	import java.math.BigInteger;
	import javax.crypto.Cipher;
	import javax.crypto.KeyGenerator;
	import javax.crypto.SecretKey;
public class rijndeal {

	
		public static void main(String args[]) throws Exception
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter a message");
			String message=sc.nextLine();
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128);
			SecretKey sk=kg.generateKey();
			byte[] raw=sk.getEncoded();
			SecretKeySpace sks=new SecretKeySpace(raw,"AES");
			Cipher c=Cipher.getInstance("AES");
			c.init(Cipher.ENCRYPT_MODE,sks);
			byte[]encrypt=c.doFinal(message.getBytes());
			System.out.println("encrypted string"+new String(encrypt));
			System.out.println("encrypted string hex"+asHex(encrypt));
			
				
		}
	}

