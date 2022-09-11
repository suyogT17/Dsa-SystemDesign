package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Minimum subset sum diff solved using tabulation in subset sum
 */
public class MinSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;
        boolean[][] boolDp = new boolean[n + 1][total + 1];
        // calling subset sum solving function with w = sum of array elements
        SubsetSum.solveSubsetSumWithTabulation(arr, total, n, boolDp);
        int s1 = 0;
        //iterating last row which tells if sum between 0 - range/2 is possible and picking largest of that.
        for (int i = 0; i < total / 2; i++) {
            if (boolDp[n][i]) s1 = i;
        }
        System.out.println("total = " + total);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + (total - s1));
        System.out.println("Minimum diff (s2-s1): " + (total - 2 * s1));
    }
}
