package com.dsalgo.stack;

import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/sort-a-stack/1
 */
class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortElements(s);
        return s;
    }

    void sortElements(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int temp = s.pop();
        sort(s);
        insert(s, temp);
    }

    void insert(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() <= temp) {
            s.push(temp);
            return;
        }
        int val = s.pop();
        insert(s, temp);
        s.push(val);
    }
}