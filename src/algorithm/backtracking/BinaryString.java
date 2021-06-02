package algorithm.backtracking;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/3 15:16
 * @description ��������nλ���Ķ������ַ���
 */
public class BinaryString {
    static int n = 2;
    static int A[] = new int[n];

    public static void main(String[] args) {
//        printBinaryString(n);
////        K(n,10);
        System.out.println("true = " + (false||false||false&&true));
    }

    /**
     * һ�ֲ��÷��β��Խ�����������ķ�����
     *
     * @param n
     */
    public static void printBinaryString(int n) {
        if (n < 1) {
            System.out.println(Arrays.toString(A));
        } else {
            A[n - 1] = 1;
            printBinaryString(n - 1);
            A[n - 1] = 0;
            printBinaryString(n - 1);
        }
    }

    /**
     * ��չ����������nλ����K�����ַ���
     * @param n
     * @param k
     */
    public static void K(int n,int k) {
        if (n < 1) {
            System.out.println(Arrays.toString(A));
        } else {
            for (int i = 0; i < k; i++) {
                A[n - 1] = i;
                K(n - 1,k);
            }
        }
    }
}
