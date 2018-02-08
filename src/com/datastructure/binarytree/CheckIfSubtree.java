package com.datastructure.binarytree;

public class CheckIfSubtree {
	/* A utility function to check whether trees with roots as root1 and
    root2 are identical or not */
 boolean areIdentical(Node root1, Node root2) 
 {

     /* base cases */
     if (root1 == null && root2 == null)
         return true;

     if (root1 == null || root2 == null)
         return false;

     /* Check if the data of both roots is same and data of left and right
        subtrees are also same */
     return (root1.key == root2.key
             && areIdentical(root1.left, root2.left)
             && areIdentical(root1.right, root2.right));
 }

 /* This function returns true if S is a subtree of T, otherwise false */
 boolean isSubtree(Node T, Node S) 
 {
     /* base cases */
     if (S == null) 
         return true;

     if (T == null)
         return false;

     /* Check the tree with root as current node */
     if (areIdentical(T, S)) 
         return true;

     /* If the tree with root as current node doesn't match then
        try left and right subtrees one by one */
     return isSubtree(T.left, S) || isSubtree(T.right, S);
 }
}
