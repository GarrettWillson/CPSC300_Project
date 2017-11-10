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
        String fileName = name + number;
    	String pathName = null;
    	String suffix = null;
    	
    	File resF = new File(pathName + "/" + restaurant);
    	if(resF.exists()){
    		pathName = null;
    	}else{
    		resF.mkdir();
    	}
    	
    	File userF = new File(pathName);
    	if(userF.exists()){
    		pathName = null;
    	}else{
    		userF.mkdir();
    	}
    	
    	File f = new File(pathName);
    	if(f.exists()){
    		f.createTempFile(null, suffix);
    	}else{
    		f.createNewFile();
    	}
    	
    	reservationWriter = new FileWriter(f);
    	BufferedWriter bw = new BufferedWrither(reservationWriter);
    	
    	bw.write(restaurant);
    	bw.newLine();
    	bw.write(name);
    	bw.newLine();
    	bw.write(number);
    	bw.newLine();
    	bw.write(date);
    	bw.newLine();
    	bw.write(duration);
    	bw.newLine();
    	bw.write(table);
    	bw.newLine();
    	bw.write(request);
    	bw.close();
    }
    
    public static List<List<String>> loadReservations(String restaurant) {
        return new ArrayList<>();
    }
    
    public static void saveFloorPlan(FloorPlan floorPlan, String restaurant) {
        
    }
    
    public static FloorPlan loadFloorPlan(String restaurant) {
        return null;
    }
    
    public static void saveEmployee(String restaurant, String name, String password) {
        
    }
    
    public static List<Pair<String, String>> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
