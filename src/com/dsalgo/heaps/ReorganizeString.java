package com.dsalgo.heaps;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Problem Link: https://leetcode.com/problems/reorganize-string/
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 */
class ReorganizeString {
    public String reorganizeString(String s) {
        int[] count =  new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }


        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a, b) -> count[b-'a'] - count[a-'a']);

        maxHeap.addAll(s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));

        StringBuilder sb =  new StringBuilder(s.length());
        while(maxHeap.size() > 1){
            char first = maxHeap.remove();
            char next = maxHeap.remove();

            sb.append(first);
            sb.append(next);

            count[first - 'a']--;
            count[next - 'a']--;
            if(count[first - 'a'] > 0){
                maxHeap.add(first);
            }
            if(count[next - 'a'] > 0){
                maxHeap.add(next);
            }
        }

        if(maxHeap.size() >  0){
            char c = maxHeap.remove();
            if(count[c-'a'] > 1){
                return "";
            }
            sb.append(c);
        }


        return sb.toString();
    }

}