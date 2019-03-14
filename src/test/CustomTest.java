package test;

import assignment.Table;

public class CustomTest {

    public static void main(String[] args) {
        Table testTable = new Table(1, 5);
        Table[] tables = new Table[5];

        for (int i = 0; i < tables.length; i++) {
            tables[i] = testTable;
        }

        for (Table table : tables) {
            System.out.println(table);
        }


    }
}
