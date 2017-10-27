/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public class DataLists {
    static List<Reservation> reservations = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();

    public static boolean isValidEmployee(String name, String pass) {
        for(Employee e : employees) {
            if(e.getUserName().equals(name) && e.isCorrectPassword(pass)) {
                return true;
            }
        }
        return false;
    }
    
    public static void addReservation(String name, String number, String date, int duration, int tableNumber, String request) {
        reservations.add(new Reservation(name, number, Date.valueOf(date), duration, FloorPlan.getTable(tableNumber), request));
    }
}
