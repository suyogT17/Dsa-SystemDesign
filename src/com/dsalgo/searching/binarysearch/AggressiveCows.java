package com.dsalgo.searching.binarysearch;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/magnetic-force-between-two-balls/
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
 * Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that
 * the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 */
class AggressiveCows {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n - 1] - left;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(position, m, mid) >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int isPossible(int[] position, int m, int mid) {
        int cR = 1;
        int prev = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[prev] >= mid) {
                cR++;
                prev = i;
            }
        }
        return cR;
    }
}