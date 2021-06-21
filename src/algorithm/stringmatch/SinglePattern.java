package algorithm.stringmatch;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/3 15:48
 * @description ��ȷ�ַ���ƥ���㷨 ��ģʽƥ��
 * BF RK RM KMP
 * �����ı�T ��ΪT[0..n-10]
 * ƥ��ģʽP ��ΪP[0..m-10]
 */
public class SinglePattern {
    public static void main(String[] args) {
        String T = "bacbababacaca";
        String P = "ababaca";
        int i = bruteForceStringMath(T, P);
        int j = KMP(T, P);
        System.out.println("j = " + j);
        System.out.println("i = " + i);

//        String P = "abaabcac";
//        int[] ints = prefixTable(P);
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * ������
     *
     * @param T
     * @param P
     * @return
     */
    public static int bruteForceStringMath(String T, String P) {
        if (T.length() - P.length() < 0) {
            return 0;
        }
        int n = T.length();
        int m = P.length();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            while (j < m && T.charAt(i + j) == P.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }

        }
        return -1;
    }

    /**
     * maxL
     * ����KMP��ǰ׺��
     */
    public static int[] prefixTable(String P) {
        int[] prefixTable = new int[P.length()];
        int i = 1, j = 0;
        prefixTable[0] = 0;
        while (i < P.length()) {
            if (P.charAt(i) == P.charAt(j)) {
                prefixTable[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = prefixTable[j - 1];

            } else {
                i++;
            }
        }
        return prefixTable;
    }

    /**
     * KMP�㷨
     *
     * @param T
     * @param P
     * @return
     */
    public static int KMP(String T, String P) {
        int n = T.length();
        int m = P.length();
        int i = 0, j = 0;
        int[] ints = prefixTable(P);
        while (i < n) {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            } else if (j > 0) {
                j = ints[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // һֱ�ҵ�a[i]��b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // �ҵ�ƥ��ģʽ������
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    /**
     * ����nextL����
     * ֱ�Ӽ�������ȼ����maxL������һλ
     *
     * @param P
     * @return
     */
//    public static int[] nextTable(String P) {
//        int l = P.length();
//        int[] next = new int[l];
//        int i = 0;   // P ���±�
//        int j = -1;
//        next[0] = -1;
//
//        while (i < l) {
//            if (j == -1 || P.charAt(i) == P.charAt(j)) {
//                i++;
//                j++;
//                next[i] = j;
//            } else
//                j = next[j];
//        }
//        return next;
//    }

    private static final int SIZE = 256; // ȫ�ֱ������Ա����

    /**
     * ��ȡb��asciiֵ��Ӧ��λ��
     *
     * @param b  ģʽ��
     * @param m  ģʽ������
     * @param bc
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // ��ʼ��bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // ����b[i]��ASCIIֵ
            bc[ascii] = i;
        }
    }

    /**
     * ���ڻ��ַ������BM�㷨
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // ��¼ģʽ����ÿ���ַ������ֵ�λ��
        generateBC(b, m, bc); // �������ַ���ϣ��
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j��ʾ������ģʽ��ƥ��ĵ�һ���ַ�
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // ģʽ���Ӻ���ǰƥ��
                if (a[i + j] != b[j]) break; // ���ַ���Ӧģʽ���е��±���j
            }
            if (j < 0) {
                return i; // ƥ��ɹ�������������ģʽ����һ��ƥ����ַ���λ��
            }
            int x = j - bc[(int) a[i + j]];
            int y = 0;
            if (j < m - 1) { // ����кú�׺�Ļ�33|�ַ���ƥ��������У������ʵ���ı��༭���еĲ��ҹ��ܣ�
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j��ʾ���ַ���Ӧ��ģʽ���е��ַ��±�; m��ʾģʽ������
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // �ú�׺����
        if (suffix[k] != -1) return j - suffix[k] + 1;
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        return m;
    }

    // b��ʾģʽ���� m��ʾ���ȣ� suffix�� prefix���������������
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // ��ʼ��
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // ������׺�Ӵ�����
            while (j >= 0 && b[j] == b[m - 1 - k]) { // ��b[0, m-1]�󹫹���׺�Ӵ�
                --j;
                ++k;
                suffix[k] = j + 1; //j+1��ʾ������׺�Ӵ���b[0, i]�е���ʼ�±�
            }
            if (j == -1) prefix[k] = true; //���������׺�Ӵ�Ҳ��ģʽ����ǰ׺�Ӵ�
        }
    }
}
