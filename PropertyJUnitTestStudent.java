
import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyJUnitTestStudent {
   private Property mypropertyss;
@BeforeEach
    public void setUp() {
	mypropertyss = new Property("Sunset Villa", "Rockville",1500.00, "Alice Smith");
    }
    @Test
    public void testDefaultConstructor() {
        Property thistheprope = new Property();

        assertEquals("", thistheprope.getPropertyName());
      assertEquals("", thistheprope.getCity());
       assertEquals(0.0, thistheprope.getRentAmount(), 0.001);
    assertEquals("", thistheprope.getOwner());
    }

   
    
    
    
    @Test
    public void testParameterizedConstructor() {
       assertEquals("Sunset Villa", mypropertyss.getPropertyName());
      assertEquals("Rockville", mypropertyss.getCity());
        
      
    assertEquals(1500.00, mypropertyss.getRentAmount(), 0.001);
        assertEquals("Alice Smith", mypropertyss.getOwner());
        
        
    }
@Test
    public void testCopyConstructor() {
        Property copys = new Property(mypropertyss);

        assertEquals(mypropertyss.getPropertyName(), copys.getPropertyName());
        assertEquals(mypropertyss.getCity(), copys.getCity());
        assertEquals(mypropertyss.getRentAmount(),
   copys.getRentAmount(), 0.001);
        assertEquals(mypropertyss.getOwner(), copys.getOwner());
        assertNotSame(mypropertyss, copys);
    }

   
    @Test
    
    
    public void testSetters() 
    	
  { mypropertyss.setPropertyName("New Villa");
    	mypropertyss.setCity("Bethesda");
    	mypropertyss.setRentAmount(2000.00);
    	mypropertyss.setOwner("John Smith");
        assertEquals("New Villa", mypropertyss.getPropertyName());
      assertEquals("Bethesda", mypropertyss.getCity());
        assertEquals(2000.00, mypropertyss.getRentAmount(), 0.001);
       assertEquals("John Smith", mypropertyss.getOwner());
    }@Test
    
    public void testToString() {
        String expected ="Sunset Villa, Rockville, Rent: $1500.00, Owner: Alice Smith";
        assertEquals(expected, mypropertyss.toString());
    }
}
