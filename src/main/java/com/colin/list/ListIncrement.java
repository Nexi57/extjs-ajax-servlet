package com.colin.list;


import java.util.ArrayList;
import java.util.List;

/**
 *  Class which increment array elements by 1
 * @author colin.dassonville
 */
public class ListIncrement {
	
	private static List<Integer> randomList () {
		List <Integer> list1 = new ArrayList<Integer>();
		for(int i=0; i <9;i++) {
			double rand = Math.random() * 10_000;
			int randCasted = (int)(Math.floor(rand));
			list1.add(randCasted);
		}
		return list1;
	}
	
	public static List<Integer> incList(List<Integer> list) {
		List<Integer> newList = new ArrayList<Integer>();
		for(Integer element : list) {
			newList.add(element+1);
		}
		return newList;
	}
	public static List<Integer> incList() {
		return incList(randomList());
	}
	
}