/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import project.DataStructures.FloorPlan;
import project.DataStructures.Reservation;
import project.Users.Employee;

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
    
    public static void saveReservation(String restaurant, String name, String number, String date, String duration, String table, String request) {
        
    }
    
    public static List<List<String>> loadReservations(String restaurant) {
        return new ArrayList<>();
    }
    
    public static void saveFloorPlan(FloorPlan floorPlan, String restaurant) {
        
    }
    
    public static FloorPlan loadFloorPlan(String restaurant) {
        return null;
    }
    
    public static void saveEmployee(String name, String password) {
        
    }
    
    public static List<Pair<String, String>> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
