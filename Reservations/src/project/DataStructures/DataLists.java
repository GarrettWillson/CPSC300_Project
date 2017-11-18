/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public abstract class DataLists {
    static List<Reservation> reservations = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static FloorPlan floorPlan;
    
    static{
        reservations.add(new Reservation("Bob", "250-123-4567", 0, new Date(2017, 11, 20), 17, 3, new Table(1, 2), ""));
        reservations.add(new Reservation("Bill", "250-420-6969", 0, new Date(2017, 11, 20), 14, 2, new Table(2, 2), ""));
        reservations.add(new Reservation("Jack", "250-777-7777", 0, new Date(2017, 11, 20), 17, 2, new Table(2, 2), ""));
        reservations.add(new Reservation("Jill", "250-777-7777", 0, new Date(2017, 11, 20), 9, 3, new Table(1, 2), ""));
        reservations.add(new Reservation("Bob", "250-123-4567", 0, new Date(2017, 11, 20), 13, 3, new Table(1, 2), ""));
    }

    public static boolean isValidEmployee(String name, String pass) {
        for(Employee e : employees) {
            if(e.getUserName().equals(name) && e.isCorrectPassword(pass)) {
                return true;
            }
        }
        return false;
    }
    
    public static List<Reservation> getReservationsForTable(int tableNum) {
        List<Reservation> res = new ArrayList<>();
        for(Reservation r : reservations) {
            if(r.getReservedTable().getTableNumber() == tableNum) {
                res.add(r);
            }
        }
        return res;
    }
    
    public static void addReservation(String name, String number,int custResNum, Date date, int startTime, int duration, int tableNumber, String request) {
        reservations.add(new Reservation(name, number, custResNum, date, startTime, duration, floorPlan.getTable(tableNumber), request));
    }
    
    public static void addEmployee(String name, String pass, String restaurant) {
        employees.add(new Employee(name, pass, restaurant));
    }
    
    public static void setFloorplan(FloorPlan fp) {
        floorPlan = fp;
    }
    
    public static FloorPlan getFloorPlan() {
        return floorPlan;
    }
}
