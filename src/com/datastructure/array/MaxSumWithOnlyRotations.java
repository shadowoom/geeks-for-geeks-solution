package com.datastructure.array;

public class MaxSumWithOnlyRotations {
	
	/*
	 * 
	 * Given an array, only rotation operation is allowed on array. 
	 * We can rotate the array as many times as we want. 
	 * Return the maximum possbile of summation of i*arr[i].
	 */
	
	public static int maxSum(int arr[]) {
		int sum = 0;
		int max = 0;
		int currentVal = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			currentVal += arr[i] * i; 
		}
		max = currentVal;
		for(int j = 1; j < arr.length; j++) {
			currentVal = sum - arr.length * arr[arr.length - j] + currentVal;
			if(currentVal > max)
				max = currentVal;
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {8, 3, 1, 2};
		System.out.println(maxSum(arr));
	}

}
