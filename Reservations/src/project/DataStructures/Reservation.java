/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.DataStructures;

import java.util.Date;

/**
 *
 * @author fontai1
 */
public class Reservation {
    Date reservationDate;
    String customerName;
    String customerNumber;
    int customerReservationNumber;
    int startHour;
    int lengthOfReservation;
    Table reservedTable;
    String specialRequest;
    
    public Reservation(String name, String number, int custResNum, Date date, int startTime, int length, Table table, String request) {
        reservationDate = date;
        customerName = name;
        customerNumber = number;
        customerReservationNumber = custResNum;
        startHour = startTime;
        lengthOfReservation = length;
        reservedTable = table;
        specialRequest = request;
    }

    Reservation(String name, String number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    public int getCustomerReservationNumber() {
        return customerReservationNumber;
    }
    
    public void setCustomerReservationNumber(int custResNum) {
        customerReservationNumber = custResNum;
    }

    public int getLengthOfReservation() {
        return lengthOfReservation;
    }

    public void setLengthOfReservation(int lengthOfReservation) {
        this.lengthOfReservation = lengthOfReservation;
    }

    public Table getReservedTable() {
        return reservedTable;
    }

    public void setReservedTable(Table reservedTable) {
        this.reservedTable = reservedTable;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public int getStartHour() {
        return startHour;
    }
}
