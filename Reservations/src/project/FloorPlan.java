/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author fontai1
 */
public class FloorPlan {
    Map<Table, Pair<Integer, Integer>> floorplan;
    
    public FloorPlan(Map<Table, Pair<Integer, Integer>> plan) {
        floorplan = plan;
    }
    
    public void addTable(Table table, int x, int y) {
        
    }
    
    public void deleteTable(Table table) {
        
    }
    
    public void deleteTable(int x, int y) {
        
    }
    
    public void clear() {
        floorplan.clear();
    }
    
    public void setFloorPlan(Map<Table, Pair<Integer, Integer>> plan) {
        floorplan = plan;
    }
    
    public Map<Table, Pair<Integer, Integer>> getFloorPlan() {
        return floorplan;
    }
}
