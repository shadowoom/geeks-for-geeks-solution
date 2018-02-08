package com.datastructure.linkedlist;

public class LinkedList {
	
	Node head;  // head of list

	//method - insert a node in front
	public void push(int new_data)
	{
	    /* 1 & 2: Allocate the Node &
	              Put in the data*/
	    Node new_node = new Node(new_data);
	 
	    /* 3. Make next of new Node as head */
	    new_node.next = head;
	 
	    /* 4. Move the head to point to new Node */
	    head = new_node;
	}
	
	//method -  insert a node after another node
	public void insertAfter(Node prev_node, int new_data)
	{
	    /* 1. Check if the given Node is null */
	    if (prev_node == null)
	    {
	        System.out.println("The given previous node cannot be null");
	        return;
	    }
	 
	    /* 2. Allocate the Node &
	       3. Put in the data*/
	    Node new_node = new Node(new_data);
	 
	    /* 4. Make next of new Node as next of prev_node */
	    new_node.next = prev_node.next;
	 
	    /* 5. make next of prev_node as new_node */
	    prev_node.next = new_node;
	}
	
	//method - append a node
	public void append(int new_data)
	{
	    /* 1. Allocate the Node &
	       2. Put in the data
	       3. Set next as null */
	    Node new_node = new Node(new_data);
	 
	    /* 4. If the Linked List is empty, then make the
	           new node as head */
	    if (head == null)
	    {
	        head = new Node(new_data);
	        return;
	    }
	 
	    /* 4. This new node is going to be the last node, so
	         make next of it as null */
	    new_node.next = null;
	 
	    /* 5. Else traverse till the last node */
	    Node last = head; 
	    while (last.next != null)
	        last = last.next;
	 
	    /* 6. Change the next of last node */
	    last.next = new_node;
	    return;
	}
	
	/* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNodeBasedOnValue(int key)
    {
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }    
 
        // If key was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }
    
    public void deleteNodeBasedOnPosition(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
 
        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list
    }
    
    /* Returns count of nodes in linked list */
    public int getCount()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
	
    //Checks whether the value x is present in linked list
    public boolean search(Node head, int x)
    {
        Node current = head;    //Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }
    
    /* Function to swap Nodes x and y in linked list by
    changing links */
    public void swapNodes(int x, int y) {
    	// Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    
    // prints content of linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	
    
	public static void main(String[] args) {
//		LinkedList list = new LinkedList();
//        list.head = new Node(5);
//        list.head.next = new Node(10);
//        list.head.next.next = new Node(15);
//        list.head.next.next.next = new Node(40);
//        LinkedList list1 = new LinkedList();
//        list1.head = new Node(2);
//        list1.head.next = new Node(3);
//        list1.head.next.next = new Node(20);
//        System.out.println("Given Linked list");
//        list.printList(list.head);
//        System.out.println();
//        list1.printList(list1.head);
//        //Node temp = new ReverseLinkedList().reverse(list.head);
//        Node temp = new MergeTwoSortedLinkedList().sortedMerge(list.head, list1.head);
//        System.out.println("");
//        //System.out.println("Reversed linked list ");
//        System.out.println("Merged linked list ");
//        list.printList(temp);
//		  LinkedList list = new LinkedList();
//          list.head = new Node(50);
//          list.head.next = new Node(20);
//          list.head.next.next = new Node(15);
//          list.head.next.next.next = new Node(4);
//          list.head.next.next.next.next = new Node(10);
// 
//          // Creating a loop for testing 
//          list.head.next.next.next.next.next = list.head.next.next;
//          new DetectAndRemoveLoop().detectAndRemoveLoop(list.head);
//          System.out.println("Linked List after removing loop : ");
//          list.printList(list.head);

	}

}
