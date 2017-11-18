/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.FileIO;

import java.io.*;
import java.nio.file.Paths;
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
    static FileWriter reservationWriter;
    static FileReader reservationReader;
    static FileWriter floorPlanWriter;
    static FileReader floorPlanReader;
    static FileWriter employeeWriter;
    static FileReader employeeReader;
    
    public static void saveReservation(String restaurant, String name, String number, int custResNum, String date, String duration, String table, String request) throws IOException {
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
    
    public static List<Pair<String, String>> loadEmployees(String Restaurant) throws FileNotFoundException {
        String pathName = Paths.get("").toAbsolutePath().toString();
        String filePath = pathName + "/" + Restaurant + "/employee/employees.txt";
        String line;
        File f = new File(filePath);
        List<Pair<String, String>> lst = new ArrayList();
        employeeReader = new FileReader(f);
        BufferedReader br= new BufferedReader(employeeReader); 
        try {
            while((line = br.readLine()) != null){
                String[] splited = line.split(" ");
                Pair p =  new Pair(splited[0], splited[1]);
                lst.add(p);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}
