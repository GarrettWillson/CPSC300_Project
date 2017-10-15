/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

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
    
    public void saveReservation(Reservation reservation) {
        
    }
    
    public List<Reservation> loadReservations() {
        return new ArrayList<>();
    }
    
    public void saveFloorPlan(FloorPlan floorPlan) {
        
    }
    
    public FloorPlan loadFloorPlan() {
        return null;
    }
}
