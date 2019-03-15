package test;

import HotelBookingSystem.Table;

public class TablesTest {

    public static void main(String[] args) {
        Table testTable;
        Table[] tables = new Table[5];

        for (int i = 0; i < tables.length; i++) {
            testTable = new Table(i, i*i);
            tables[i] = testTable;
        }

        for (Table table : tables) {
            System.out.println(table);
        }


    }
}
