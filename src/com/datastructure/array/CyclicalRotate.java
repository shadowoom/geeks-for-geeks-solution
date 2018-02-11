package com.datastructure.array;

import java.util.Scanner;

public class CyclicalRotate {
	
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int numberOfTest = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numberOfTest; i++){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    sc.nextLine();
		    String inputString = sc.nextLine().trim();
		    String[] inputArr = inputString.split("\\s+");
		    for(int j = 0; j < n; j++){
		        arr[j] = Integer.parseInt(inputArr[j]);
		    }
		    if(i != numberOfTest - 1){
		        sb.append(cyclicalRotate(arr, n)+ "\n");
		    }
		    else{
		         sb.append(cyclicalRotate(arr, n));
		    }
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static String cyclicalRotate(int[] arr, int n){
	    int temp = arr[n - 1];
	    for(int i = n-1; i > 0; i--){
	        arr[i] = arr[i-1];
	    }
	    arr[0] = temp;
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < n - 1; i++){
	        sb.append(arr[i] + " ");
	    }
	    sb.append(arr[n-1]);
	    return sb.toString();
	}
}
