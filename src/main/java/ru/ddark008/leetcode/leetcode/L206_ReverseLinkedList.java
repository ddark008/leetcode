package ru.ddark008.leetcode.leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L206_ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        ListNode rhead = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = rhead;
            rhead = head;
            head = next;
        }
        return rhead;
    }

    public ListNode reverseList2(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1, new ListNode(2));
        System.out.println(reverseList(n));
    }
  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}
