package com.dsalgo.arrays.subarray;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
 */
class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> map =  new HashMap();
        int sum=0, op=0;
        map.put(0, 1);
        for(int num: nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                op += map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }
            else map.put(sum ,1);
        }
        return op;
    }
}