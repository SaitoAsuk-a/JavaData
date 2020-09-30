package leetCode.tree;

/**
 * @author liyu
 * date 2020/9/30 15:04
 * description �����������еĲ������
 * ����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ���������������
 * ���ز��������������ĸ��ڵ㡣
 * �������ݱ�֤����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
 * ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ�
 * ����Է���������Ч�Ľ����
 * ����,
 * ��������������:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * �� �����ֵ: 5
 * ����Է����������������:
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * ���������Ҳ����Ч��:
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class InsertIntoBinarySearchTree {

    class TreeNode {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (val < temp.val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
