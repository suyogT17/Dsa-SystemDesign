package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1
 */
class MultiplyTwoNumsInLL {
    public long multiplyTwoLists(Node l1, Node l2) {
        Node curr = l1;
        long num1 = 0L;
        long mod = 1000000007;
        while (curr != null) {
            num1 = ((num1 * 10) + curr.data) % mod;
            curr = curr.next;
        }
        curr = l2;
        long num2 = 0L;
        while (curr != null) {
            num2 = ((num2 * 10) + curr.data) % mod;
            curr = curr.next;
        }
        return ((num1) * (num2)) % mod;
    }
}