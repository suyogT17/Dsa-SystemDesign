package com.dsalgo.stack;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
 * You are given two arrays A and B of unique elements of size N. Check if one array is a stack permutation of the other array or not.
 * Stack permutation means that one array can be created from another array using a stack and stack operations.
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * A = {1,2,3}
 * B = {2,1,3}
 * Output:
 * 1
 * Explanation:
 * 1. push 1 from A to stack
 * 2. push 2 from A to stack
 * 3. pop 2 from stack to B
 * 4. pop 1 from stack to B
 * 5. push 3 from A to stack
 * 6. pop 3 from stack to B
 */
class QueueUsingStack
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        // Your code here
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        // Your code here
        if(s1.isEmpty()) return -1;
        else{
            while(s1.size() > 1){
                s2.push(s1.pop());
            }
            int ans =  s1.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return ans;
        }
    }
}
