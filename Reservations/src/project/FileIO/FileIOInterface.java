/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.util.ArrayList;
import java.util.List;
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
    
    public List<Reservation> loadReservations(String restaurant) {
        return new ArrayList<>();
    }
    
    public void saveEmployee(Employee employee) {
        
    }
    
    public List<Employee> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
