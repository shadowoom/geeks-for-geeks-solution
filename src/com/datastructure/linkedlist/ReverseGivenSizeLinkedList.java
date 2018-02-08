package com.datastructure.linkedlist;

public class ReverseGivenSizeLinkedList {
	
	public Node reverseGivenSize(Node head, int k) {
		Node current = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while(count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		if(next != null) {
			head.next = reverseGivenSize(next, k);
		}
		return prev;
	}
	
}
