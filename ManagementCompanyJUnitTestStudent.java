
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyJUnitTestStudent {

        private ManagementCompany thisjustisthecompany;
    @BeforeEach
    public void setUp() {
    	thisjustisthecompany = new ManagementCompany("Campus Realty", "123-45-6789");
    }@Test
    public void testConstructor() {
        assertEquals("Campus Realty", thisjustisthecompany.getName());
       assertEquals("123-45-6789", thisjustisthecompany.getTaxId());
          assertEquals(0, thisjustisthecompany.getPropertyCount());}
   @Test
    public void testaddProperty() {
 Property thisisthefirstproperty = new Property("Apt 1", "Rockville",1200.0, "Bob");

        Property thisproperty2  = new Property("Apt 2", "Bethesda",1500.0, "Carol");
        assertEquals(0, thisjustisthecompany.addProperty(thisisthefirstproperty));
      assertEquals(1, thisjustisthecompany.addProperty(thisproperty2));
         assertEquals(2, thisjustisthecompany.getPropertyCount());
    }
    @Test
    public void testtotalrent() {
  thisjustisthecompany.addProperty(new Property("Apt 1", "Rockville", 1200.0, "Bob"));

        	thisjustisthecompany.addProperty(new Property("Apt 2", "Bethesda", 1500.0, "Carol"));

    assertEquals(2700.0, thisjustisthecompany.totalRent(), 0.001);
    } 
    @Test
    
    public void testFullArray()
 {for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) 
 {
        	thisjustisthecompany.addProperty(new Property("P" + i, "City", 1000.0, "Owner"));}

      int thisresult = thisjustisthecompany.addProperty(new Property("Extra", "City", 2000.0, "OwnerX")) ;
     assertEquals(-1, thisresult);
          assertEquals(ManagementCompany.MAX_PROPERTIES,
        		thisjustisthecompany.getPropertyCount());
    }

   
  @Test
    
    public void testcopyConstructor() {
    	thisjustisthecompany.addProperty(new Property("Apt 1", "Rockville", 1200.0, "Bob"));
        ManagementCompany copy = new ManagementCompany(thisjustisthecompany);
            assertEquals(thisjustisthecompany.getName(), copy.getName());
  assertEquals(thisjustisthecompany.getTaxId(), copy.getTaxId());
     assertEquals(thisjustisthecompany.getPropertyCount(),
                copy.getPropertyCount());

        assertEquals(thisjustisthecompany.totalRent(), copy.totalRent(), 0.001);

        assertNotSame(thisjustisthecompany.getProperty(0), copy.getProperty(0));
    }

  
    @Test
    public void testInvalidPropertyIndex() {
    	
    	
    	
        assertNull(thisjustisthecompany.getProperty(0));
        assertNull(thisjustisthecompany.getProperty(-1));
    }
}
