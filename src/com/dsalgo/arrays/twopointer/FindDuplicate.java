package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://leetcode.com/problems/find-the-duplicate-number/
 */
class FindDuplicate {
    public int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast =  nums[nums[fast]];
        }while(slow != fast);
        slow =  nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast =  nums[fast];
        }
        return slow;
    }

    public int findDuplicate(int[] nums) {
        int start = nums[0];
        while(nums[start] > 0){
            nums[start] = -1*nums[start];
            start = nums[start]*-1;
        }
        return start;
    }


}