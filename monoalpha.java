package cns;

import java.io.FileReader;
import java.io.FileWriter;

public class monoalpha {
    public static char alphabet[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    
    public static char substitute[]  = { 'Q', 'I', 'O', 'Y', 'N', 'V', 'U', 'C', 'E',
            'D', 'F', 'G', 'R', 'B', 'A', 'P', 'L', 'K', 'J', 'H', 'M', 'W',
            'X', 'Z', 'S', 'T' };
    
    public static int freqPlainText[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
    
    public static int freqCipher[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
   		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
    
    public static String readInputFile() throws Exception {
    	FileReader fr=new FileReader("C:\\Users\\Asus\\eclipse-workspace\\cns\\src\\cns\\input.txt");
        int i; 
        String plaintext = "";
        while((i=fr.read())!=-1) { 
        plaintext += (char)i;
        }
        fr.close();
    	return plaintext.toLowerCase();
    }
    
    public static String encrypt(String plaintext) {
    	char cipher[] = new char[(plaintext.length())];
    	for (int i=0;i<plaintext.length();i++) {
    		for(int j=0;j<26;j++) {
    			if (plaintext.charAt(i) == alphabet[j]) {
    				cipher[i] = substitute[j];
    				freqPlainText[j] +=1;
    			}
    		}
    	}
    	return (new String(cipher));
    }
    
    public static void writeOutputFile(String cipher) throws Exception {
    	FileWriter fileOutput= new FileWriter("C:\\Users\\Asus\\eclipse-workspace\\cns\\src\\cns\\output.txt");
    	fileOutput.write(cipher);
    	fileOutput.close();
    }
    
    public static String decrypt(String cipher) {
    	char decryptedText[] = new char[(cipher.length())];
    	for (int i=0;i<cipher.length();i++) {
    		for(int j=0;j<26;j++) {
    			if (cipher.charAt(i) == substitute[j]) {
    				decryptedText[i] = alphabet[j];
    				freqCipher[j] += 1;
    			}
    		}
    	}
    	return (new String(decryptedText));
    }
    
	public static void main(String[] args) throws Exception {
		String input =  readInputFile();
		String cipher = encrypt(input);
		writeOutputFile(cipher);
		String decryptText = decrypt(cipher);
        System.out.println("\nPlainText : "+input);
        System.out.println("\nCipher Text : "+cipher);
        System.out.println("\nDecrypted Text: "+decryptText);
        System.out.println("\nFrequency Table for PlainText \t\t\tFrequency Table for CipherText");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|Alphabet |   Frequency   |\t\t\t |Alphabet |    Frequency   |");
        System.out.println("------------------------------------------------------------------------------");
        for (int i=0;i<26;i++) {
        	System.out.print("|    "+alphabet[i]+"    |      "+freqPlainText[i]/10.0f+"      | \t\t\t");
        	System.out.print(" |    "+substitute[i]+"    |      "+freqCipher[i]/10.0f+"       |\n");
        }
        System.out.println("------------------------------------------------------------------------------");
        
	}
}
	
