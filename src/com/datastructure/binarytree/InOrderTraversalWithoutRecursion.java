package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalWithoutRecursion {
	
	public List<Integer> inorderTraversal(Node root) {
        // write your code here
		if (root == null) {
            return new ArrayList<Integer>();
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        List<Integer> resultList = new ArrayList<Integer>();
        Node node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
            resultList.add(node.key);
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return resultList;
    }
	
	
}
