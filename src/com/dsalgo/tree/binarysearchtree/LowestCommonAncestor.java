package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link:
 * Iterative and recursive code to find the lowest common ancestor
 * Time: O(logN) Space: O(1)
 * Approach:
 *  - if root is null then return null
 *  - check if p and q are less than root
 *      then find p and q on left side of tree
 *  - check if p and q are greater than root
 *      then find p and q on right side of tree
 *  if above two conditions not satisfied that means the p is on left and q is on right of root or vice versa. so the lowest common ancestor is root node.
 *
 */
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorRec(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorRec(root.right, p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestorItr(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }
}