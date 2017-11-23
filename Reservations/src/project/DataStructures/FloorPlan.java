/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author fontai1
 */
public class FloorPlan {
    Map<ComparablePair<Integer, Integer>, Table> floorplan = new TreeMap<>();
    
    public FloorPlan() {
        
    }
    
    public Table getTable(int tableNumber) {
        for(ComparablePair<Integer, Integer> p : floorplan.keySet()) {
            Table t = floorplan.get(p);
            if(t.getTableNumber() == tableNumber) {
                return t;
            }
        }
        return null;
    }
    
    public void addTable(Table table, int x, int y) {
        floorplan.put(new ComparablePair<>(x, y), table);
    }
    
    public void deleteTable(Table table) {
        for(ComparablePair<Integer, Integer> p : floorplan.keySet()) {
            if(floorplan.get(p).equals(table)) {
                floorplan.remove(p, table);
            }
        }
    }
    
    public void deleteTable(int x, int y) {
        for(ComparablePair<Integer, Integer> p : floorplan.keySet()) {
            if(p.getKey() == x && p.getValue() == y) {
                floorplan.remove(p);
                return;
            }
        }
    }
    
    public void clear() {
        floorplan.clear();
    }
    
    public void setFloorPlan(Map<ComparablePair<Integer, Integer>, Table> plan) {
        floorplan = plan;
    }
    
    public Map<ComparablePair<Integer, Integer>, Table> getFloorPlan() {
        return floorplan;
    }
}
