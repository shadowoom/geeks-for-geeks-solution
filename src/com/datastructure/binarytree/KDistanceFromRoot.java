package com.datastructure.binarytree;

public class KDistanceFromRoot {
	
	void printKDistant(Node node, int k) 
    {
        if (node == null)
            return;
        if (k == 0) 
        {
            System.out.print(node.key + " ");
            return;
        } 
        else
        {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }
	
}
