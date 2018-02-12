package com.datastructure.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class PairInSortedRotated {
	
	public static int[] pairInSortedRotated(int[] arr, int sum) {
		int[] resultIndex = new int[2];
		int[] result = new int[2];
		HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(!tempMap.containsKey(arr[i])) {
				tempMap.put((sum-arr[i]), i);
			}
			else {
				resultIndex[0] = i;
				resultIndex[1] = tempMap.get(arr[i]);
				result[0] = arr[resultIndex[0]];
				result[1] = arr[resultIndex[1]];
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {11, 15, 26, 38, 9, 10};
		System.out.println(Arrays.toString(pairInSortedRotated(arr, 45)));

	}

}
