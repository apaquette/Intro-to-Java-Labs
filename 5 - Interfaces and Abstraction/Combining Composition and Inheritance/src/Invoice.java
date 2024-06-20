/**
 * Invoice class used to store part number, part description, quantity, and price per item.
 * All fields are final. Implements Payable. Numerical fields cannot be negative
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class Invoice implements Payable {
   private final String partNumber; 
   private final String partDescription;
   private final int quantity;
   private final double pricePerItem;

    /**
     * All argument constructor with part number, part description, quantity, and price per item.
     * @param partNumber Invoice part number
     * @param partDescription Invoice part description
     * @param quantity Invoice quantity, cannot be negative
     * @param pricePerItem Invoice price per item, cannot be negative
     */
   public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }
      
      if (pricePerItem < 0.0) { // validate pricePerItem
         throw new IllegalArgumentException(
            "Price per item must be >= 0");
      }

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   }

    /**
     * Get Part Number method
     * @return Invoice part number
     */
   public String getPartNumber() {return partNumber;}

   // get description

    /**
     * Get Part Description method
     * @return Invoice part description
     */
   public String getPartDescription() {return partDescription;}

    /**
     * Get Quantity method
     * @return Invoice item quantity
     */
   public int getQuantity() {return quantity;}

    /**
     * Get price per item method
     * @return Invoice price per item
     */
   public double getPricePerItem() {return pricePerItem;}
   
   /**
    * Returns invoice record listing part number, part description, quantity, and price per item
    * @return Invoice Record
    */
   @Override
   public String toString() {
      return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
         "invoice", "part number", getPartNumber(), getPartDescription(), 
         "quantity", getQuantity(), "price per item", getPricePerItem());
   }

    /**
     * Get payment amount method
     * @return Calculated payment amount (quantity * price per item)
     */
   @Override                                                           
   public double getPaymentAmount() {                                  
      return getQuantity() * getPricePerItem(); // calculate total cost
   }                                                                   
} 




/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
