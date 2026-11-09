

public class ManagementCompany {

  
 public static final int MAX_PROPERTIES = 5;
    private String nowthisisname;
   private String taxingid;
    
   private Property[] properties;
      private int propertyCount;
 public ManagementCompany(String name, String taxId) {
        this.nowthisisname = name;
         this.taxingid = taxId;
       properties = new Property[MAX_PROPERTIES];
         propertyCount = 0; }
 public ManagementCompany(ManagementCompany other) {
    	nowthisisname = other.nowthisisname;
    	taxingid = other.taxingid;
        properties = new Property[MAX_PROPERTIES];
          propertyCount = other.propertyCount;

        for (int i = 0; i < propertyCount; i++) {  properties[i] = new Property(other.properties[i]); }
    }public String getName() {
        return nowthisisname;
    }
    public String getTaxId() {
        return taxingid;
    } 
       public int getPropertyCount() {
        return propertyCount;
    }
  public Property getProperty(int theindex) {
        if (theindex < 0 || theindex >= propertyCount) {
            return null;
        }

        return properties[theindex];
    }

   
public int addProperty(Property p) {
        if (propertyCount >= MAX_PROPERTIES) {
            return -1;
        }
        properties[propertyCount] = new Property(p);
        int index = propertyCount;
         propertyCount++;
        return index;
    }

   
    public double totalRent() {
        double total = 0.0;
         for (int i = 0; i < propertyCount; i++) 
         {
         total += properties[i].getRentAmount();
        }return total;
    }
    @Override
    
    public String toString() {
        String thisisjusttheresult = "Management Company: " + nowthisisname+ " (Tax ID: " + taxingid + ")\n";

          thisisjusttheresult += "Properties:\n";

        for (int i = 0; i < propertyCount; i++) {
            thisisjusttheresult += " " + i + ": "
                    + properties[i].toString() + "\n";
        }

        thisisjusttheresult += String.format("Total Rent: $%.2f", totalRent());

        return thisisjusttheresult;
    }
}
