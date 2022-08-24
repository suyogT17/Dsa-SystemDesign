package com.searching.binarysearch;

import java.util.Scanner;

/**
 * Problem Link: https://www.spoj.com/problems/PRATA/
 * IEEE is having its AGM next week and the president wants to serve cheese prata after the meeting.
 * The subcommittee members are asked to go to food connection and get P (P<=1000) pratas packed for the function.
 * The stall has L cooks (L<=50) and each cook has a rank R (1<=R<=8). A cook with a rank R can cook 1 prata in the first R minutes
 * 1 more prata in the next 2R minutes, 1 more prata in 3R minutes and so on(he can only cook a complete prata)
 * ( For example if a cook is ranked 2.. he will cook one prata in 2 minutes one more prata in the next 4 mins
 * an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he does not
 * have enough time for the 4th prata). The webmaster wants to know the minimum time to get the order done. Please write a program to help him out.
 */
public class RotiPrata {

    /**
     * 3
     * 10
     * 4 1 2 3 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int numberOfPrata = sc.nextInt();
            int numberOfChefs = sc.nextInt();
            int[] ranks = new int[numberOfChefs];
            for (int i = 0; i < numberOfChefs; i++) {
                ranks[i] = sc.nextInt();
            }
            System.out.println(printTimeRequired(ranks, numberOfPrata));
        }
    }

    private static int printTimeRequired(int[] ranks, int numberOfPrata) {
        int left = 0;
        int right = (int) 1e8;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(ranks, mid, numberOfPrata)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    private static boolean isPossible(int[] ranks, int mid, int numberOfPrata) {
        int prata = 0;
        for (int i = 0; i < ranks.length; i++) {
            int time = ranks[i];
            int j = 2;
            while (time <= mid) {
                prata++;
                time += ranks[i] * j++;
            }
        }
        return prata >= numberOfPrata;
    }
}
