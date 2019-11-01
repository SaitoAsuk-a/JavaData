package dataStructure.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//�� �ݹ�ڵ�ʵ�ַ�/��������ʾ�� ��ʾһ���������ڵ�
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTreeNode {
    /*
     * һ������������ ���ݡ����Һ��� ������
     */
    private int Data;
    private BinaryTreeNode LeftChild;
    private BinaryTreeNode RightChild;

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        LeftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return RightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        RightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "Data=" + Data +
                ", LeftChild=" + LeftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
