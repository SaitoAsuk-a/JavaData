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
//        String T = "qwewertw";
//        String P = "we";
//        int i = bruteForceStringMath(T, P);
//        System.out.println("i = " + i);

        String P = "abaabcac";
        int[] ints = prefixTable(P, new int[P.length()]);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
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
        int n = T.length() - P.length() + 1;
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < P.length(); j++) {
                if (T.charAt(i + j) != P.charAt(j)) {
                    break;
                } else if (j == P.length() - 1) {
                    s++;
                }
            }
        }
        return s;
    }

    /**
     * ����KMP��ǰ׺��
     */
    public static int[] prefixTable(String P, int[] prefixTable) {
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

}
