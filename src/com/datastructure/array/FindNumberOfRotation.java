package com.datastructure.array;

import java.util.Scanner;

public class FindNumberOfRotation {
	
	public static void main (String[] args) {
		//code
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
			    sb.append(findNumberOfRotationBinarySearch(arr)+"\n");
			}
			else{
			    sb.append(findNumberOfRotationBinarySearch(arr));
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	// O(n) method
	public static int findNumberOfRotation(int[] arr){
	    int minIndex = 0;
	    int min = arr[0];
	    for(int i = 1; i < arr.length; i++){
	        if(arr[i] <= min){
	            min = arr[i];
	            minIndex = i;
	        }
	    }
	    int temp = minIndex;
	    for(int j = minIndex; j > 0; j--){
	        if(arr[j] == arr[j-1]){
	            temp = j - 1;
	        }
	        else{
	            break;
	        }
	    }
	    minIndex = temp;
	    return minIndex;
	}
	
	// if the items in the array are distinct
	public static int findNumberOfRotationBinarySearch(int[] arr){
		return findNumberOfRotationBinarySearch(arr, 0, arr.length-1);
	}
	public static int findNumberOfRotationBinarySearch(int[] arr, int low, int high){
		// This condition is needed to handle 
        // the case when array is not rotated 
        // at all or If there is only one element left
        if (high <= low)
            return low;

        // Find mid
        // /*(low + high)/2;*/
        int mid = (low + high)/2; 
        
        //if there are two elements left
        if(mid == low) {
        	if(arr[mid] > arr[high])
        		return high;
        	else
        		return low;
        }
        else {
        	if(arr[mid-1] > arr[mid])
        		return mid;
        	else {
        		if(arr[mid] > arr[low] && arr[mid] < arr[high])
        			return low;
        		else if(arr[mid] < arr[low]) {
        			return findNumberOfRotationBinarySearch(arr, low, mid-1);
        		}
        		else
        			return findNumberOfRotationBinarySearch(arr, mid+1, high);
        	}
        }
	}
	
}
