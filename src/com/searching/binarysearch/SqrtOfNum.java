package com.searching.binarysearch;

/**
 * Problem Link: https://leetcode.com/problems/sqrtx/
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */

class SqrtOfNum {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double start = 1, end = x;
        double eps = 1e-6;
        while ((end - start) >= eps) {
            double mid = start + (end - start) / 2.0;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (int) (end);
    }
}