package com.datastructure.binarytree;

public class PrintAncestors {
	
	boolean printAncestors(Node node, int target) 
    {
         /* base cases */
        if (node == null)
            return false;
  
        if (node.key == target)
            return true;
  
        /* If target is present in either left or right subtree 
           of this node, then print this node */
        if (printAncestors(node.left, target) || printAncestors(node.right, target)) 
        {
            System.out.print(node.key + " ");
            return true;
        }
  
        /* Else return false */
        return false;
    }
	
}
