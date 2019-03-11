package assignment;

public class Table {
    private int noOfPeople;
    private int tableId;

    Table(int noOfPeople, int tabeId) {
        this.noOfPeople = noOfPeople;
        this.tableId = tabeId;
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