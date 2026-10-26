package BobsCircus;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CryptoManagerTestStudent {

               final String state = "The selected string is not in bounds, Try again.";
 @Test
    public void playfair_even() {
          String love = "COMPUTER";
        String favsubject = "SCIENCE";
   String enc = CryptoManager.playfairEncryption(love, favsubject);
        String dec = CryptoManager.playfairDecryption(enc, favsubject);
        assertEquals(love, dec);  }
    @Test
    public void playfairOdd() {
        String[] words = {"CAT"};   
      String key = "SCIENCE";
        for (int i = 0; i < words.length; i++) {
            String yooo = CryptoManager.playfairEncryption(words[i], key);
            String bruhh = CryptoManager.playfairDecryption(yooo, key);
            assertEquals(words[i], bruhh);
 }}   @Test
    
    public void testBounds_good() {
        String bruh = "JAVA 2026!";
   boolean result = CryptoManager.isStringInBounds(bruh);
        assertTrue(result);
        System.out.println("bounds good: " + result);
    }    @Test
    public void caesar1() {
        String text = "JAVA PROGRAM";
        int key = 7;
   String bjhjh = text;   
        String encrypted = CryptoManager.caesarEncryption(text, key);
             String decrypted = CryptoManager.caesarDecryption(encrypted, key);
          assertEquals(bjhjh, decrypted);
}
    @Test
    public void vigTest() {
        String thisthemessgae = "JAVA PROGRAM";
        String keyword = "CODE";
        String coded = CryptoManager.vigenereEncryption(thisthemessgae, keyword);
        String back = CryptoManager.vigenereDecryption(coded, keyword);
        assertEquals(thisthemessgae, back);
    }

    @Test
    public void testBounds_bad() {
       
        String[] bat = {"java", "HELLO`"};
        int count = 0;
        for (String b : bat) {
            if (!CryptoManager.isStringInBounds(b)) {
                count++;
            }
        }
        assertEquals(2, count);
    }
 @Test
    public void caesar_neg() {
        int rip = -5;
        String plain = "COMPUTER";
     String encrypted = CryptoManager.caesarEncryption(plain, rip);
        String decrypted = CryptoManager.caesarDecryption(encrypted, rip);
          if (decrypted.equals(plain)) {
            assertTrue(true);   
        }
        assertEquals(plain, decrypted);}

 
 @Test
 public void vigenere_bad_input() {
     String joe = CryptoManager.vigenereEncryption("java", "KEY");
   assertEquals("The selected string is not in bounds, Try again.", joe);
     System.out.println("Vigenere result: [" + joe + "]");
 }
 @Test
 public void playfair_bad_input() {
     String joee = CryptoManager.playfairEncryption("hello", "KEY");
     assertEquals("The selected string is not in bounds, Try again.", joee);
     System.out.println("Playfair result: " + joee + "");
     
 }
}