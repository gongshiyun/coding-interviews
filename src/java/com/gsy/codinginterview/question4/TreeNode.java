package com.gsy.codinginterview.question4;

/**
 * @author gongshiyun
 * @date 2020/1/27
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
