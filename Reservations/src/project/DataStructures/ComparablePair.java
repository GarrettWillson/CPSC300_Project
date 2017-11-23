/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.DataStructures;

import javafx.util.Pair;

/**
 *
 * @author fontai1
 */
public class ComparablePair<K extends Comparable ,V extends Comparable> extends Pair<K,V> implements Comparable{

    public ComparablePair(K k, V v) {
        super(k, v);  
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) {
            throw new NullPointerException();
        }
        if(o instanceof ComparablePair) {
            ComparablePair other = (ComparablePair)o;
            int ret = getKey().compareTo(other.getKey());
            if(ret == 0) {
                ret = getValue().compareTo(other.getValue());
            }
            return ret;
        } else {
            throw new ClassCastException();
        }
    }
}
