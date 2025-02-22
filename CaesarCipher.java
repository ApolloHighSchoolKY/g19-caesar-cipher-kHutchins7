/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {

            alphabet = new char[26];
            String alphabetString = "abcdefghijklmnopqrstuvwxyz";
            for(int i=0; i<alphabetString.length();i++){
                alphabet[i]= alphabetString.charAt(i);
            }
            shifted = new char[alphabet.length];
            shift =4;
            shifter(shift);
    }

    public CaesarCipher(int num){
        alphabet = new char[26];
        String alphabetString = "abcdefghijjklmnopqrstuvwxyz";

        for(int i=0; i<alphabetString.length()-1;i++){
            alphabet[i] = alphabetString.charAt(i);
        
            
        }
        shifted = new char[alphabet.length];
        shift = num;
        shifter(shift);

    }

    public String encrypt(String message){
         String encryption = "";
         boolean found = false;
         for(int i =0;i<message.length();i++)
         {
            found = false;
            for(int a = 0; a<alphabet.length; a++)
            {
                if(message.charAt(i)==alphabet[a])
                {
                    found = true;
                    encryption += shifted[a];
                }
            }
            if(found==false)
            encryption += message.charAt(i);
         }
         return encryption;
    }

    public String decrypt(String message){
        String decryption = "";
         boolean found = false;
         for(int i =0;i<message.length();i++)
         {
            found = false;
            for(int a = 0; a<shifted.length; a++)
            {
                if(message.charAt(i)==shifted[a])
                {
                    found = true;
                    decryption += alphabet[a];
                }
            }
            if(found==false)
            decryption += message.charAt(i);
         }
         return decryption;
   
    }

    public void shifter(int num)
    {
        for(int i =0; i<alphabet.length; i++)
        {
            if((i+num)>=alphabet.length)
             shifted[(i+num)-alphabet.length]=alphabet[i];
            else
             shifted[i+num]=alphabet[i];
        }
        

    }


}