package com.datastructure.linkedlist;

public class DetectAndRemoveLoop {

	// Function that detects loop in the list
    public boolean detectAndRemoveLoop(Node head) {
    		Node slowNode = head;
    		Node fastNode = head;
    		while(slowNode != null && fastNode != null && fastNode.next != null) {
    			slowNode = slowNode.next;
    			fastNode = fastNode.next.next;
    			if(slowNode == fastNode) {
    				removeLoop(slowNode, head);
    				return true;
    			}
    		}
    		return false;
    }
    
    public void removeLoop(Node loop, Node head) {
    		//count the loop size
    		Node node1 = loop;
    		Node node2 = loop;
    		int size = 1;
    		while(node2.next != node1) {
    			node2 = node2.next;
    			size++;
    		}
    		//separate two node k -1 apart
    		node1 = head;
    		node2 = head;
    		for(int i = 1; i < size; i++) {
    			node2 = node2.next;
    		}
    		//start move each node
    		while(node2.next != node1) {
    			node1 = node1.next;
    			node2 = node2.next;
    		}
    		node2.next = null;
    }
}
