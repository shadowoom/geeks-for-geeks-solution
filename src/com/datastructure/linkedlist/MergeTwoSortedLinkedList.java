package com.datastructure.linkedlist;

public class MergeTwoSortedLinkedList {
	
//	public Node MergeLists(Node headA, Node headB) {
//	     // This is a "method-only" submission. 
//	     // You only need to complete this method
//		if(headA == null) {
//    	 	return headB;
//     }
//     else if(headB == null) {
//    	 	return headA;
//     }
//     else {
//    	 	Node newHead = new Node(0);
//    	 	Node currentNode = new Node(0);
//    	 	if(headA.data > headB.data) {
//    	 		newHead.data = headB.data;
//    	 		headB = headB.next;
//    	 	}
//    	 	else {
//    	 		newHead.data = headA.data;
//    	 		headA = headA.next;
//    	 	}
//    	 	newHead.next = currentNode;
//    	 	while(headA != null && headB != null) {
//    	 		if(headA.data > headB.data) {
//    	 			currentNode.data =  headB.data;
//    	 			headB = headB.next;
//    	 		}
//    	 		else {
//    	 			currentNode.data =  headA.data;
//    	 			headA = headA.next;
//    	 		}
//    	 		currentNode.next = new Node(0);
//    	 		currentNode = currentNode.next;
//    	 	}
//    	 	if(headA != null) {
//    	 		while(headA != null) {
//	    	 		currentNode.data = headA.data;
//	    	 		headA = headA.next;
//	    	 		if(headA != null) {
//	    	 			currentNode.next = new Node(0);
//		    	 		currentNode = currentNode.next;
//	    	 		}
//	    	 	}
//    	 	}
//    	 	if(headB != null) {
//    	 		while(headB != null) {
//	    	 		currentNode.data = headB.data;
//	    	 		headB = headB.next;
//	    	 		if(headB != null) {
//	    	 			currentNode.next = new Node(0);
//		    	 		currentNode = currentNode.next;
//	    	 		}	
//	    	 	}
//    	 	}
//    	 	return newHead;
//	     }
//	} 
	public Node sortedMerge(Node a, Node b) 
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
}
