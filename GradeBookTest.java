


//decided to kust remove all the comments to make code look better
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
public class GradeBookTest 

{    private GradeBook thisisgrade1;
    private GradeBook nowthisisgrade2;
    //just setting up the gradebooks before the test
    @BeforeEach 
   
   
    public void setUp() {
        thisisgrade1   = new GradeBook(5);
        thisisgrade1. addScore(50.0);
     
        
        
        thisisgrade1.addScore(75.0);
              nowthisisgrade2 = new GradeBook(5);
        nowthisisgrade2.addScore(90.0);
   nowthisisgrade2.addScore(85.0);
        nowthisisgrade2 .addScore(70.0);
    }
//now clearing the gradebook after the test
    @AfterEach
    public void tearDown() {
        thisisgrade1 = null;
   thisisgrade1 = null;
  }
    @Test
    public void testAddScoreAndToString() {
        assertEquals("50.0 75.0 ", thisisgrade1.toString());
        assertEquals("90.0 85.0 70.0 ", nowthisisgrade2.toString());}
@Test
    public void testGetScoreSize() {
        assertEquals(2, thisisgrade1.getScoreSize());
        assertEquals(3, nowthisisgrade2.getScoreSize());
    }
//check that the scores gets added correctly
    @Test
    public void testSum() {
        assertEquals(125.0, thisisgrade1.sum(), 0.0001);
        assertEquals(245.0, nowthisisgrade2.sum(), 0.0001);
    }
//this th
    
    @Test
    public void testMinimum() {
        assertEquals(50.0, thisisgrade1.minimum(), 0.0001);
       assertEquals(70.0, nowthisisgrade2.minimum(), 0.0001);
             GradeBook      empty = new GradeBook(5);
        assertEquals(0.0, empty.minimum(), 0.0001);
  
 } @Test
    public void testFinalScore() {
        assertEquals(75.0, thisisgrade1.finalScore(), 0.0001);
       
        
        assertEquals(175.0, nowthisisgrade2.finalScore(), 0.0001);
        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.finalScore(), 0.0001);
        GradeBook single = new GradeBook(5);
        single.addScore(100.0);
        
        assertEquals(100.0, single.finalScore(), 0.0001);
    }
}

