package algorithm.dynamicprogramming;

/**
 * @author liyu
 * @date 2020/1/2 18:48
 * @description ��֪����n��Ԫ�ص�����A(1)������A(2),����㷨Ѱ��һ������������A(i)������A(j)��ʹ�������е�Ԫ��֮�����Ҫ����Ѱѡȡ�������ڵ�Ԫ��
 */
public class MaxSumWithNoTwoContinuousNumbers {
    public static void main(String[] args) {
        int i = maxSumWithNoTwoContinuousNumbers(new int[]{-1, 4, 9, 2});
        System.out.println("i = " + i);
    }

    /**
     * M[i] iΪĩ�˵����������
     * M[i]
     * = A[1] ,n=1
     * = Max{A[1],A[2]},n=2
     * =max{M[n-2]+A[i],M[n-1]}
     *
     * @param A
     * @return
     */
    public static int maxSumWithNoTwoContinuousNumbers(int[] A) {
        int length = A.length;
        int[] M = new int[length];
        if (length == 1) {
            return A[0];
        } else if (length == 2) {
            return Math.max(A[0], A[1]);
        } else {
            int max = 0;
            for (int i = 2; i < length; i++) {
                M[i] = Math.max(M[i - 2] + A[i], M[i - 1]);
                max = Math.max(max, M[i]);
            }
            return max;
        }
    }
}
