package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;


public class _0110 {
    private boolean isBalanced1(TreeNode root) {
        // 1.递归终止的条件
        if (root == null)
            return true;

        // 2.找返回值
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        int abs_depth = Math.abs(left_depth - right_depth);

        boolean left_isB = isBalanced1(root.left);
        boolean right_isB = isBalanced1(root.right);

        // 3.本级递归应该做什么
        return abs_depth<=1 && left_isB && right_isB;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return GetDepth(root) != -1;
    }

    private int GetDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = GetDepth(node.left);
        if (left == -1) return -1; // 剪枝
        int right = GetDepth(node.right);
        if (right == -1) return -1; // 剪枝
        return Math.abs(left-right)>1 ? -1 : Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        _0110 Sol = new _0110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(Sol.isBalanced1(root));
    }
}
