package algorithm.stringmatch;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/3 15:48
 * @description ��ȷ�ַ���ƥ���㷨
 * �����ı�T ��ΪT[0..n-10]
 * ƥ��ģʽP ��ΪP[0..m-10]
 */
public class MatchSameChildString {
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
}
