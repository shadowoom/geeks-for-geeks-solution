package com.datastructure.stack;

import java.util.ListIterator;
import java.util.Stack;

public class SortStack {
	
	static void sortStack(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int a = s.peek();
			s.pop();
			sortStack(s);
			insertSorted(s, a);
		}
	}
	
	static void insertSorted(Stack<Integer> s, int a) {
		if(s.isEmpty() || a >= s.peek()) {
			s.push(a);
		}
		else {
			int b = s.peek();
			s.pop();
			insertSorted(s, a);
			s.push(b);
		}
	}
	
	// Utility Method to print contents of stack
    static void printStack(Stack<Integer> s)
    {
       ListIterator<Integer> lt = s.listIterator();
        
       // forwarding
       while(lt.hasNext()) 
           lt.next();
        
       // printing from top to bottom
       while(lt.hasPrevious())
           System.out.print(lt.previous()+" ");
    }
   
    // Driver method 
    public static void main(String[] args) 
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      
        System.out.println("Stack elements before sorting: ");
        printStack(s);
      
        sortStack(s);
      
        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
      
    }
	
}
