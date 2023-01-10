package ru.ddark008.leetcode.leetcode;

public class L234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        return helper(head, head) != null;
    }

    private ListNode helper(ListNode current, ListNode head) {
        ListNode r;
        if (current.next == null) {
            r = head;
        } else {
            r = helper(current.next, head);
        }
        if (r == null || r.val != current.val) {
            return null;
        } else {
            if (r.next == null) return r;
            return r.next;
        }
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode reversedHalf = reverse(middle.next);

        boolean result = true;
        ListNode p1 = head;
        ListNode p2 = reversedHalf;
        while(result && p2 != null){
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        reversedHalf = reverse(middle.next);
        middle.next = reversedHalf;
        return result;
    }


    private ListNode reverse(ListNode head){
        ListNode r = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = r;
            r = head;
            head = next;
        }
        return r;
    }


    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public class ListNode {
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
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */