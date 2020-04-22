package leetCode.tree;

import java.util.*;

/**
 * @author liyu
 * @date 2020/4/22 9:15
 * @description ������������ͼ
 * ����һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 * ʾ��:
 * ����:?[1,2,3,null,5,null,4]
 * ���:?[1, 3, 4]
 * ����:
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-tree-right-side-view
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BinaryTreeRightSideView {

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // ά����������������
                max_depth = Math.max(max_depth, depth);

                // ��������ڶ�Ӧ��ȵĽڵ����ǲŲ���
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        dfs(rightView, root, 0);
        return rightView;
    }

    public void dfs(List<Integer> rightView, TreeNode root, int dep) {
        if (root != null) {
            if (dep == rightView.size()) {
                rightView.add(root.val);
            }
            dfs(rightView, root.right, dep + 1);
            dfs(rightView, root.left, dep + 1);
        }
    }

    /**
     * bfs
     * @param root
     * @return
     */
    public List<Integer> rightSideView3(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                // ά����������������
                max_depth = Math.max(max_depth, depth);

                // ����ÿһ�����һ�����ʵ��Ľڵ��������Ҫ�Ĵ𰸣���˲��ϸ��¶�Ӧ��ȵ���Ϣ����
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
