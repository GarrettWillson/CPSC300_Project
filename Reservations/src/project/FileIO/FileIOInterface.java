/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.util.List;
import javafx.util.Pair;
import project.DataStructures.DataLists;
import project.DataStructures.Reservation;
import project.Users.Employee;

/**
 *
 * @author fontai1
 */
public class FileIOInterface {
    public void saveReservation(Reservation reservation, String restaurant) {  
        FileIO.saveReservation(
                restaurant,
                reservation.getCustomerName(),
                reservation.getCustomerNumber(),
                reservation.getReservationDate().toString(),
                String.valueOf(reservation.getLengthOfReservation()),
                String.valueOf(reservation.getReservedTable().getTableNumber()),
                reservation.getSpecialRequest());
    }
    
    public void loadReservations(String restaurant) {
        List<List<String>> reservationsStrings = FileIO.loadReservations(restaurant);
        for(List<String> reservationString : reservationsStrings) {
           DataLists.addReservation(reservationString.get(0), reservationString.get(1), reservationString.get(2), Integer.parseInt(reservationString.get(3)), Integer.parseInt(reservationString.get(4)), reservationString.get(5));
        }
    }
    
    public void saveEmployee(String restaurant, Employee employee) {
        FileIO.saveEmployee(restaurant, employee.getUserName(), employee.getPassword());
    }
    
    public void loadEmployees(String Restaurant) {
        List<Pair<String, String>> employeeStrings = FileIO.loadEmployees(Restaurant);
        for(Pair<String, String> employeeString : employeeStrings) {
            DataLists.addEmployee(employeeString.getKey(), employeeString.getValue(), Restaurant);
        }
    }
}
