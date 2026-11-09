
import java.util.Scanner;
//Meron Sebhatu

public class PropertyDriver {
public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ManagementCompany thisthecompany =new ManagementCompany("Campus Realty", "123-45-6789");
        int thismenuchoice = 0;

        while (thismenuchoice != 4) {
           System.out.println("====================================");
                 System.out.println("   Assignment 4: Property Manager");
    System.out.println("====================================");
            System.out.println("1 - add Property");
          System.out.println("2 - Display all Properties");
            System.out.println("3 - Show Total Rent");
           
            
            
              System.out.println("4 - exit");
            System.out.println();

            System.out.print("Enter choice (1-4): ");

            if (!keyboard.hasNextInt()) {
                System.out.println("Invalid choice. enter a number.");
                keyboard.nextLine();
                continue;
            }
            thismenuchoice = keyboard.nextInt();
         keyboard.nextLine();

            if (thismenuchoice == 1) {

                System.out.print("Enter property name: ");
                String name = keyboard.nextLine();

            System.out.print("Enter city: ");
                String city = keyboard.nextLine();

                System.out.print("Enter monthly rent: ");

                     if (!keyboard.hasNextDouble()) {
                    System.out.println("Invalid rent amount.");
                     keyboard.nextLine();
                    continue;
                }

                double rentAmount = keyboard.nextDouble();
                keyboard.nextLine();

           if (rentAmount < 0) {
                    System.out.println("Rent cannot be negative.");
                    continue;
                }

                System.out.print("Enter owner name: ");
                String owner = keyboard.nextLine();
                  Property property = new Property(name, city, rentAmount, owner);
                int index = thisthecompany.addProperty(property);
                if (index == -1) {
                    System.out.println("Cannot add property. Company is full.");
                 
           }else {
                    System.out.println("Property added at index " + index + ".");
                }
   } else if (thismenuchoice == 2) {

                System.out.println(thisthecompany.toString());
            } else if (thismenuchoice == 3) {
                System.out.printf("Total rent: $%.2f%n",thisthecompany.totalRent());
           } else if (thismenuchoice == 4) {
        	   System.out.println("Exiting Property Manager.");

            } else {
           System.out.println("Invalid choice. Please enter 1-4.");
            }

            System.out.println();
        }
        if (thisthecompany.getPropertyCount() > 0) {
         Property originalProperty = thisthecompany.getProperty(0);
           
         
         
         
     Property copiedProperty =new Property(originalProperty);
     
            
            
            
            
            
            System.out.println("Property Copy Constructor Demonstration:");
            System.out.println(copiedProperty);

               ManagementCompany copiedCompany =new ManagementCompany(thisthecompany);
 System.out.println();
           
 
 
        System.out.println("ManagementCompany Copy Constructor Demonstration:");

            System.out.println("Original property count: "+thisthecompany.getPropertyCount());
          System.out.println("Copied property count: "+ copiedCompany.getPropertyCount());
                 System.out.printf("Copied company total rent: $%.2f%n", copiedCompany.totalRent());}

        keyboard.close();

       System.out.println();
        System.out.println("programmer: Meron Sebhatu");
    }
}
