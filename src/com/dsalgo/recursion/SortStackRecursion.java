package com.dsalgo.recursion;

import java.util.Stack;

public class SortStackRecursion {

    public static void main(String[] args) {

        Stack<Integer> stack =  new Stack<>();
        stack.push(0);
        stack.push(6);
        stack.push(2);
        stack.push(1);
        stack.push(5);


        sort(stack);

        while(!stack.isEmpty()) System.out.println(stack.pop());

    }

    static void sort(Stack<Integer> stack){
        if(stack.size() == 1 ) return;
        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    static void insert(Stack<Integer> stack, int temp){
        if(stack.isEmpty() || stack.peek() >= temp) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

}
