package leetCode.array.general;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/12/19 14:08
 * description ��תͼ��
 * ����һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 * ˵����
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 * ʾ�� 1:
 * ���� matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * ԭ����ת�������ʹ���Ϊ:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * ʾ�� 2:
 * ���� matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * ԭ����ת�������ʹ���Ϊ:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rotate-image
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class RotateImage {

    public static void main(String[] args) {
        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}});
        System.out.println("args = " + args);
    }

    public void rotate(int[][] matrix) {

        int length = matrix.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < (length / 2); i++) {
            for (int j = 0; j < (length - (2 * i) - 1); j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[length - 1 - i - j][i];
                matrix[length - 1 - i - j][i] = matrix[length - 1 - i][length - 1 - i - j];
                matrix[length - 1 - i][length - 1 - i - j] = matrix[i + j][length - 1 - i];
                matrix[i + j][length - 1 - i] = temp;
            }
        }

    }

}
