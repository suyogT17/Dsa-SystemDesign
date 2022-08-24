package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/kth-smallest-number-again-2/
 */
class KthSmallestAgain {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int N = s.nextInt();
            int Q = s.nextInt();
            long[][] array1 = new long[N][2];
            for (int i = 0; i < N; i++) {
                array1[i][0] = s.nextLong();
                array1[i][1] = s.nextLong();
            }
            long[] qArray = new long[Q];
            for (int i = 0; i < Q; i++) {
                qArray[i] = s.nextLong();
            }
            int n = mergeIntervals(array1);
            for (int j = 0; j < Q; j++) {
                long k = qArray[j];
                boolean flag = false;
                long ans = -1;
                for (int i = 0; i < n; i++) {
                    if (array1[i][1] - array1[i][0] + 1 >= k) {
                        ans = array1[i][0] + k - 1;
                        break;
                    } else {
                        k -= array1[i][1] - array1[i][0] + 1;
                    }
                }
                System.out.println(ans);
            }
        }
    }

    static int mergeIntervals(long[][] array1) {
        Arrays.sort(array1, (e1, e2) -> (e1[0] < e2[0]) ? -1 : 0);
        int i = 0;
        for (int j = 1; j < array1.length; j++) {
            if (array1[i][1] > array1[j][0]) {
                array1[i][1] = Math.max(array1[i][1], array1[j][1]);
            } else {
                i++;
                long[] tmp = array1[i];
                array1[i] = array1[j];
                array1[j] = tmp;
            }
        }
        return i + 1;
    }
}