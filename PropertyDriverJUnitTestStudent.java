
  import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class PropertyDriverJUnitTestStudent {

   
    @Test
    
    public void testAddAndDisplayProperty() {
         String input = "1\nProperty-1\nRockville\n3500\nJoe\n2\n4\n";
        ByteArrayInputStream in =new ByteArrayInputStream(input.getBytes());
     ByteArrayOutputStream output =new ByteArrayOutputStream();
        java.io.InputStream theoriginal = System.in;
        PrintStream originalOut = System.out;
       System.setIn(in);
        System.setOut(new PrintStream(output));
                            try {
            PropertyDriver.main(new String[0]);
        } finally {
            System.setIn(theoriginal);
       System.setOut(originalOut);
        }
        String result = output.toString();
        assertTrue(result.contains("Property added at index 0."));
assertTrue(result.contains("Property-1"));
        assertTrue(result.contains("Rockville"));
         assertTrue(result.contains("$3500.00"));
}
    @Test 
 public void testTotalRent() {

     String theyisinput = "1\nProperty-1\nRockville\n3500\nJoe\n3\n4\n";
        ByteArrayInputStream in =new ByteArrayInputStream(theyisinput.getBytes());
         ByteArrayOutputStream output =new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;
       System.setIn(in);
         System.setOut(new PrintStream(output));
    try {
            PropertyDriver.main(new String[0]);
} finally {
            System.setIn(originalIn);
             System.setOut(originalOut);
        }

        String resultss = output.toString();
        assertTrue(resultss.contains("Total rent: $3500.00"));
    }
  @Test
    
  
  
    
    public void testExit() {

        String input = "4\n";
        ByteArrayInputStream in =new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream output =new ByteArrayOutputStream();
        	//this th
        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;
         System.setIn(in);
        System.setOut(new PrintStream(output));
        try {
            PropertyDriver.main(new String[0]);
        } finally {
            System.setIn(originalIn);
        System.setOut(originalOut);
        }
        assertTrue(output.toString().contains("Exiting Property Manager."));}
}
