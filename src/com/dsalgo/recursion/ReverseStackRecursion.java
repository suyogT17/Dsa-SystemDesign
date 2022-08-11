package com.dsalgo.recursion;

import java.util.Stack;

public class ReverseStackRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack =  new Stack<>();
        stack.push(0);
        stack.push(6);
        stack.push(2);
        stack.push(1);
        stack.push(5);

        stack.stream().forEach(System.out::print);

        reverse(stack);
        System.out.println();

        stack.stream().forEach(System.out::print);
    }

    static void reverse(Stack<Integer> stack){
        if (stack.size() == 1) return;
        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {

        if(stack.isEmpty()){
            stack.push(temp);
            return;
        }
        int val  =  stack.pop();
        insert(stack, temp);
        stack.push(val);

    }

}
