package ru.ddark008.leetcode.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L98_ValidateBinarySearchTree {
    Integer max = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (max == null || max < root.val) {
            max = root.val;
        } else return false;

        return isValidBST(root.right);
    }

    // Definition for a binary tree node.
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
}
