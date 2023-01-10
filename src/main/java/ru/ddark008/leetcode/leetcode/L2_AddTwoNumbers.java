package ru.ddark008.leetcode.leetcode;

public class L2_AddTwoNumbers {
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
    class Solution {
        // {9} {999}
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int n = 0;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (l1 !=null || l2 !=null || n > 0){
                int v1 = 0; //0
                if (l1 != null){
                    v1 = l1.val;
                    l1 = l1.next;
                }
                int v2 = 0; //9
                if (l2 != null){
                    v2 = l2.val;
                    l2 = l2.next;
                }
                int s = v1 + v2 + n; //1
                n = s/10; //1
                p.next = new ListNode(s%10); //8001
                p = p.next;
            }
            return dummy.next;
        }
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
