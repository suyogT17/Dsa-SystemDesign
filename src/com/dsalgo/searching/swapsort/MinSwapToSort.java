package com.dsalgo.searching.swapsort;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-swaps/1
 * Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
 */
class MinSwapToSort {
    public int minSwaps(int nums[]) {
        List<Pair<Integer, Integer>> pairA = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            pairA.add(new Pair<Integer, Integer>(nums[i], i));
        }
        Collections.sort(pairA, (e1, e2) -> e1.getKey() - e2.getKey());
        int op = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pairA.get(i).getValue() != i) {
                swap(pairA, i, pairA.get(i).getValue());
                op++;
            }
        }
        return op;
    }

    private void swap(List<Pair<Integer, Integer>> pairA, int i, int j) {
        Pair<Integer, Integer> tmp = pairA.get(i);
        pairA.set(i, pairA.get(j));
        pairA.set(j, tmp);
    }
}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    public String toString() {
        return key + " " + value;
    }
}