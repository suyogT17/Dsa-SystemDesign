package com.dsalgo.queue;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
 * Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If there is no such character then append '#' to the answer.
 *
 * Example 1:
 *
 * Input: A = "aabc"
 * Output: "a#bb"
 * Explanation: For every character first non
 * repeating character is as follow-
 * "a" - first non-repeating character is 'a'
 * "aa" - no non-repeating character so '#'
 * "aab" - first non-repeating character is 'b'
 * "aabc" - first non-repeating character is 'b'
 */
public class FirstNonRepeatingCharInString {
    public String FirstNonRepeating(String A)
    {
        // code here
        int[] count =  new int[26];
        String output = "";

        List<Character> list = new LinkedList();
        for(int i=0;i< A.length();i++){
            if(count[A.charAt(i)-'a'] == 0) list.add(A.charAt(i));
            count[A.charAt(i)-'a']++;
            char op = '#';
            for(char c: list){
                if(count[c - 'a'] == 1){
                    op = c;
                    break;
                }
            }
            output+=op;
        }
        return output;
    }
}
