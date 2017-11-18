/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import project.FileIO.FileIOInterface;
import project.GUI.EmployeeLogin;
import static project.GUI.Login.createLogin;

/**
 *
 * @authors fontia1, willsong, jiangtau, rui
 */
public class Startup {
    static String restaurantName = "A";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        FileIOInterface.loadFloorPlan(restaurantName);
        FileIOInterface.loadEmployees(restaurantName);
        FileIOInterface.loadReservations(restaurantName);
        createLogin();
        // TODO code application logic here
       // LoginWindow.makeNewWindow();
    }
    
    public static String getRestaurantName() {
        return restaurantName;
    }
}
