package com.datastructure.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementStackWithQueue {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int size;
	
	public ImplementStackWithQueue() {
		size = 0;
	}
	
	void push(int a) {
		size++;
		q2.add(a);
		while(!q1.isEmpty()) {
			int temp = q1.poll();
			q2.add(temp);
		}
		Queue<Integer> tempQ = q1;
		q1 = q2;
		q2 = tempQ;
	}
	
	int pop() {
		if(q1.isEmpty()) throw new NoSuchElementException("Stack UnderFlow");
		size--;
		return q1.poll();
	}
}
