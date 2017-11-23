/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.DataStructures;

/**
 * user
 * @author fontai1
 */
public class Table implements Comparable{
    int tableNumber;
    int numberOfSeats;
    
    public Table(int number, int seats) {
        tableNumber = number;
        numberOfSeats = seats;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    @Override
    public String toString() {
        return "Table " + tableNumber;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) {
            throw new NullPointerException();
        }
        if(o instanceof Table) {
           Table t = (Table)o;
           return tableNumber - t.tableNumber;
        } else {
            throw new ClassCastException();
        }
    }
}
