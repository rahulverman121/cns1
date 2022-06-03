//BlowFish Algorithm

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import sun.misc.Encryption;

public class Exp5 
{
    public static void main(String[] args) throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();
        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
        Encryption encoder = new Encryption();
        byte iv[] = cipherOut.getIV();
        if (iv != null) 
        {
            System.out.println("Initialization Vector of the Cipher: " + encoder.encode(iv));
            FileInputStream fin = new FileInputStream("inputFile.txt");
            FileOutputStream fout = new FileOutputStream("outputFile.txt");
            CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);
            int input = 0;
            while ((input = fin.read()) != -1) 
            {
                fin.close();
                cout.close();
            }
        }
    }
}
