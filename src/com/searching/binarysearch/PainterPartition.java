package com.searching.binarysearch;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 * You are given N number of books. Every ith book has Ai number of pages. The books are arranged in ascending order.
 * You have to allocate contiguous books to M number of students. There can be many ways or permutations to do so.
 * In each permutation, one of the M students will be allocated the maximum number of pages.
 * Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated
 * to a student is the minimum of those in all the other permutations and print this minimum value.
 * Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
 */
class PainterPartition {
    public static int findPages(int[] A, int N, int M) {
        int start = findMax(A);
        int end = sum(A);
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidDist(A, mid, M)) {
                res = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return res;
    }

    static int sum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    static int findMax(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(A[i], max);
        }
        return max;
    }

    static boolean isValidDist(int[] A, int mid, int M) {
        int s = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > mid) {
                s++;
                sum = A[i];
            }
            if (s > M) return false;
        }
        return true;
    }
};