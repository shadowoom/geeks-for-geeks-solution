package com.datastructure.array;

import java.util.Scanner;

public class SearchInSortedAndRotatedArray {
	
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
		int low = 0;
		int high = arr.length - 1;
		String index = search(arr, low, high, k);
		return index;
	}
	
	public static String search(int[]arr, int l, int h, int key) {
		if (l > h) 
			return "OOPS! NOT FOUND";
       
        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid + "";
       
        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid])
        {
            /* As this subarray is sorted, we 
               can quickly check if key lies in 
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
               return search(arr, l, mid-1, key);
       
            return search(arr, mid+1, h, key);
        }
       
        /* If arr[l..mid] is not sorted, 
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);
       
        return search(arr, l, mid-1, key);
		
	}
}
