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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
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
    public void saveReservation(String restaurant, Reservation reservation) {  
        try {
            FileIO.saveReservation(
                    restaurant,
                    reservation.getCustomerName(),
                    reservation.getCustomerNumber(),
                    String.valueOf(reservation.getCustomerReservationNumber()),
                    reservation.getReservationDate().toString(),
                    String.valueOf(reservation.getStartHour()),
                    String.valueOf(reservation.getLengthOfReservation()),
                    String.valueOf(reservation.getReservedTable().getTableNumber()),
                    reservation.getSpecialRequest());
        } catch (IOException ex) {
            Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadReservations(String restaurant) {
        List<List<String>> reservationsStrings = FileIO.loadReservations(restaurant);
        for(List<String> reservationString : reservationsStrings) {
            try {
                DataLists.addReservation(reservationString.get(0),
                        reservationString.get(1),
                        Integer.parseInt(reservationString.get(2)),
                        new SimpleDateFormat("dd MMM yyyy").parse(reservationString.get(3)),
                        Integer.parseInt(reservationString.get(4)),
                        Integer.parseInt(reservationString.get(5)),
                        Integer.parseInt(reservationString.get(6)),
                        reservationString.get(7));
            } catch (ParseException ex) {
                Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void saveEmployee(String restaurant, Employee employee) {
        try {
            FileIO.saveEmployee(restaurant,
                    employee.getUserName(),
                    employee.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(FileIOInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadEmployees(String restaurant) {
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
        FileIO.saveFloorPlan(null, restaurant);
    }
    
    public static void loadFloorPlan(String restaurant) {
        Map<Pair<Integer, Integer>, Table> map = new TreeMap<>(); 
        for(List<Integer> list : FileIO.loadFloorPlan(restaurant)) {
            map.put(new Pair<>(list.get(0), list.get(1)), new Table(list.get(2), list.get(3)));
        }
    }
}
