package com.datastructure.array;

import java.util.Scanner;

public class PrintIsosceles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the input size: ");
		int size = sc.nextInt();
		for(int i = 1; i <= size; i++) {
			String outputStr = "";
			for(int j = 1; j <= size - i; j++) {
				outputStr += " ";
			}
			for(int j = 1; j <= 2 * i - 1; j++) {
				outputStr += "*";
			}
			for(int j = 1; j <= size - i; j++) {
				outputStr += " ";
			}
			System.out.println(outputStr);
		}
		sc.close();
	}

}
