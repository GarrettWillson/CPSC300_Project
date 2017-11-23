/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
http://www.java2s.com/Code/Jar/c/Downloadcommonslang3301jar.htm
 */

package project.DataStructures;

import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.tuple.*;

/**
 *
 * @author fontai1
 */
public class FloorPlan {
    Map<Pair<Integer, Integer>, Table> floorplan = new TreeMap<>();
    
    public FloorPlan() {
        
    }
    
    public Table getTable(int tableNumber) {
        for(Pair<Integer, Integer> p : floorplan.keySet()) {
            Table t = floorplan.get(p);
            if(t.getTableNumber() == tableNumber) {
                return t;
            }
        }
        return null;
    }
    
    public void addTable(Table table, Integer x, Integer y) {
        floorplan.put(new ImmutablePair<>(x, y), table);
    }
    
    public void deleteTable(Table table) {
        for(Pair<Integer, Integer> p : floorplan.keySet()) {
            if(floorplan.get(p).equals(table)) {
                floorplan.remove(p, table);
            }
        }
    }
    
    public void deleteTable(int x, int y) {
        for(Pair<Integer, Integer> p : floorplan.keySet()) {
            if(p.getKey() == x && p.getValue() == y) {
                floorplan.remove(p);
                return;
            }
        }
    }
    
    public void clear() {
        floorplan.clear();
    }
    
    public void setFloorPlan(Map<Pair<Integer, Integer>, Table> plan) {
        floorplan = plan;
    }
    
    public Map<Pair<Integer, Integer>, Table> getFloorPlan() {
        return floorplan;
    }
}
