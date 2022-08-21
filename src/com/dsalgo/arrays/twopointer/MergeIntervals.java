package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervals {
    public int[][] merge1(int[][] intervals) {
        LinkedList<List<Integer>> list = new LinkedList();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        list.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            if (list.getLast().get(1) >= intervals[i][0]) {

                list.set(list.size() - 1, Arrays.asList(list.getLast().get(0), Math.max(list.getLast().get(1), intervals[i][1])));

            } else {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
        }
        return list.stream().map(inner -> inner.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int i = 0;

        for (int j = 1; j < intervals.length; j++) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                intervals[++i] = intervals[j];
            }
        }
        int[][] output = new int[i + 1][2];
        for (int x = 0; x < output.length; x++) {
            output[x] = intervals[x];
        }
        return output;
    }
}