package com.dsalgo.searching.binarysearch;

import java.util.*;

/**
 * Problem Link: https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/
 * Bishu went to fight for Coding Club. There were N soldiers with various powers.
 * There will be Q rounds to fight and in each round, Bishu's power will be varied.
 * With power M, Bishu can kill all the soldiers whose power is less than or equal to M(<=M). After each round,
 * All the soldiers who are dead in the previous round will reborn. Such that in each round there will be N soldiers to fight.
 * As Bishu is weak in mathematics, help him to count the number of soldiers that he can kill in each round and the total sum of their powers.
 */
class BishuAndSoldiers {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] soldiers = new int[N];
        int[] preSum = new int[N + 1];
        preSum[0] = 0;
        for (int i = 0; i < N; i++) {
            soldiers[i] = s.nextInt();
        }
        Arrays.sort(soldiers);
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + soldiers[i - 1];
        }
        int r = s.nextInt();
        int[] rounds = new int[r];
        for (int i = 0; i < r; i++) {
            rounds[i] = s.nextInt();
        }
        for (int i = 0; i < rounds.length; i++) {
            int index = doBinarySearch(soldiers, rounds[i]);
            System.out.println(index + 1 + " " + preSum[index + 1]);
        }
    }

    private static int doBinarySearch(int[] soldiers, int value) {
        int left = 0, right = soldiers.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (soldiers[mid] <= value) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}
