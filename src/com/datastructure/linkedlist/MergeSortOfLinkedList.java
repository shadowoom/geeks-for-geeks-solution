package com.datastructure.linkedlist;

public class MergeSortOfLinkedList {

	public Node mergeSort(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node middle = getMiddleNode(head);
		Node middleNext = middle.next;
		middle.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(middleNext);
		Node sortedHead = sortedMerge(left, right);
		return sortedHead;
	}
	
	public Node getMiddleNode(Node head) {
		if(head == null) {
			return head;
		}
		Node slowNode = head;
		Node fastNode = head.next;
		
		while(fastNode != null) {
			fastNode = fastNode.next;
			if(fastNode != null) {
				slowNode = slowNode.next;
				fastNode = fastNode.next;
			}
		}
		return slowNode;
	}
	
	public Node sortedMerge(Node A, Node B) {
		if(A == null) {
			return B;
		}
		if(B == null) {
			return A;
		}
		Node result = null;
		 /* Pick either a or b, and recur */
        if (A.data <= B.data) 
        {
            result = A;
            result.next = sortedMerge(A.next, B);
        } 
        else
        {
            result = B;
            result.next = sortedMerge(A, B.next);
        }
        return result;
	}
}
