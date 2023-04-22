package ru.ddark008.leetcode.leetcode;

public class L109_ConvertSortedListToBinarySearchTree {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int[] nodes;

        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            nodes = new int[getSize(head)];
            fillNodes(head);
            return buildTree(0, nodes.length - 1);
        }

                    // 0
            // 3            // 9
        //-10  // null  //5  // null

        // 0,4
        TreeNode buildTree(int l, int r) {
            if (l > r) {
                return null;
            } else if (l == r) {
                return new TreeNode(nodes[l]);
            } else {
                int m = (l + r + 1) / 2; //2
                var leftNode = buildTree(l, m - 1);
                var rightNode = buildTree(m + 1, r);
                return new TreeNode(nodes[m], leftNode, rightNode);
            }
        }

        void fillNodes(ListNode head) {
            int counter = 0;
            while (head != null) {
                nodes[counter++] = head.val;
                head = head.next;
            }
        }

        int getSize(ListNode head) {
            int result = 0;
            while (head != null) {
                head = head.next;
                result++;
            }
            return result;
        }
    }
}
