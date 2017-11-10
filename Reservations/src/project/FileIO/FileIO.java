/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public static void saveFloorPlan(List<List<Integer>> floorplan, String restaurant) {
        
    }
    
    public static List<List<Integer>> loadFloorPlan(String restaurant) {
        List<List<Integer>> list = new ArrayList<>();
        for(Integer[] i : new Integer[][]{
            {1, 1, 1, 4},
            {2, 1, 2, 4},
            {3, 1, 3, 4},
            {1, 2, 4, 4},
            {2, 2, 5, 4},
            {2, 3, 6, 4},
            {3, 1, 7, 4},
            {3, 2, 8, 4},
            {3, 3, 9, 4}}) {
            list.add(Arrays.asList(i));
        }
        return list;
    }
    
    public static void saveEmployee(String restaurant, String name, String password) {
        
    }
    
    public static List<Pair<String, String>> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
