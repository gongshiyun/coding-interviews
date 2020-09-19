package com.gsy.codinginterview.question18;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author gongshiyun
 * @date 2020/9/19
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
