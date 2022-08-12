package com.dsalgo.binarysearchtree.buildbst;

import com.dsalgo.binarysearchtree.TreeNode;

/**
 * Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Approach
 * - Using binary search approach
 * - Time = O(logN)
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = convertTree(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode convertTree(int[] nums, int start, int end){
        if(start > end) return null;

        int mid =  start + (end-start)/2;
        TreeNode root =  new TreeNode(nums[mid]);

        root.left = convertTree(nums, start, mid-1);
        root.right = convertTree(nums, mid+1, end);
        return root;
    }
}