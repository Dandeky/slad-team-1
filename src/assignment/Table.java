package assignment;

public class Table {
    private int noOfPeople;
    private int tableId;

    Table(int newNoOfPeople, int newTabeId) {
        noOfPeople = newNoOfPeople;
        newTabeId = newTabeId;
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
}