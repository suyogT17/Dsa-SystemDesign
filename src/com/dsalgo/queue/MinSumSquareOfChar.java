package com.dsalgo.queue;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/game-with-string4100/1
 * Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of ‘k’ characters. The value of a string is defined as the sum of squares of the count of each distinct character.
 *
 * Example 1:
 *
 * Input: s = abccc, k = 1
 * Output: 6
 * Explaination:
 * We remove c to get the value as 12 + 12 + 22
 */
class MinSumSquareOfChar {
    static int minValue(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap();//(o1, o2) -> o2.getValue()-o1.getValue());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        //System.out.println(entries);
        while (k > 0) {
            if (k > 0 && entries.get(0).getValue() > 0) {
                entries.get(0).setValue(entries.get(0).getValue() - 1);
                k--;
            }
            Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
            //System.out.println(entries);
        }
        int op = 0;
        for (int i = 0; i < entries.size(); i++) {
            op += (entries.get(i).getValue() * entries.get(i).getValue());
        }
        return op;
    }
}