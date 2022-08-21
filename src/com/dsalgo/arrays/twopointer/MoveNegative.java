package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://leetcode.com/problems/move-zeroes/
 * Problem Link: https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1
 * Move all negative elements to end or Move Zeroes.
 * Note: Solution does not maintain the order of the elements
 * Time: O(N)
 */
class MoveNegative {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            //if(nums[i] != 0 ){ // if number is not 0 then swap as we will swap as i we have to move non-zero num to front
            //if(nums[i] > 0 ){ // if number is less than 0 then swap as we will swap as i we have to move negative to end
            if(nums[i] < 0 ){   // if number is less than 0 then swap as we will swap as i we have to move negative to from
                swap(nums,i,j);
                j++;
            }
        }

    }

    private void swap(int[] nums, int i, int j){
        if(i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}