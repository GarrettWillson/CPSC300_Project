/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author fontai1
 */
public class FloorPlan {
    static Map<Table, Pair<Integer, Integer>> floorplan = new HashMap<>();
    
    public FloorPlan(Map<Table, Pair<Integer, Integer>> plan) {
        floorplan = plan;
    }
    
    static Table getTable(int tableNumber) {
        for(Table t : floorplan.keySet()) {
            if(t.getTableNumber() == tableNumber) {
                return t;
            }
        }
        return null;
    }
    
    public void addTable(Table table, int x, int y) {
        floorplan.put(table, new Pair<>(x, y));
    }
    
    public void deleteTable(Table table) {
        floorplan.remove(table);
    }
    
    public void deleteTable(int x, int y) {
        for(Table t : floorplan.keySet()) {
            Pair<Integer, Integer> location = floorplan.get(t);
            if(location.getKey() == x && location.getValue() == y) {
                floorplan.remove(t);
                return;
            }
        }
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
