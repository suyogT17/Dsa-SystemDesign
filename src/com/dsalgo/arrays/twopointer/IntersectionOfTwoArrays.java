package com.dsalgo.arrays.twopointer;

import java.util.*;
/**
 * Problem Link : https://leetcode.com/problems/intersection-of-two-arrays/
 * Solved using set
 * Approaches:
 * Using two pointer
 * Time: O(n) -> is arrays are sorted , O(nlogn) -> if arrays are not sorted as we need to sort them first
 *  - if elements are sorted then use two pointer one to point num1 and other to num2
 *  - move the pointer for the element which in less
 *  - if we get same element add that in output and move both pointer ahead
 * Using Set
 * Time = O(n)
 *  - Add all the elements of the first array in set
 *  - iterate over the second array and check if elements of it is already part of set or not
 *  - if yes then add that element in output.
 */

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set =  new HashSet();
        List<Integer> list =  new ArrayList();
        // add elements of num1 into set
        for(int num: nums1){
            set.add(num);
        }
        // if the element of num2 already present in the set then it's common
        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}