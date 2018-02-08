package com.datastructure.linkedlist;

public class AddTwoNumbers {
	
	public static int carry = 0;
	
	//part 1
	public static Node sumList(Node A, Node B) {
		if(A == null && B == null && carry == 0)
			return null;
		int value = carry;
		Node newNode = new Node(0);
		if(A != null) {
			value += A.data;
		}
		if(B != null) {
			value += B.data;
		}
		if(value > 10) {
			carry = 1;
		}
		else {
			carry = 0;
		}
		newNode.data = value % 10;
		if(A != null || B != null) {
			Node more = sumList(A == null? null : A.next, B == null? null : B.next);
			newNode.next = more;
		}
		return newNode;
	}
}
