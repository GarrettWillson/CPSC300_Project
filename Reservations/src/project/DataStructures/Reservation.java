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

    /*creates a new reservation object*/
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

    /*returns the date of the reservation*/
    public Date getReservationDate() {
        return reservationDate;
    }

    /*sets the date for the reservation*/
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    /*returns the name of the customer who made the reservation*/
    public String getCustomerName() {
        return customerName;
    }

    /*sets the customer's name*/
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /*returns the contact phone number for the reservation*/
    public String getCustomerNumber() {
        return customerNumber;
    }

    /*sets the phone number*/
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /*returns the reservation number (this is unique within the set of
    reservations for a single customer, but is unknown to the user)*/
    public int getCustomerReservationNumber() {
        return customerReservationNumber;
    }

    /*sets the reservation number*/
    public void setCustomerReservationNumber(int custResNum) {
        customerReservationNumber = custResNum;
    }

    /*returns the number of hours that the reservation will last*/
    public int getLengthOfReservation() {
        return lengthOfReservation;
    }

    /*sets the number of hours the reservation will last*/
    public void setLengthOfReservation(int lengthOfReservation) {
        this.lengthOfReservation = lengthOfReservation;
    }

    /*returns the table object that the reservation is reserved at*/
    public Table getReservedTable() {
        return reservedTable;
    }

    /*sets the table for the reservation*/
    public void setReservedTable(Table reservedTable) {
        this.reservedTable = reservedTable;
    }

    /*returns the customer's special request*/
    public String getSpecialRequest() {
        return specialRequest;
    }

    /*sets the customer's special request*/
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    /*returns the hour that the reservation starts at (in 24h time)*/
    public int getStartHour() {
        return startHour;
    }
    
    /*sets the hour that the reservation starts at (in 24h time)*/
    public void setStartHour(int startTime) {
        startHour = startTime;
    }
}
