package com.dsalgo.arrays;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
 * Time Complexity : O(n)
 */
class FindMinMax {
    /**
     * Max number of comparison in the below approach will be 2*(n-1)
     * as we will be comparing with each element 2 time once for min and again for max
     */
    static pair getMinMaxSimple(long a[], long n) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (long num : a) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        pair ans = new pair(min, max);
        return ans;
    }

    /**
     * to do it in minimum number of comparison
     * compare in pair of 2 so if 6 elements are there then
     * if number is even then
     *  1 comparison to assign initial min and max (this reduced the n to n-2)
     *  3*(n-2)/2 - performing 3 comparison for group of two elements
     * if number is odd then
     *  assign first element as min and max both this reduces it n to (n-1)
     *  then perform it for n-1 even number so total comparison will be 3(n-1)/2
     */
    static pair getMinMaxOptimized(long a[], long n) { //even 1+3(n-2)/2 odd = 3(n-1)/2
        long min = 0, max = 0;
        int i = 0;
        if (n % 2 == 0) {
            if (a[0] > a[1]) {
                min = a[1];
                max = a[0];
            } else {
                min = a[0];
                max = a[1];
            }
            i = 2;
        } else {
            min = a[0];
            max = a[0];
            i = 1;
        }

        for (; i < n; i += 2) {
            if (a[i] > a[i + 1]) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i + 1] < min) {
                    min = a[i + 1];
                }
            } else {
                if (a[i + 1] > max) {
                    max = a[i + 1];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
        }
        return new pair(min, max);
    }
}

class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}