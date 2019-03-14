package assignment;

public class Restaurant {

    private String restaurantName;
    private Table[] tables;

    public Restaurant(String RestaurantName, int[] noOfTables) {
        this.restaurantName = RestaurantName;
        tables = new Table[noOfTables.length];
        for (int i = 0; i < noOfTables.length; i++) {
            tables[i] = new Table(i, noOfTables[i]);
        }
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getTotalTables() {
        return tables.length;
    }

    public Table[] getTables() {
        return tables;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(restaurantName);
        for (Table table:tables) {
            string.append(" ").append(table.toString());
        }
        return string.toString();
    }
}
