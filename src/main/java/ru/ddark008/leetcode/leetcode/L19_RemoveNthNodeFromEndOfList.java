package ru.ddark008.leetcode.leetcode;

public class L19_RemoveNthNodeFromEndOfList {

   static public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(n > 0){
            n--;
            fast = fast.next;
        }

        while (fast.next != null){ // 0
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == head) return head.next;
        slow.next = slow.next.next;
        return head;
    }

    static ListNode make(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode iter = head;
        for (int i = 1; i<nums.length; i++) {
            iter.next = new ListNode(nums[i]);
            iter = iter.next;
        }
        return head;
    }
    static void print(ListNode head){
       StringBuffer sb = new StringBuffer();
       sb.append("{");
       ListNode pointer = head;
        while (pointer != null){
            sb.append(pointer.val).append(' ');
            pointer = pointer.next;
        }
        sb.append("}");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(removeNthFromEnd(make(new int[]{1,2,3,4,5}), 2));
        print(removeNthFromEnd(make(new int[]{1}), 1));
        print(removeNthFromEnd(make(new int[]{1,2}), 1));
    }
}
