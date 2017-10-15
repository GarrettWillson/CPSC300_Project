/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author fontai1
 */
public class Reservation {
    Date reservationDate;
    String customerName;
    String customerNumber;
    int lengthOfReservation;
    Table reservedTable;
    String specialRequest;  
    
    public Reservation(Date date, String name, String number, int length, Table table, String request) {
        reservationDate = date;
        customerName = name;
        customerNumber = number;
        lengthOfReservation = length;
        reservedTable = table;
        specialRequest = request;
    }
}
