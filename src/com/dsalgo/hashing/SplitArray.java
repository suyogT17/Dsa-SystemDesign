package com.dsalgo.hashing;

import java.util.*;
/**
 * Problem Link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * Solved using two maps
 * Time: O(N) Space: O(N)
 */
public class SplitArray {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> am =  new HashMap();
        Map<Integer, Integer> vm =  new HashMap();

        for(int num: nums){
            am.put(num, am.getOrDefault(num,0)+1);
        }

        for(int i=0;i<nums.length;i++){
            if(am.get(nums[i]) <=0) continue;
            else if(vm.getOrDefault(nums[i] ,0) > 0){
                vm.put(nums[i], vm.get(nums[i]) -1);
                vm.put(nums[i]+1,vm.getOrDefault(nums[i]+1,0)+1);
                am.put(nums[i], am.get(nums[i]) -1);
            }
            else if(am.getOrDefault(nums[i] ,0) > 0 && am.getOrDefault(nums[i]+1 ,0) > 0 && am.getOrDefault(nums[i]+2 ,0) > 0){
                am.put(nums[i], am.get(nums[i]) -1);
                am.put(nums[i]+1, am.get(nums[i]+1) -1);
                am.put(nums[i]+2, am.get(nums[i]+2) -1);
                vm.put(nums[i]+3,vm.getOrDefault(nums[i]+3,0)+1);

            }
            else return false;
        }

        return true;
    }
}
