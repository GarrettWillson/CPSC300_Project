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
import project.FileIO.FileIOInterface;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public abstract class DataLists {

    static List<Reservation> reservations = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static FloorPlan floorPlan = new FloorPlan();

    /*checks for if the information passed either matches that of an
     employee in the database, or the predefined admin account*/
    public static boolean isValidEmployee(String name, String pass) {
        if (name.equals("admin") && pass.equals("password")) {
            return true;
        }
        for (Employee e : employees) {
            if (e.getUserName().equals(name) && e.isCorrectPassword(pass)) {
                return true;
            }
        }
        return false;
    }

    /*returns whether or not the given user name is already in
     use for an employee (used when making new employees)*/
    public static boolean userNameTaken(String name) {
        if(name.equals("admin")) {
            return true;
        }
        for (Employee e : employees) {
            if (e.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*returns a list of all reservations that exist for a specific table*/
    public static List<Reservation> getReservationsForTable(int tableNum) {
        List<Reservation> res = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getReservedTable().getTableNumber() == tableNum) {
                res.add(r);
            }
        }
        return res;
    }

    /*returns a list of all reservations that exist for a specific customer*/
    public static List<Reservation> getReservationsForCustomer(String name, String number) {
        List<Reservation> res = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCustomerName().equals(name) && r.getCustomerNumber().equals(number)) {
                res.add(r);
            }
        }
        return res;
    }

    /*returns a list of all reservations that exist for a specific date*/
    public static List<Reservation> getReservationsForDate(Date date) {
        List<Reservation> res = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getReservationDate().equals(date)) {
                res.add(r);
            }
        }
        return res;
    }

    /*checks to see if there is an existing reservation for the specified
     table during the specified time, on the specified date*/
    public static boolean hasTimeConflict(Date date, int startTime, int duration, int tableNumber) {
        for (Reservation r : getReservationsForTable(tableNumber)) {
            if (FileIOInterface.dateFormat.format(r.getReservationDate()).equals(FileIOInterface.dateFormat.format(date))) {
                if (r.getStartHour() < startTime + duration && startTime < r.getStartHour() + r.getLengthOfReservation()) {
                    return true;
                }
            }
        }
        return false;
    }

    /*gets the lowest positive integer that is currently unused for differentiating
     between multiple reservations for the same customer*/
    public static int getNextCustResNum(String name, String number) {
        List<Integer> used = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCustomerName().equals(name) && r.getCustomerNumber().equals(number)) {
                used.add(r.getCustomerReservationNumber());
            }
        }
        int next = 1;
        while (used.contains(next)) {
            next++;
        }
        return next;
    }

    /*adds a new reservation with the lowest available reservation number*/
    public static Reservation addReservation(String name, String number, Date date, int startTime, int duration, int tableNumber, String request) {
        return addReservation(name, number, getNextCustResNum(name, number), date, startTime, duration, tableNumber, request);
    }

    /*adds a reservation with a specified reservation number (typically for
     modification purposes)*/
    public static Reservation addReservation(String name, String number, int custResNum, Date date, int startTime, int duration, int tableNumber, String request) {
        Reservation r = new Reservation(name, number, custResNum, date, startTime, duration, floorPlan.getTable(tableNumber), request);
        reservations.add(r);
        return r;
    }

    /*adds a new employee*/
    public static Employee addEmployee(String name, String pass, String restaurant) {
        Employee e = new Employee(name, pass, restaurant);
        employees.add(e);
        return e;
    }

    /*deletes a reservation*/
    public static void deleteReservation(Reservation r) {
        reservations.remove(r);
    }

    /*deletes an employee*/
    public static void deleteEmployee(Employee e) {
        employees.remove(e);
    }

    /*returns the list of all reservations*/
    public static List<Reservation> getReservations() {
        return reservations;
    }

    /*returns the list of all employees*/
    public static List<Employee> getEmployees() {
        return employees;
    }

    /*sets the floorplan to the one passed*/
    public static void setFloorplan(FloorPlan fp) {
        floorPlan = fp;
    }

    /*returns the floorplan itself*/
    public static FloorPlan getFloorPlan() {
        return floorPlan;
    }

    /*returns a list of all tables in the floorplan*/
    public static List<Table> getTables() {
        List<Table> tables = new ArrayList<>(floorPlan.getFloorPlan().values());
        Collections.sort(tables);
        return tables;
    }

    /*checks if the password passed matches the correct format
    returns 0 if it does,
    1 if it's too short,
    2 if it's missing either upper or lowercase letters,
    and 3 if it's missing a number*/
    public static int isValidPassword(String password) {
        if(password.length() < 5) {
            return 1;
        }
        if(password.equals(password.toUpperCase()) || password.equals(password.toLowerCase())) {
            return 2;
        }
        if(!password.matches(".*\\d+.*")) {
            return 3;
        }
        return 0;
    }
}
