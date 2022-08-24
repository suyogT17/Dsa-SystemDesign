package com.searching.linear;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1
 * Given an array of integers, sort the array (in descending order) according to count of set bits in binary representation of array elements.
 * Note: For integers having same number of set bits in their binary representation, sort according to their position in the original array i.e., a stable sort.
 */
class SortArrayOnCountOfSetBits {
    static void sortBySetBitCount(Integer arr[], int n) {
        Map<Integer, List<Integer>> map = new TreeMap(Collections.reverseOrder());
        for (int num : arr) {
            int cb = countSetBits(num);
            if (map.containsKey(cb)) {
                List<Integer> temp = map.get(cb);
                temp.add(num);
                map.put(cb, temp);
            } else {
                List<Integer> temp = new ArrayList();
                temp.add(num);
                map.put(cb, temp);
            }
        }
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int n1 : entry.getValue()) {
                arr[i++] = n1;
            }
        }
    }

    static int countSetBits(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
