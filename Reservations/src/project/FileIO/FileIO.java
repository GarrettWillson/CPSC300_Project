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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void saveReservation(String restaurant, String name, String number, String custResNum, String date, String startTime, String duration, String table, String request) throws IOException {
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
        bw.write(startTime);
        bw.newLine();
    	bw.write(duration);
    	bw.newLine();
    	bw.write(table);
    	bw.newLine();
    	bw.write(request);
        
    	bw.close();
    }
    
    public static List<List<String>> loadReservations(String restaurant) {
      
        String pathName = Paths.get("").toAbsolutePath().toString();
        String folderPath = pathName + "/" + restaurant + "/reservation/";
        File resFolder = new File(folderPath);
        File[] listOfFolders = resFolder.listFiles();
        String component;
        List<List<String>> llst = new ArrayList();
        for(int i = 0; i < listOfFolders.length; i++){
            String filePath = folderPath + listOfFolders[i].getName() + "/";
            File cusFolder = new File(filePath);
            File[] listOfFiles = cusFolder.listFiles();
            for(int j = 0; j < listOfFiles.length; j++){
                List<String> lst = new ArrayList();
                String fileName = filePath + listOfFiles[j].getName();
                File f = new File(fileName);
                try {
                    reservationReader = new FileReader(f);
                    BufferedReader br = new BufferedReader(reservationReader);
                    while((component = br.readLine()) != null){
                        lst.add(component);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
                }
                llst.add(lst);
            }
            
        }
        
        return llst;
    }
    
    public static void saveFloorPlan(List<List<Integer>> floorplan, String restaurant) {
        String pathName = Paths.get("").toAbsolutePath().toString();
        String resFpath = pathName + "/" + restaurant;
        String filePath;
        String planPath;
        
        File resF = new File(resFpath);
        if(resF.exists()){
            filePath = resFpath + "/floorplan";
        }else{
            resF.mkdir();
            filePath = resFpath + "/floorplan";
        }
        
        File planF = new File(filePath);
        if(planF.exists()){
            planPath = filePath + "/floorplans.txt";
        }else{
            planF.mkdir();
            planPath = filePath + "/floorplans.txt";
        }
        
        File planFile = new File(planPath);
        try {
            floorPlanWriter = new FileWriter(planFile);
            BufferedWriter bw = new BufferedWriter(floorPlanWriter);
            for(List<Integer> i : floorplan){
                bw.write(i.toString());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<List<Integer>> loadFloorPlan(String restaurant) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lst = new ArrayList();
        String pathName = Paths.get("").toAbsolutePath().toString();
        String planPath = pathName + "/" + restaurant + "/floorplan/floorplans.txt";
        String line;
        File planFile = new File(planPath);
        try {
            floorPlanReader = new FileReader(planFile);
            BufferedReader br = new BufferedReader(floorPlanReader);
            while((line = br.readLine()) != null){
                String[] cols = line.split(" ");
                for(String c : cols){
                    lst.add(Integer.parseInt(c));
                }
                list.add(lst);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
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
