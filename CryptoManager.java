package BobsCircus;
//Meron Sebhatu

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    private static final int RANGE = ALPHABET64.length();
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (ALPHABET64.indexOf(plainText.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
    

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

//did this
    public static String vigenereEncryption(String plainText, String key) {
       
        if (key.length() == 0) 
        {
        	 return "The selected string is not in bounds, Try again.";}
        if (!isStringInBounds(plainText)) {
      return "The selected string is not in bounds, Try again.";
        }
        if (!isStringInBounds(key))
        {return "The selected string is not in bounds, Try again.";
        }

       String bru = "";
         int keypoo = 0;   
        int i = 0;

        while (i < plainText.length()) {
            char p = plainText.charAt(i);
            char k = key.charAt(keypoo);

            int pIdx = ALPHABET64.indexOf(p);
            int kIdx = ALPHABET64.indexOf(k);

            int total = pIdx + kIdx;
            if (total >= RANGE) {
                total = total - RANGE;   
            }

            bru += ALPHABET64.charAt(total);

          
            keypoo++;
            if (keypoo == key.length()) {
                keypoo = 0;
            }
            i++;
        }

        return bru;
    }
   //did this
    public static String vigenereDecryption(String encryptedText, String key) {
        if (key.length() == 0) {
        	return "The selected string is not in bounds, Try again.";
            }
       if (!isStringInBounds(encryptedText)) {
    	   return "The selected string is not in bounds, Try again."; }
            if (!isStringInBounds(key)) 
            {
            	return "The selected string is not in bounds, Try again.";
        }
     String strat = "";
        int keyss = 0;   
        int i = 0;

        while (i < encryptedText.length()) {
            char c = encryptedText.charAt(i);
            char k = key.charAt(keyss);

            int cIdx = ALPHABET64.indexOf(c);
            int kIdx = ALPHABET64.indexOf(k);

            int diff = cIdx - kIdx;
            if (diff < 0) {
                diff = diff + RANGE;  
            }strat += ALPHABET64.charAt(diff);           
            keyss++;
            if (keyss == key.length()) {
                keyss = 0;
            }
            i++;
        }

        return strat;
    }
//di
    private static char[][] buildMatrix(String key) {
        final int thesize = 8;   

        
        String everything = key + ALPHABET64;
        String uniq = "";

        for (int n = 0; n < everything.length(); n++) {
            char rol = everything.charAt(n);
            if (uniq.indexOf(rol) < 0) {
                uniq += rol;   
            }
        } char[][] grid = new char[thesize][thesize];

        
          for (int posi = 0; posi < thesize *thesize; posi++) {
        int wreck = posi / thesize;
            int seat = posi % thesize;
           grid[wreck][seat] = uniq.charAt(posi);
        }

  return grid;}
	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

  //did this
 // looks up a char in the grid, gives back {row, col}
    private static int[] where(char[][] g, char ch) {
        int[] poee = new int[2];
   for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                 if (g[i][j] == ch) {
          poee[0] = i;
                    poee[1] = j;
          }
            }}
        return poee;
 }public static String playfairEncryption(String plainText, String key) {
        if (!isStringInBounds(plainText)) {
        	return "The selected string is not in bounds, Try again.";
        }
        if (!isStringInBounds(key)) {
        	return "The selected string is not in bounds, Try again.";
        }
 char[][] build = buildMatrix(key);
        String jstext = plainText;
        int origLen = jstext.length();   

        if (origLen % 2 != 0) {
            jstext = jstext + "X";   
        }

        String done = "";    for (int i = 0; i < jstext.length(); i += 2) {
            int[] p1 = where(build, jstext.charAt(i));
              int[] p2 = where(build, jstext.charAt(i + 1));
  
            
    

              
              
            if (p1[0] == p2[0]) 
            {done += build[p1[0]][(p1[1] + 1) % 8];
                done += build[p2[0]][(p2[1] + 1) % 8];
            }       else {
         if (p1[1] == p2[1]) { 
                      done += build[(p1[0] + 1) % 8][p1[1]];
                    done+= build[(p2[0] + 1) % 8][p2[1]];
                } else 
                {
 done += build[p1[0]][p2[1]];
                    done += build[p2[0]][p1[1]];
                }
     }
        }return done;
    }

    // Vigenere Decryption
//did this
public static String playfairDecryption(String encryptedText, String key) {
    if (!isStringInBounds(encryptedText) || !isStringInBounds(key)) {
        return "The selected string is not in bounds, Try again.";
    }if (encryptedText.length() % 2 != 0) {
        return "The selected string is not in bounds, Try again."; }

    char[][] matrix = buildMatrix(key);
    String plainText = "";  for (int i = 0; i < encryptedText.length(); i += 2) {
        char first = encryptedText.charAt(i);
   char second = encryptedText.charAt(i + 1);

        int row1 = 0;
           int col1 = 0;
        int row2 = 0;
   int col2 = 0;

     for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == first) {
                    row1 = row;
                    col1 = col;
                }

                if (matrix[row][col] == second) {
                    row2 = row;
                    col2 = col;
                }
            }
        }

        if (row1 == row2) {
        	
        	
        	
        	
        	
        	
        	
            plainText += matrix[row1][(col1 + 7) % 8];
         plainText += matrix[row2][(col2 + 7) % 8]; } else if (col1 == col2) {
            plainText += matrix[(row1 + 7) % 8][col1];
               plainText += matrix[(row2 + 7) % 8][col2];
        } else {
         plainText += matrix[row1][col2];
               plainText += matrix[row2][col1];
        }}

  if (plainText.length() > 0
            && plainText.charAt(plainText.length() - 1) == 'X') {
        plainText = plainText.substring(0, plainText.length() - 1);
    }

    return plainText;
}

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
//done
public static String caesarEncryption(String plainText, int key) {
    if (!isStringInBounds(plainText)) {
 return "The selected string is not in bounds, Try again."; }

    int shift = ((key % RANGE) + RANGE) % RANGE;
    String ecnyrpttext = "";
 
   for (int i = 0; i < plainText.length(); i++) {
             int index = plainText.charAt(i) - LOWER_RANGE;
       
      
                     int encryptedIndex = (index + shift) % RANGE;

        ecnyrpttext += (char) (encryptedIndex + LOWER_RANGE);
    }    return ecnyrpttext;
}

    // Caesar Decryption
//done
public static String caesarDecryption(String encryptedText, int key) {
    if (!isStringInBounds(encryptedText)) {
        return "The selected string is not in bounds, Try again.";
    
    }int shift = ((key % RANGE) + RANGE) % RANGE;
    String justthetext = "";
    for (int i = 0; i < encryptedText.length(); i++) {
        int index = encryptedText.charAt(i) - LOWER_RANGE;
        int plainIndex = (index - shift + RANGE) % RANGE;

        justthetext += (char) (plainIndex + LOWER_RANGE);
    }
    return justthetext;
}
}
