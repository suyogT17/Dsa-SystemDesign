package com.dsalgo.stack;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
class MinStack {
    Stack<Long> stack;
    long min = Long.MAX_VALUE;
    public MinStack() {
        stack = new Stack();
    }

    public void push(int val) {
        long val1 = val;
        if(stack.isEmpty()){
            stack.push(val1);
            min = val1;
        }
        else{
            if(val1 < min){
                stack.push(2*val1-min);
                min = val1;
            }
            else stack.push(val1);
        }
    }

    public void pop() {
        if(stack.isEmpty())  {
            return;
        }
        else if(stack.peek() < min){
            min = (2*min -stack.peek());
            stack.pop();

        }
        else  stack.pop();

    }

    public int top() {

        if(stack.isEmpty()) return -1;
        else if(stack.peek() <= min){
            return (int)min;

        }

        else return (int)(stack.peek()*1);
    }

    public int getMin() {
        return (int) min;
    }
}