package com.dsalgo.searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Link: https://www.spoj.com/problems/EKO/
 */
class EKO {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int[] size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = sc.nextInt();
        }
        System.out.println(findMaxTreeLength(size, m));
    }

    private static int findMaxTreeLength(int[] size, int m) {
        Arrays.sort(size);
        int left = 1;
        int right = size[size.length - 1];
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(size, m, mid) >= m) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(left + " " + right + " " + ans);
        return ans;
    }

    private static int isPossible(int[] size, int m, int mid) {
        int diff = 0;
        for (int i = 0; i < size.length; i++) {
            diff += Math.max(0, size[i] - mid);
        }
        return diff;
    }
}
