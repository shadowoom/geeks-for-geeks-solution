package com.datastructure.stack;

import java.util.Stack;

public class ReverseStack {
	static Stack<Integer> s = new Stack<Integer>();
	static void reverse() {
		if(!s.isEmpty()) {
			int a = s.peek();
			s.pop();
			reverse();
			insertAtBottom(a);
		}
	}
	
	static void insertAtBottom(int a) {
		if(s.isEmpty()) {
			s.push(a);
		}
		else {
			int b = s.peek();
			s.pop();
			insertAtBottom(a);
			s.push(b);
		}
	}
	
	public static void main(String[] args) 
    {
         //push elements into the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
         
        System.out.println("Original Stack");
         
        System.out.println(s);
         
        //function to reverse the stack
        reverse();
         
        System.out.println("Reversed Stack");
         
        System.out.println(s);
    }
}
