package algorithm.dynamicprogramming;

import java.util.ArrayList;

/**
 * @author liyu
 * @date 2020/1/2 19:17
 * @description ����������Catalan Number��
 * n���ڵ�Ķ����������м���
 */
public class CatalanNumber {
    public static void main(String[] args) {
        int i = catalanNumber(5);
        System.out.println("i = " + i);
        int j = catalanNumber2(5);
        System.out.println("j = " + j);

    }

    /**
     * 1~n�����Ľ����б��
     * iΪ�����
     * Cn��ʾn��Ԫ�صĶ�������������
     * Ci-1 ��ʾ����������
     * Cn-i ��ʾ����������
     * Cn= ��Ci-1 *Cn-i (i=1,n)
     * �ݹ���ʽ
     *
     * @param n
     * @return
     */
    public static int catalanNumber(Integer n) {
        if (n == 0) {
            return 1;
        }
        int c = 0;
        for (int i = 1; i <= n; i++) {
            c += catalanNumber(i - 1) * catalanNumber(n - i);
        }
        return c;
    }

    /**
     * ��̬�滮
     */
    static int[] C = new int[1024];

    public static int catalanNumber2(Integer n) {
        C[0] = 1;
        if (C[n] != 0) {
            return C[n];
        }
        for (int i = 1; i <= n; i++) {
            C[n] += catalanNumber2(i - 1) * catalanNumber2(n - i);
        }
        return C[n];
    }
}
