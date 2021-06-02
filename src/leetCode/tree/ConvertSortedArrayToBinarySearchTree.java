package leetCode.tree;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/7/3 8:46
 * @description ����������ת��Ϊ����������
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 * ʾ��:
 * ������������: [-10,-3,0,5,9],
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 * 0
 * /   \
 * -3    9
 * /    /
 * -10  5
 * <p>
 * ��Դ����https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
@UtilityClass
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int nums[]={-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }


    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * ̰�Ĺ���
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
