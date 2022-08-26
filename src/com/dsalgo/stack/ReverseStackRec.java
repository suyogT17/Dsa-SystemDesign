package com.dsalgo.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-stack/1
 */
public class ReverseStackRec {
    static ArrayList<Integer> reverse(Stack<Integer> s) {
        // add your code here
        //System.out.println(s);
        reverseStack(s);
        //System.out.println(s);
        return new ArrayList<Integer>(s);
    }

    static void reverseStack(Stack<Integer> s) {
        if (s.size() == 1) return;
        int temp = s.pop();
        reverseStack(s);
        insert(s, temp);
    }

    static void insert(Stack<Integer> s, int temp) {
        if (s.isEmpty()) {
            s.push(temp);
            return;
        }
        int val = s.pop();
        insert(s, temp);
        s.push(val);
    }
}
