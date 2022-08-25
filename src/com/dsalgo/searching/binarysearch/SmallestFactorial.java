package com.dsalgo.searching.binarysearch;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1
 * Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.
 */
class SmallestFactorial {
    int findNum(int n) {
        if (n == 1) return 5;
        int left = 0, right = n * 5;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, n)) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }

    boolean check(int num, int n) {
        int f = 5, count = 0;
        while (f <= num) {
            count += num / f;
            f *= 5;
        }
        return count >= n;
    }
}