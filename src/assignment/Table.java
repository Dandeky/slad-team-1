package assignment;

public class Table {
    private int noOfPeople;
    private int tableId;

    public Table(int tableId, int noOfPeople) {

        this.noOfPeople = noOfPeople;
        this.tableId = tableId;
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