/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.io.*;
import java.nio.file.Paths;
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
    static FileWriter reservationWriter;
    static FileReader reservationReader;
    static FileWriter floorPlanWriter;
    static FileReader floorPlanReader;
    static FileWriter employeeWriter;
    static FileReader employeeReader;
    
    public static void saveReservation(String restaurant, String name, String number, String date, String duration, String table, String request) throws IOException {
        String fileName = name + number;
    	String pathName = Paths.get("").toAbsolutePath().toString();
    	
        String resFpath = pathName + "/" + restaurant;
        String userFpath;
        String userFile;
    	File resF = new File(resFpath);
    	if(resF.exists()){
    		userFpath = resFpath + "/reservation/" + fileName;
    	}else{
    		resF.mkdir();
                userFpath = resFpath + "/reservation/" + fileName;
    	}
    	
    	File userF = new File(userFpath);
    	if(userF.exists()){
    		userFile = userFpath + "/" + fileName;
    	}else{
    		userF.mkdirs();
                userFile = userFpath + "/" + fileName;
    	}
    	
    	File f = new File(userFile + "1.txt");
    	if(f.exists()){
    		int num = new File(userFpath).listFiles().length;
                f = new File(userFile + String.valueOf(num+1) + ".txt");
                f.createNewFile();
    	}else{
    		f.createNewFile();
    	}
    	
    	reservationWriter = new FileWriter(f);
    	BufferedWriter bw = new BufferedWriter(reservationWriter);
    	
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
    
    public static void saveEmployee(String restaurant, String name, String password) throws FileNotFoundException, IOException {
        String pathName = Paths.get("").toAbsolutePath().toString();
        String resFpath = pathName + "/" + restaurant;
        String filePath;
        String empFpath;
        
        File resF = new File(resFpath);
        if(resF.exists()){
            filePath = resFpath + "/employee";
        }else{
            resF.mkdir();
            filePath = resFpath + "/employee";
        }
        
        File empF = new File(filePath);
        if(empF.exists()){
            empFpath = filePath + "/employees.txt"; 
        }else{
            empF.mkdir();
            empFpath = filePath + "/employees.txt";
        }
        
        File emp = new File(empFpath);
        
        RandomAccessFile raf = new RandomAccessFile(emp,"rw");
        raf.seek(raf.length());
        raf.writeBytes(name + " " + password);
        raf.writeBytes("\r\n");
        
        raf.close();
        
    }
    
    public static List<Pair<String, String>> loadEmployees(String Restaurant) {
        return new ArrayList<>();
    }
}
