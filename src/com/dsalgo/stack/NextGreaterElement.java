package com.dsalgo.stack;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 */
class NextGreaterElement
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] nle = new long[n];
        Stack<Long> stack =  new Stack();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()) nle[i] = -1;
            else{
                while(!stack.isEmpty() && arr[i] > stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()) nle[i] = -1;
                else nle[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nle;
    }
}