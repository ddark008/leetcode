package ru.ddark008.leetcode.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        TreeNode nextL = root.left;
        TreeNode nextR = root.right;
        return isSymmetric2(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode nextL, TreeNode nextR) {
        if (nextR == null && nextL == null) return true;
        return (nextR != null && nextL != null) && (nextL.val == nextR.val) && isSymmetric2(nextL.left, nextR.right) && isSymmetric2(nextL.right, nextR.left);
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
}
