
package assignment;

public class Restaurant {
    String restaurantName;
    Object[] tables;

    Restaurant(String RestaurantName,int[] noOfTables){
        this.restaurantName = RestaurantName;
        tables = new Object[ noOfTables.length ];
        
            for(int t=0;t<noOfTables.length;t++){
                
                tables[t] =  new Table(t , noOfTables[t]);
            }
        }
}
