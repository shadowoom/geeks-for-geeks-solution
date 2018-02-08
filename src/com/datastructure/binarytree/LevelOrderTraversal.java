package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(Node root) {
        // write your code here
        if(root == null) return new ArrayList<>();
        Queue<Node> tempQueue = new LinkedList<Node>();
        Queue<Node> subQueue = new LinkedList<Node>();
        List<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        tempQueue.add(root);
        while(!tempQueue.isEmpty()){
            Node tempNode = tempQueue.remove();
            tempList.add(tempNode.key);
            if(tempNode.left != null){
                subQueue.add(tempNode.left);
            }
            if(tempNode.right != null){
                subQueue.add(tempNode.right);
            }
            if(tempQueue.isEmpty()){
                resultList.add(tempList);
                tempList = new ArrayList<Integer>();
                tempQueue = subQueue;
                subQueue = new LinkedList<Node>();
            }
        }
        return resultList;
    }
}
