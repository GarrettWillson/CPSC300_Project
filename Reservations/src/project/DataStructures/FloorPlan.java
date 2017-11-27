/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    /*returns the table object corresponding to the passed table number*/
    public Table getTable(int tableNumber) {
        for (Pair<Integer, Integer> p : floorplan.keySet()) {
            Table t = floorplan.get(p);
            if (t.getTableNumber() == tableNumber) {
                return t;
            }
        }
        return null;
    }

    /*returns the table object corresponding to the passed location*/
    public Table getTable(Pair<Integer, Integer> location) {
        return floorplan.get(location);
    }

    /*adds a new table at the specified location*/
    public void addTable(Table table, Integer x, Integer y) {
        floorplan.put(new ImmutablePair<>(x, y), table);
    }

    /*removes the passed table*/
    public void deleteTable(Table table) {
        for (Pair<Integer, Integer> p : floorplan.keySet()) {
            if (floorplan.get(p).equals(table)) {
                floorplan.remove(p, table);
            }
        }
    }

    /*removes the table corresponding to the passed location*/
    public void deleteTable(int x, int y) {
        for (Pair<Integer, Integer> p : floorplan.keySet()) {
            if (p.getKey() == x && p.getValue() == y) {
                floorplan.remove(p);
                return;
            }
        }
    }

    /*erases the entire floorplan*/
    public void clear() {
        floorplan.clear();
    }

    /*sets the floorplan to be the one the map passed in*/
    public void setFloorPlan(Map<Pair<Integer, Integer>, Table> plan) {
        floorplan = plan;
    }

    /*returns the floorplan*/
    public Map<Pair<Integer, Integer>, Table> getFloorPlan() {
        return floorplan;
    }
}
