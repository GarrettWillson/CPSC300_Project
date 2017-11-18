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
    static FloorPlan floorPlan;

    public static boolean isValidEmployee(String name, String pass) {
        for(Employee e : employees) {
            if(e.getUserName().equals(name) && e.isCorrectPassword(pass)) {
                return true;
            }
        }
        return false;
    }
    
    public static List<Reservation> getReservationsForTable(Table t) {
        List<Reservation> res = new ArrayList<>();
        for(Reservation r : reservations) {
            if(r.getReservedTable().equals(t)) {
                res.add(r);
            }
        }
        return res;
    }
    
    public static void addReservation(String name, String number,int custResNum, String date, int duration, int tableNumber, String request) {
        reservations.add(new Reservation(name, number, custResNum, Date.valueOf(date), duration, FloorPlan.getTable(tableNumber), request));
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
