package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://leetcode.com/problems/find-the-duplicate-number/
 * approach 1: sort
 * approach 2: if modifying array is allowed then multiply visited elements with -1 and when we will visit already negative element then that's duplicate element
 * approach 2: Floyd cycle detection algorithm
 */
class FindDuplicate {
    public int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow]; // move slow pointer by one position
            fast =  nums[nums[fast]]; // move fast pointer by two positions
        }while(slow != fast); // when they meet break
        slow =  nums[0]; // assign slow to first element
        while(slow != fast){    // move both pointer by 1 position till the meet each other
            slow = nums[slow];
            fast =  nums[fast];
        }
        return slow; // meeting point contains duplicate element
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