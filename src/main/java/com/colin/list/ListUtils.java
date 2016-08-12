package com.colin.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Useful tools to manage lists
 * @author colin.dassonville
 */
public class ListUtils {
    /**
     * Create a List of Integer from a String
     * @param str the String to transform 
     * @return the List populated with Integer elements
     * @throws NumberFormatException if an array element is different from Integer type
     */
    public static List<Integer> arrayFromString(String str) throws NumberFormatException {
        String splitted [] = str.split(",");
        List <Integer> list = new ArrayList<Integer>();
        for(String s : splitted) {
            Integer i = Integer.valueOf(s.trim());
            list.add(i);
        }
        return list;
    }
    
    /**
     * Create a String from an Integer array
     * @param incremetentedList the array to transform
     * @return the string of the incremented array to display
     */
    public static String integerArrayToString(List<Integer> incremetentedList) {
        StringBuilder sb = new StringBuilder("[");
        for(Integer i : incremetentedList) {
            sb.append(Integer.toString(i) + " , ");
        }
        String test = sb.substring(0, sb.lastIndexOf(","));
        return test.concat("]");
    }
}
