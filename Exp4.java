//DES Algorithm

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class Exp4
{
    public static void main(String[] args)
    {
        try
        { 
            String plt;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the text");
            plt=sc.nextLine();
            KeyGenerator kg=KeyGenerator.getInstance("DES");
            SecretKey myDESKey =kg.generateKey();
            Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            System.out.println(myDESKey);
            cipher.init(Cipher.ENCRYPT_MODE,myDESKey);
            byte[] text=plt.getBytes();
            System.out.println("Text in bytes :" + text);
            System.out.println("TEXT :" + new String(text));
            byte[] textEnc=cipher.doFinal(text);
            System.out.println("Text in bytes :" + textEnc);
            System.out.println("THE ENCRYPTED TEXT IS " + new String(textEnc));
            cipher.init(Cipher.DECRYPT_MODE,myDESKey);
            byte[] textDec=cipher.doFinal(textEnc);
            System.out.println("Text in bytes :" + textDec);
            System.out.println("THE DECRYPTED TEXT IS " + new String(textDec));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}   
