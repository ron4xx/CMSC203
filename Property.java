

public class Property {

  private String thename;
    private String thisthecity;
    private double therentamount;
       private String propertyoftheowner;

    public Property() {
       thename = "";
        thisthecity = "";
    therentamount = 0.0;
        propertyoftheowner = "";}
          public Property(String justname, String city,double justrent, String ownerofprop) {
        this.thename = justname;
        this.thisthecity = city;
       this.therentamount = justrent;
        this.propertyoftheowner = ownerofprop;
    }

   public Property(Property other) {
    	thename = other.thename;
         thisthecity = other.thisthecity;
        therentamount = other.therentamount;
       propertyoftheowner = other.propertyoftheowner;
    
          }public String getPropertyName() {
        return thename;
    }

  
    
    
    
    public void setPropertyName(String propertyName) {
        this.thename = propertyName;
    }
    public String getCity() {
        return thisthecity;
    }
    public void setCity(String city) 
    {
  this.thisthecity = city;
    }
public double getRentAmount() {
        return therentamount;
    }
  public void setRentAmount(double rentAmount) {
        this.therentamount = rentAmount;
    } public String getOwner() 
    {
        return propertyoftheowner;
    }
    public void setOwner(String owner) {
        this.propertyoftheowner = owner;}
    @Override
    
    public String toString() {
        return String.format(
            "%s, %s, Rent: $%.2f, Owner: %s",thename, thisthecity, therentamount, propertyoftheowner);
    }
}
