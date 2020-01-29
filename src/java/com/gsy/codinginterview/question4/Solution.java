package com.gsy.codinginterview.question4;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * @author gongshiyun
 * @date 2020/1/27
 */
public class Solution {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.println(root);
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }


    /**
     * 递归重建二叉树
     *
     * @param pre     前序遍历序列
     * @param in      中序遍历序列
     * @param preLow  前序遍历序列低位下标
     * @param preHigh 前序遍历序列高位下标
     * @param inLow   后序遍历序列低位下标
     * @param inHigh  后序遍历序列高位下标
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int preLow, int preHigh, int inLow, int inHigh) {
        if (preHigh < preLow || inHigh < inLow) {
            return null;
        }

        // 前序遍历的第一个数是根结点
        int rootVal = pre[preLow];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inLow; i <= inHigh; i++) {
            if (in[i] == rootVal) {
                // 计算左子树的节点数量
                int leftTreeNodeNum = i - inLow;
                // 左子树前序遍历序列和右子树前序遍历序列的分割点下标
                int preMid = preLow + leftTreeNodeNum;
                root.left = reConstructBinaryTree(pre, in, preLow + 1, preMid, inLow, i);
                root.right = reConstructBinaryTree(pre, in, preMid + 1, preHigh, i + 1, inHigh);
            }
        }
        return root;
    }
}
