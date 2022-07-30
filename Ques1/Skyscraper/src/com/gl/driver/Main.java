package com.gl.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building ");
		int noOfFloors = sc.nextInt();

		// if n is the total no. of floors, then n is the max size.
		Map<Integer, Integer> floorMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < noOfFloors; i++) {
			System.out.println("Enter the floor size given on day : " + (i + 1));// size distinct across the day

			int floorSize = sc.nextInt();
			floorMap.put((i + 1), floorSize);// day,floor size

		}

		System.out.println("The order of construction is as follows");
		identifyFloorsForEachDay(floorMap);

	}

	private static void identifyFloorsForEachDay(Map<Integer, Integer> floorMap) {
		int totalFloors = floorMap.size();
		int floorsPending = totalFloors;
		Iterator<Integer> it = floorMap.keySet().iterator();

		ArrayList<Integer> floorConst = new ArrayList<Integer>();

		while (it.hasNext()) {
			int day = (int) it.next();
			System.out.println("Day : " + day);

			int size = (int) floorMap.get(day);
			if (floorsPending == size) {
				System.out.print(size);
				floorsPending--;
				if (floorConst.size() > 0) {
					Collections.sort(floorConst);
					for (Integer flr : floorConst) {
						System.out.print(",");
						System.out.print(flr);
						floorsPending--;
					}
					floorConst.clear();
				}
				
			} else {
				floorConst.add(size);
				System.out.println();
			}
			System.out.println();
		}

	}

}
