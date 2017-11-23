/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.util.ArrayList;
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
    static FloorPlan floorPlan;
    
    static{
        reservations.add(new Reservation("Bob", "250-123-4567", 0, new Date(2017-1900, 11-1, 20), 17, 3, new Table(1, 2), ""));
        reservations.add(new Reservation("Bill", "250-420-6969", 0, new Date(2017-1900, 11-1, 20), 14, 2, new Table(2, 2), ""));
        reservations.add(new Reservation("Jack", "250-777-7777", 0, new Date(2017-1900, 11-1, 20), 17, 2, new Table(2, 2), ""));
        reservations.add(new Reservation("Jill", "250-777-7777", 0, new Date(2017-1900, 11-1, 20), 9, 3, new Table(1, 2), ""));
        reservations.add(new Reservation("Bob", "250-123-4567", 0, new Date(2017-1900, 11-1, 20), 13, 3, new Table(1, 2), ""));
    }

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
    
    public static List<Reservation> getReservationsForTable(int tableNum) {
        List<Reservation> res = new ArrayList<>();
        for(Reservation r : reservations) {
            if(r.getReservedTable().getTableNumber() == tableNum) {
                res.add(r);
            }
        }
        return res;
    }
    
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
        Reservation r = new Reservation(name, number, getNextCustResNum(name, number), date, startTime, duration, floorPlan.getTable(tableNumber), request);
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
    
    public static void setFloorplan(FloorPlan fp) {
        floorPlan = fp;
    }
    
    public static FloorPlan getFloorPlan() {
        return floorPlan;
    }
    
    public List<Table> getTables() {
        return new ArrayList<>(floorPlan.getFloorPlan().values());
    }
}
