package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liyu
 * @date 2020/7/7 8:56
 * @description ·���ܺ�
 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ��:?
 * �������¶��������Լ�Ŀ��� sum = 22��
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2
 * ��Դ��https://leetcode-cn.com/problems/path-sum
 */
public class PathSum {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * �ݹ�
     * ˼·���㷨
     * �۲�Ҫ��������ɵĺ��������ǿ��Թ��ɳ����Ĺ��ܣ�ѯ���Ƿ���ڴӵ�ǰ�ڵ� root ��Ҷ�ӽڵ��·����������·����Ϊ sum��
     * �ٶ��Ӹ��ڵ㵽��ǰ�ڵ��ֵ֮��Ϊ val�����ǿ��Խ����������ת��Ϊһ��С���⣺�Ƿ���ڴӵ�ǰ�ڵ���ӽڵ㵽Ҷ�ӵ�·����������·����Ϊ sum - val��
     * ���ѷ���������ݹ�����ʣ�����ǰ�ڵ����Ҷ�ӽڵ㣬��ô����ֱ���ж� sum �Ƿ���� val ���ɣ���Ϊ·�����Ѿ�ȷ�������ǵ�ǰ�ڵ��ֵ��
     * ����ֻ��Ҫ�жϸ�·�����Ƿ�����������������ǰ�ڵ㲻��Ҷ�ӽڵ㣬����ֻ��Ҫ�ݹ��ѯ�������ӽڵ��Ƿ��������������ɡ�
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * BFS
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum0(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeNodesQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        treeNodesQueue.add(root);
        sumQueue.add(root.val);

        while (!treeNodesQueue.isEmpty()) {

            TreeNode node = treeNodesQueue.poll();
            Integer nodeSum = sumQueue.poll();

            if (node.left == null && node.right == null) {
                if (sum == nodeSum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                treeNodesQueue.offer(node.left);
                sumQueue.offer(nodeSum + node.left.val);
            }
            if (node.right != null) {
                treeNodesQueue.offer(node.right);
                sumQueue.offer(nodeSum + node.right.val);
            }
        }

        return false;

    }

    public boolean hasPathSum1(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stack.push(root);
        stackSum.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer tempSum = stackSum.pop();

            if (node.left == null && node.right == null) {
                if (sum == tempSum) {
                    return true;
                }
                continue;
            }

            if(node.left != null){
                stack.push(node.left);
                stackSum.push(node.left.val+tempSum);
            }
            if(node.right != null){
                stack.push(node.right);
                stackSum.push(node.right.val+tempSum);
            }
        }

        return false;

    }


}
