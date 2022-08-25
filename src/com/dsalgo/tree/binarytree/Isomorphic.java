package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
 */
class Isomorphic {
    boolean isIsomorphic(Node n1, Node n2) {
        // code here.
        if (n1 == null && n2 == null)
            return true;
        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null)
            return false;
        if (n1.data != n2.data)
            return false;
        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been
        // "Flipped".
        // Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(n1.left, n2.left) &&
                isIsomorphic(n1.right, n2.right))
                || (isIsomorphic(n1.left, n2.right) &&
                isIsomorphic(n1.right, n2.left));
    }
}