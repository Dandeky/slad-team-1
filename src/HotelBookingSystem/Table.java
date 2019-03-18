package HotelBookingSystem;

public class Table {
    private int noOfPeople;
    private int tableId;
    private static int count = 0;

    public Table(int noOfPeople) {
        this.tableId = count;
        this.noOfPeople = noOfPeople;
        count++;
    }

    private int getNoOfPeople() {
        return noOfPeople;
    }

    private int getTableId() {
        return tableId;
    }

    private void setNoOfPeople(int newNoOfPeople) {
        noOfPeople = newNoOfPeople;
    }

    private void setTableId(int newTableId) {
        tableId = newTableId;
    }

    @Override
    public String toString() {
        return "Table: id = " + tableId + " noOfPeople = " + noOfPeople;
    }
}