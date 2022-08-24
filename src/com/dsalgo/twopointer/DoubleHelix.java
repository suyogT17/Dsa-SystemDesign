package com.dsalgo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Link: https://www.spoj.com/problems/ANARC05B/
 */
/*
Two ﬁnite, strictly increasing, integer sequences are given. Any common integer between the two sequences constitute an intersection point. Take for example the following two sequences where intersection points are
printed in bold:

First= 3 5 7 9 20 25 30 40 55 56 57 60 62
Second= 1 4 7 11 14 25 44 47 55 57 100
You can ‘walk” over these two sequences in the following way:

You may start at the beginning of any of the two sequences. Now start moving forward.
At each intersection point, you have the choice of either continuing with the same sequence you’re currently on, or switching to the other sequence.
The objective is ﬁnding a path that produces the maximum sum of data you walked over. In the above example, the largest possible sum is 450, which is the result of adding 3, 5, 7, 9, 20, 25, 44, 47, 55, 56, 57, 60, and 62

Input:
13 3 5 7 9 20 25 30 40 55 56 57 60 62
11 1 4 7 11 14 25 44 47 55 57 100
4 -5 100 1000 1005
3 -12 1000 1001
0

Output:
450
2100
 */
public class DoubleHelix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            String line1 = sc.nextLine();
            if (line1.equals("0")) break;
            data.add(line1);
        }
        while (data.size() != 0) {
            String line1 = data.remove(0);
            Integer[] arr1 = Arrays.stream(line1.split("\\s+")).map(s -> s.trim()).map(Integer::parseInt).toArray(Integer[]::new);
            String line2 = data.remove(0);
            Integer[] arr2 = Arrays.stream(line2.split("\\s+")).map(s -> s.trim()).map(Integer::parseInt).toArray(Integer[]::new);
            int p1 = 1;
            int p2 = 1;
            int s1 = 0, s2 = 0;
            int maxSum = 0;
            while (p1 < arr1.length && p2 < arr2.length) {
                if (arr1[p1] < arr2[p2]) {
                    s1 += arr1[p1];
                    p1++;
                } else if (arr1[p1] > arr2[p2]) {
                    s2 += arr2[p2];
                    p2++;
                } else {
                    maxSum += Math.max(s1, s2) + arr1[p1];
                    p1++;
                    p2++;
                    s1 = s2 = 0;
                }
            }
            while (p1 < arr1.length) {
                s1 += arr1[p1++];
            }
            while (p2 < arr2.length) {
                s2 += arr2[p2++];
            }
            maxSum += Math.max(s1, s2);
            System.out.println(maxSum);
        }
    }
}
