/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.DataStructures;

/**
 * user
 *
 * @author fontai1
 */
public class Table implements Comparable {

    int tableNumber;
    int numberOfSeats;

    /*creates an instance of a table object*/
    public Table(int number, int seats) {
        tableNumber = number;
        numberOfSeats = seats;
    }

    /*returns the table number*/
    public int getTableNumber() {
        return tableNumber;
    }

    /*sets the table number*/
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /*returns the number of seats at the table*/
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /*sets the number of seats for the table*/
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof Table) {
            Table t = (Table) o;
            return tableNumber - t.tableNumber;
        } else {
            throw new ClassCastException();
        }
    }
}
