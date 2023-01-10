package ru.ddark008.leetcode.leetcode;

public class L328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // 1, 2, 3, 4
        if (head == null || head.next == null) return head;
        ListNode odd = head;  //1,3
        ListNode even = odd.next; //2, 4
        ListNode evenHead = even;
        while (even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            if (odd.next != null) {
                even.next = odd.next;
                even = even.next;
            } else {
                even.next = null;
            }
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
