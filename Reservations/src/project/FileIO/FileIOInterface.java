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
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.tuple.MutablePair;
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
    public static void saveReservation(String restaurant, Reservation reservation) {  
        try {
            FileIO.saveReservation(
                    restaurant,
                    reservation.getCustomerName(),
                    reservation.getCustomerNumber(),
                    String.valueOf(reservation.getCustomerReservationNumber()),
                    new SimpleDateFormat("dd MMM yyyy").format(reservation.getReservationDate()),
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
        for(List<String> reservationString : reservationsStrings) {
            try {
                //skip 0 because that's the restaurant's name
                int i = 1;
                DataLists.addReservation(reservationString.get(i++),
                        reservationString.get(i++),
                        Integer.parseInt(reservationString.get(i++)),
                        new SimpleDateFormat("dd MMM yyyy").parse(reservationString.get(i++)),
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
            for(Pair<String, String> employeeString : employeeStrings) {
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
        for(Integer[] i : new Integer[][]{
            {1, 1, 1, 4},
            {1, 2, 2, 4},
            {2, 1, 3, 4},
            {2, 2, 4, 4}}) {
            list.add(Arrays.asList(i));
        };
        FileIO.saveFloorPlan(list, restaurant);
    }
    
    public static void loadFloorPlan(String restaurant) {
        Map<Pair<Integer, Integer>, Table> map = new TreeMap<>(); 
        for(List<Integer> list : FileIO.loadFloorPlan(restaurant)) {
            map.put(new MutablePair<>(list.get(0), list.get(1)), new Table(list.get(2), list.get(3)));
        }
    }
}
