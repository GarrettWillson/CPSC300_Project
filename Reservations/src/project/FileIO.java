/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import project.Users.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fontai1
 */
public class FileIO {
    FileWriter reservationWriter;
    FileReader reservationReader;
    FileWriter floorPlanWriter;
    FileReader floorPlanReader;
    FileWriter employeeWriter;
    FileReader employeeReader;
    
    public void saveReservation(Reservation reservation, String restaurant) {
        
    }
    
    public List<Reservation> loadReservations(String restaurant) {
        return new ArrayList<>();
    }
    
    public void saveFloorPlan(FloorPlan floorPlan, String restaurant) {
        
    }
    
    public FloorPlan loadFloorPlan(String restaurant) {
        return null;
    }
    
    public void saveEmployee(Employee employee) {
        
    }
    
    public List<Employee> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
