package com.datastructure.array;

import java.util.Scanner;

public class FindNumberInBitonicArray {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfTest = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numberOfTest; i++){
		    String inputString = sc.nextLine().trim();
		    String[] inputArr = inputString.split("\\s+");
		    int n = Integer.parseInt(inputArr[0]);
		    int k = Integer.parseInt(inputArr[1]);
		    int[] arr = new int[n];
		    String inputString1 = sc.nextLine().trim();
		    String[] inputArr1 = inputString1.split("\\s+");
		    for(int j = 0; j < n; j++){
		        arr[j] = Integer.parseInt(inputArr1[j]);
		    }
		    if(i != numberOfTest - 1){
		        sb.append(search(arr, k)+ "\n");
		    }
		    else{
		         sb.append(search(arr, k));
		    }
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static String search(int[] arr, int k) {
		int high = arr.length - 1;
		int low = 0;
		int turningPoint = getTurningPoint(arr, low, high);
		int a = binarySearch(arr, low, turningPoint, k);
		int b = reverseBinarySearch(arr, turningPoint, high, k);
		if(a == -1 && b == -1) {
			return "OOPS! NOT FOUND";
		}
		else if(b != -1) {
			return b + "";
		}
		else {
			return a + "";
		}
	}
	
	public static int getTurningPoint(int[] arr, int low, int high) {
		int turningPoint = (high + low) / 2;
		if(turningPoint + 1 > high) {
			return high;
		}
		if(turningPoint - 1 < low) {
			return low;
		}
		if(arr[turningPoint] > arr[turningPoint + 1] && arr[turningPoint] > arr[turningPoint - 1]) {
			return turningPoint;
		}
		else if(arr[turningPoint] > arr[turningPoint + 1] && arr[turningPoint] < arr[turningPoint - 1]) {
			high = turningPoint - 1;
			return getTurningPoint(arr, low, high);
		}
		else {
			low = turningPoint + 1;
			return getTurningPoint(arr, low, high);
		}	
	}
	
	public static int binarySearch(int[] arr, int low, int high, int k) {
		while(low <= high) {
			int middle = (high + low) / 2;
			if(arr[middle] == k)
				return middle;
			else if(arr[middle] < k)
				low = middle + 1;
			else
				high = middle - 1;
		}
		return -1;
	}
	
	public static int reverseBinarySearch(int[] arr, int low, int high, int k) {
		while(low <= high) {
			int middle = (high + low) / 2;
			if(arr[middle] == k)
				return middle;
			else if(arr[middle] < k)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return -1;
	}
}
