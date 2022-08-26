package com.dsalgo.queue;

import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1
 *
 * Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
 * Note: one student may be selected by multiple classmates.
 *
 * Example 1:
 *
 * Input: N = 5, arr[] = {3, 8, 5, 2, 25}
 * Output: 2 5 2 -1 -1
 * Explanation:
 * 1. Roll number 1 has 3 marks. The first person
 * who has less marks than him is roll number 4,
 * who has 2 marks.
 * 2. Roll number 2 has 8 marks, he helps student
 * with 5 marks.
 * 3. Roll number 3 has 5 marks, he helps student
 * with 2 marks.
 * 4. Roll number 4 and 5 can not pick anyone as
 * no student with higher roll number has lesser
 * marks than them. This is denoted by -1.
 * Output shows the marks of the weaker student that
 * each roll number helps in order. ie- 2,5,2,-1,-1
 */
class NextSmallerElement {
    public static int[] help_classmate(int arr[], int n) {
        // Your code goes here
        int output[] = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                output[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) output[i] = -1;
                else output[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return output;
    }
}
