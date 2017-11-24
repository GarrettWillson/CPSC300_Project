/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public abstract class DataLists {
    static List<Reservation> reservations = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static FloorPlan floorPlan = new FloorPlan();
    
    static {
        floorPlan.addTable(new Table(1, 4), 1, 1);
        floorPlan.addTable(new Table(2, 4), 2, 1);
        floorPlan.addTable(new Table(3, 4), 3, 1);
        floorPlan.addTable(new Table(4, 4), 1, 2);
        floorPlan.addTable(new Table(5, 4), 2, 2);
        floorPlan.addTable(new Table(6, 4), 3, 2);
    }

    /*checks for if the information passed either matches that of an
        employee in the database, or the predefined admin account*/
    public static boolean isValidEmployee(String name, String pass) {
        if(name.equals("admin") && pass.equals("password")) {
            return true;
        }
        for(Employee e : employees) {
            if(e.getUserName().equals(name) && e.isCorrectPassword(pass)) {
                return true;
            }
        }
        return false;
    }
    
    /*returns a list of all reservations that exist for a specific table*/
    public static List<Reservation> getReservationsForTable(int tableNum) {
        List<Reservation> res = new ArrayList<>();
        for(Reservation r : reservations) {
            if(r.getReservedTable().getTableNumber() == tableNum) {
                res.add(r);
            }
        }
        return res;
    }
    
    /*checks to see if there is an existing reservation for the specified
        table during the specified time, on the specified date*/
    public static boolean hasTimeConflict(Date date, int startTime, int duration, int tableNumber) {
        for(Reservation r : getReservationsForTable(tableNumber)) {
            if(r.getReservationDate().equals(date)) {
                if(r.getStartHour() < startTime + duration && startTime < r.getStartHour() + r.getLengthOfReservation()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**/
    public static int getNextCustResNum(String name, String number) {
        List<Integer> used = new ArrayList<>();
        for(Reservation r : reservations) {
            if(r.getCustomerName().equals(name) && r.getCustomerNumber().equals(number)) {
                used.add(r.getCustomerReservationNumber());
            }
        }
        int next = 1;
        while(used.contains(next)) {
            next++;
        }
        return next;
    }
    
    public static Reservation addReservation(String name, String number, Date date, int startTime, int duration, int tableNumber, String request) {
        return addReservation(name, number, getNextCustResNum(name, number), date, startTime, duration, tableNumber, request);
    }
    
    public static Reservation addReservation(String name, String number, int custResNum, Date date, int startTime, int duration, int tableNumber, String request) {
        Reservation r = new Reservation(name, number, custResNum, date, startTime, duration, floorPlan.getTable(tableNumber), request);
        reservations.add(r);
        return r;
    }
    
    public static Employee addEmployee(String name, String pass, String restaurant) {
        Employee e = new Employee(name, pass, restaurant);
        employees.add(e);
        return e;
    }
    
    public static void deleteReservation(Reservation r) {
        reservations.remove(r);
    }
    
    public static void deleteEmployee(Employee e) {
        employees.remove(e);
    }
    
    public static List<Reservation> getReservations() {
        return reservations;
    }
    
    public static List<Employee> getEmployees() {
        return employees;
    }
    
    public static void setFloorplan(FloorPlan fp) {
        floorPlan = fp;
    }
    
    public static FloorPlan getFloorPlan() {
        return floorPlan;
    }
    
    public static List<Table> getTables() {
        List<Table> tables = new ArrayList<>(floorPlan.getFloorPlan().values());
        Collections.sort(tables);
        return tables;
    }
}
