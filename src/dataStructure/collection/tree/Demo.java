package dataStructure.collection.tree;

import lombok.experimental.UtilityClass;
import sun.misc.Queue;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date 2020/1/20 17:25
 * @description �������������
 */
@UtilityClass
public class Demo {
    static int preIndex = 0;

    public static void main(String[] args) throws InterruptedException {

        //���Զ�����������
//        testBinaryTree();

        int inOrder[] = {8, 4, 2, 5, 1, 6, 3, 7};
        int preOrder[] = {1, 2, 4, 8, 5, 3, 6, 7};
        BinaryTreeNode binaryTreeNode = buildBinaryTree(inOrder, preOrder, 0, 7);


    }

    private static void testBinaryTree() throws InterruptedException {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);
        node4.setLeftChild(node8);

//        int nodeSizeOfBinaryTree = nodeSizeOfBinaryTree(root);
//        System.out.println("nodeSizeOfBinaryTree = " + nodeSizeOfBinaryTree);
//        int nodeSizeOfBinaryTree2 = nodeSizeOfBinaryTree2(root);
//        System.out.println("nodeSizeOfBinaryTree2 = " + nodeSizeOfBinaryTree2);
        int heightOfBinaryTree = heightOfBinaryTree(root);
        System.out.println("heightOfBinaryTree = " + heightOfBinaryTree);
        BinaryTreeNode deepestNode = getDeepestNode(root);
        System.out.println("deepestNode.getData() = " + deepestNode.getData());
        BinaryTreeNode mirror = mirrorOfBinaryTree(root);
        boolean mirror1 = isMirror(root, mirror);
        System.out.println("mirror1 = " + mirror1);
    }

    /**
     * �ݹ��������������
     *
     * @param root
     * @return
     */
    public int nodeSizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + nodeSizeOfBinaryTree(root.getLeftChild()) + nodeSizeOfBinaryTree(root.getRightChild());
        }
    }

    /**
     * ��α�������������ڵ���
     *
     * @param root
     * @return
     * @throws InterruptedException
     */
    public int nodeSizeOfBinaryTree2(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new Queue<>();
        binaryTreeNodeQueue.enqueue(root);
        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode temp = binaryTreeNodeQueue.dequeue();
            count++;
            if (temp.getLeftChild() != null) {
                binaryTreeNodeQueue.enqueue(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                binaryTreeNodeQueue.enqueue(temp.getRightChild());
            }
        }
        return count;
    }

    /**
     * �ݹ鷽ʽ��ȡ�������ĸ߶�
     *
     * @param root
     * @return
     */
    public int heightOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.getLeftChild());
        int rightHeight = heightOfBinaryTree(root.getRightChild());
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * ��ȡ������������
     *
     * @param root
     * @return
     */
    public BinaryTreeNode getDeepestNode(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new Queue<>();
        BinaryTreeNode temp = null;
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            if (temp.getLeftChild() != null) {
                queue.enqueue(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                queue.enqueue(temp.getRightChild());
            }
        }
        return temp;
    }

    /**
     * ���������
     *
     * @param root
     * @return
     */
    public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        mirrorOfBinaryTree(root.getLeftChild());
        mirrorOfBinaryTree(root.getRightChild());
        BinaryTreeNode temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
        return root;
    }

    /**
     * �ж��������Ƿ��Ǿ���
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        } else {
            return isMirror(root1.getLeftChild(), root2.getRightChild()) && isMirror(root1.getRightChild(), root2.getLeftChild());
        }
    }

    /**
     * �������������ǰ���������һ�ö�����
     *
     * @param inOrder
     * @param preOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    public static BinaryTreeNode buildBinaryTree(int inOrder[], int preOrder[], int inStart, int inEnd) {

        BinaryTreeNode treeNode = new BinaryTreeNode();
        if (inStart > inEnd || preIndex >= preOrder.length) {
            return null;
        }
        treeNode.setData(preOrder[preIndex]);
        //����preIndex��ǰ��������ѡ��ǰ�Ľ��
        Integer indexInPreOrder = findIndexInPreOrder(inOrder, preOrder[preIndex]);
        if (indexInPreOrder == null) {
            return null;
        }
        preIndex++;
        if (inStart == inEnd) {
            return treeNode;
        }
        treeNode.setLeftChild(buildBinaryTree(inOrder, preOrder, inStart, indexInPreOrder - 1));
        treeNode.setRightChild(buildBinaryTree(inOrder, preOrder, indexInPreOrder + 1, inEnd));
        return treeNode;
    }

    /**
     * LCA
     * ���Ҷ������н����ӽ��Ĺ�������
     * @param root
     * @param nodeA
     * @param nodeB
     * @return
     */
    public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode nodeA,BinaryTreeNode nodeB) {

        return new BinaryTreeNode();

    }

    /**
     * ����������������ָ��Ԫ��
     *
     * @param inOrder
     * @param data
     * @return
     */
    private static Integer findIndexInPreOrder(int[] inOrder, int data) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return null;
    }

}
