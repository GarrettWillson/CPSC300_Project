/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.tuple.Pair;
import project.DataStructures.DataLists;
import project.DataStructures.FloorPlan;
import project.DataStructures.Reservation;
import project.DataStructures.Table;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public class FileIOInterface {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

    public static void saveReservation(String restaurant, Reservation reservation) {
        try {
            FileIO.saveReservation(
                    restaurant,
                    reservation.getCustomerName(),
                    reservation.getCustomerNumber(),
                    String.valueOf(reservation.getCustomerReservationNumber()),
                    dateFormat.format(reservation.getReservationDate()),
                    String.valueOf(reservation.getStartHour()),
                    String.valueOf(reservation.getLengthOfReservation()),
                    String.valueOf(reservation.getReservedTable().getTableNumber()),
                    reservation.getSpecialRequest());
        } catch (IOException ex) {
            Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadReservations(String restaurant) {
        List<List<String>> reservationsStrings = FileIO.loadReservations(restaurant);
        for (List<String> reservationString : reservationsStrings) {
            try {
                //skip 0 because that's the restaurant's name
                int i = 1;
                DataLists.addReservation(reservationString.get(i++),
                        reservationString.get(i++),
                        Integer.parseInt(reservationString.get(i++)),
                        dateFormat.parse(reservationString.get(i++)),
                        Integer.parseInt(reservationString.get(i++)),
                        Integer.parseInt(reservationString.get(i++)),
                        Integer.parseInt(reservationString.get(i++)),
                        reservationString.get(i++));
            } catch (ParseException ex) {
                Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void saveEmployee(String restaurant, Employee employee) {
        try {
            FileIO.saveEmployee(restaurant,
                    employee.getUserName(),
                    employee.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadEmployees(String restaurant) {
        try {
            List<Pair<String, String>> employeeStrings = FileIO.loadEmployees(restaurant);
            for (Pair<String, String> employeeString : employeeStrings) {
                DataLists.addEmployee(employeeString.getKey(),
                        employeeString.getValue(),
                        restaurant);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveFloorPlan(String restaurant, FloorPlan floorPlan) {
        List<List<Integer>> list = new ArrayList<>();
        for (Pair<Integer, Integer> location : floorPlan.getFloorPlan().keySet()) {
            Table t = floorPlan.getTable(location);
            List<Integer> inner = new ArrayList<>();
            inner.add(location.getKey());
            inner.add(location.getValue());
            inner.add(t.getTableNumber());
            inner.add(t.getNumberOfSeats());
            list.add(inner);
        }
        FileIO.saveFloorPlan(list, restaurant);
    }

    public static void loadFloorPlan(String restaurant) {
        List<List<Integer>> plan = FileIO.loadFloorPlan(restaurant);
        if(plan.isEmpty()) {
            List<List<Integer>> defPlan = new ArrayList<>();
            defPlan.add(Arrays.asList(new Integer[]{1,1,1,4}));
            defPlan.add(Arrays.asList(new Integer[]{1,2,2,4}));
            defPlan.add(Arrays.asList(new Integer[]{2,1,3,4}));
            defPlan.add(Arrays.asList(new Integer[]{2,2,4,4}));
            defPlan.add(Arrays.asList(new Integer[]{3,1,5,4}));
            defPlan.add(Arrays.asList(new Integer[]{3,2,6,4}));
            FileIO.saveFloorPlan(defPlan, restaurant);
            plan = FileIO.loadFloorPlan(restaurant);
        }
        for (List<Integer> list : plan) {
            DataLists.getFloorPlan().addTable(new Table(list.get(2), list.get(3)), list.get(0), list.get(1));
        }
    }

    public static boolean deleteEmployee(String restaurantName, String name) {
        FileIO.deleteEmployee(restaurantName, name);
        for(Employee e : DataLists.getEmployees()) {
            if(e.getUserName().equals(name)) {
                DataLists.deleteEmployee(e);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteReservation(String restaurantName, String name, String phoneNum,  String date, String startTime, String tableNum) {
        for(Reservation r : DataLists.getReservationsForCustomer(name, phoneNum)) {
            if(dateFormat.format(r.getReservationDate()).equals(date)
                    && r.getStartHour() == Integer.parseInt(startTime)
                    && r.getReservedTable().getTableNumber() == Integer.parseInt(tableNum)) {
                DataLists.deleteReservation(r);
                FileIO.deleteReservation(restaurantName, name, phoneNum, String.valueOf(r.getCustomerReservationNumber()));
                return true;
            }
        }
        return false;
    }
}
