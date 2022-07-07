

	import java.io.*;
	import java.util.Scanner;
	import javax.crypto.*;
	import java.security.*;
	import java.math.BigInteger;
	import javax.crypto.Cipher;
	import javax.crypto.KeyGenerator;
	import javax.crypto.SecretKey;
	import javax.crypto.spec.*;
public class rijndeal {

	
    private static String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length*2);
        
        int i;
        for(i=0;i<buf.length;i++) {
            if(((int)buf[i]&0xff)<0x10)
                strbuf.append("0");
            strbuf.append(Long.toString((int)buf[i]&0xff,16));
        }
        return strbuf.toString();
    }
		public static void main(String args[]) throws Exception
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter a message");
			String message=sc.nextLine();
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128);
			SecretKey sk=kg.generateKey();
			byte[] raw=sk.getEncoded();
			SecretKeySpec sks=new SecretKeySpec(raw,"AES");
			Cipher c=Cipher.getInstance("AES");
			c.init(Cipher.ENCRYPT_MODE,sks);
			byte[]encrypt=c.doFinal(message.getBytes());
			System.out.println("encrypted string"+new String(encrypt));
			System.out.println("encrypted string hex"+asHex(encrypt));
			
				
		}
	}

