package com.datastructure.array;

public class MultiplicationTable {
	public static void main(String[]args) {
		for(int i = 1; i <= 9; i ++) {
			String outputStr = "";
			for(int j = 1; j <= i; j++) {
				if(j == i) {
					outputStr += i + " X " + j + " = " + (i * j); 
				}
				else {
					outputStr += i + " X " + j + " = " + (i * j) + ", "; 
				}
			}
			System.out.println(outputStr);
		}
	}
}
