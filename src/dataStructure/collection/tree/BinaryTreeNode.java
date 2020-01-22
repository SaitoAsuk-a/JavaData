package dataStructure.collection.tree;

import lombok.Data;

//�� �ݹ�ڵ�ʵ�ַ�/��������ʾ�� ��ʾһ���������ڵ�
@Data
public class BinaryTreeNode {
    /*
     * һ������������ ���ݡ����Һ��� ������
     */
    private int data;
    private BinaryTreeNode LeftChild;
    private BinaryTreeNode RightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    public String toString() {
        return "BinaryTreeNode{" +
                "Data=" + data +
                ", LeftChild=" + LeftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
