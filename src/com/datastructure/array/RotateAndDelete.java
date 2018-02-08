package com.datastructure.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateAndDelete {
	
	public static int rotateAndDelete(int[] arr) {
		List<Integer> tempList = new ArrayList<Integer>();
		int count = 1;
		for(int i = 0; i < arr.length; i++) {
			tempList.add(arr[i]);
		}
		while(tempList.size() != 1) {
			int[] tempArray = new int[tempList.size()];
			for(int j = 0; j < tempList.size(); j++) {
				tempArray[j] = tempList.get(computeModulo(j-1, tempList.size()));
			}
			tempList.clear();
			for(int k = 0; k < tempArray.length; k++) {
				tempList.add(tempArray[k]);
			}
			if(tempList.size() - count < 0) {
				tempList.remove(0);
			}
			else {
				tempList.remove(tempList.size() - count);
			}
			count++;
		}
		return tempList.get(0);
	}
	
	public static int computeModulo(int i, int j) {
		if(i < 0) {
			while(i < 0) {
				i += j;
			}
			return i;
		}
		else {
			return i % j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfInputs = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numberOfInputs; i++) {
			int numberOfArrayItems = sc.nextInt();
			int[] arr = new int[numberOfArrayItems];
			sc.nextLine();
			String str = sc.nextLine();
			String[] strArr = str.split(" "); 
			for(int j = 0; j < numberOfArrayItems; j++) {
				arr[j] = Integer.parseInt(strArr[j]);
			}
			if(i != numberOfInputs - 1){
			    sb.append(rotateAndDelete(arr)+"\n");
			}
			else{
			    sb.append(rotateAndDelete(arr));
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
}
