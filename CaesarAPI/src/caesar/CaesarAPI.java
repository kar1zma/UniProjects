package caesar;

/**----------------------------------------------------------------------------
 *  Author Baden Delamore.
 *  Assignment 3 - To write three methods
 *                 
 * Program description: 
 *       - Introduction to Cryptography.
 *         You have to program (using either Java, or
 *         C# programming languages) an API “
 *         call it CaesarAPI” that provides all three functionalities (encrypt,
 *         decrypt, and cryptanalysis). Your API should implement at minimum 
 *         three functions: Encrypt(plaintext,
 *         key), Decrypt(ciphertext, key) and Cryptanalyse(ciphertext)
 * Notice: 
 *       - Both the encryption and decyrption methods take a string (plaintext,
 *         ciphertext)and an int (key) as input parameters.
 *	 - Ciphertext method must have a return type. In this case it's String	
 * 
 * Assumptions and possible errors/bugs: 
 *       - Three hardcoded methods, encrypt, decrypt and cryptanalysis
 *       - The path and names of the files: hard coded. It is better to pass it
 *       - as an argument to the main method (part of args).
 * 
 * Testing:
 *       - OK.
 *         Performance and scalability issues: None.
 *----------------------------------------------------------------------------*/
import java.io.*;
import java.util.Scanner;
public class CaesarAPI {

    public static void main(String[] args) throws Exception {
       
            CaesarAPI c = new CaesarAPI();
            
            /* Assignment Part 1: Baden Delamore
             * Plain text encryption using plaintext and key as arguements to our encrypt method
             */
            String inputtext = "I am currently studying Cyber Security module at the Department of Computer Science, University of Waikato.";
            int key = 16;   //Shift each character by 16
            String outputtext = c.encrypt(inputtext, key);
            System.out.println("Part 1 Encrypted Text: " + outputtext);
            
            /* Assignment Part 2: Baden Delamore
             * Decrypt given cipher text using key 10
             */
            String cyphertext, plaintext;
            cyphertext = "Zbydomdsxq kx SD sxpbkcdbemdebo sxmvenoc gsno bkxqo yp kmdsfsdsoc drkd rkfo dy lo"
                       + "zobpybwon sx cixm gsdr okmr ydrob. Sx drsc vomdebo, go ohzvybo dro lkcsmc yp lesvnsxq kx"
                       + "SD cicdow drkd sccdboxqdroxon dy lo k comebo. Dro cdboxqdroxsxq zbymocc boaesboc"
                       + "rkbnoxsxq nsppoboxd mywzyxoxdc yp dro SD sxpbkcdbemdebo sxmvensxq Yzobkdsxq"
                       + "Cicdowc, Xodgybuc kxn Kzzvsmkdsyxc.";
            key = 10;
            plaintext = c.decrypt(cyphertext, key);
            System.out.println("Part 2 Decyrted Text: " + plaintext);
            
            /* Assignment Part 3: Baden Delamore
             * Call cryptanalyse and return all 26 possible plaintext of our given crypttext input
             */
            
            String crypttext, decrypttxt;
            crypttext = "Jatp uawn pda Qjeranoepu yahaxnwpao epo benop 50 uawno wjz ej pdwp odknp peia sa'ra "
                      + "xaykia kja kb pda xaop ej pda sknhz. Nayajphu sa dwz kqn lhwya ykjbeniaz wo kja kb pda Pkl"
                      + "50 qjeranoepeao ej pda sknhz qjzan 50 uawno khz. Pda decdhu nacwnzaz QGxwoaz Peiao "
                      + "Decdan Azqywpekj Nwjgejco whok lhwyaz qo ej pda pkl 2% kbwhh qjeranoepeao sknhzseza.";
            decrypttxt = c.cryptanalyse(crypttext);
            System.out.println("Part 3 Decoded CryptText: " + decrypttxt);
        
    }
    public void bad11test() {
        /* just run test cases in here and call them
         * accordingly
         */
        try {
        CaesarAPI caesar = new CaesarAPI();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc1 = new Scanner(System.in);
        String decrypttxt, origtxt;
        int key;
        
        System.out.println("Enter text to be decrypted: ");
        origtxt = b.readLine();

        System.out.println("Enter cipher key length: ");
        key = sc1.nextInt();
        decrypttxt = caesar.decrypt(origtxt, key);
        System.out.println(decrypttxt);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
        private String decrypt(String s, int key) throws IOException {
            
            /* check that key is inbound */
            if (key < 0 || key > 25) {
                throw new IllegalArgumentException
                ("Out of bounds key length, choose a key between 0 and 25");
            } 
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                char t=s.charAt(i);
                if(t>='A' && t<='Z') {
                    int t1=t-'A'-key;
                    if(t1<0)t1=26+t1;
                    sb.append((char)(t1+'A'));
                }
                else if(t>='a' && t<='z') {
                    int t1=t-'a'-key;
                    if(t1<0)t1=26+t1;
                    sb.append((char)(t1+'a'));
                }
            }
            return sb.toString();
        }
        
         private String encrypt(String s, int key) throws IOException {
            
            /* check that key is inbound */
            if (key < 0 || key > 25) {
                throw new IllegalArgumentException
                ("Out of bounds key length, choose a key between 0 and 25");
            }    
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                char t=s.charAt(i);
                if(t>='A' && t<='Z') {
                    int t1=t-'A'-key;
                    if(t1<0)t1=26+t1;
                    sb.append((char)(t1+'A'));
                }
                else if(t>='a' && t<='z') {
                    int t1=t-'a'-key;
                    if(t1<0)t1=26+t1;
                    sb.append((char)(t1+'a'));
                }
            }
            return sb.toString();
        }
        
         private String cryptanalyse(String s) throws IOException {                          
           
            StringBuilder sb=new StringBuilder();
            int keycount;
            keycount = 1;
            String cryptstr = "";
            while (keycount <= 26){
                for(int i=0;i<s.length();i++)
                {
                    char t=s.charAt(i);
                    if(t>='A' && t<='Z') {
                        int t1=t-'A'-keycount;
                        if(t1<0)t1=26+t1;
                        sb.append((char)(t1+'A'));
                    }
                    else if(t>='a' && t<='z') {
                        int t1=t-'a'-keycount;
                        if(t1<0)t1=26+t1;
                        sb.append((char)(t1+'a'));
                    }

                }
                cryptstr = cryptstr.concat(sb.toString() + "\n");                
                keycount++;
                sb.setLength(0);
            }
            return cryptstr;        //Return all possible 26 decryted text
        }
}
