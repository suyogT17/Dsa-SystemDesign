package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://leetcode.com/problems/add-two-numbers/
 */
class Add2NumsUsingLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = null;
        int sum = 0, carry = 0;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(sum);
            if (result == null) {
                head = newNode;
                result = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            result.next = newNode;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}