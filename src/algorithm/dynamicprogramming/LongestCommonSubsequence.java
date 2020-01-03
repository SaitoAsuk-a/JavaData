package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/2 13:57
 * @description �����������LCS
 * �����������
 * ʲô�������У�
 * ��������ַ���"saabcd"��s,a,a����һ�������У�s,a,b,dҲ��һ�������С������в�Ҫ�������ԡ�
 * ����������������������ӽṹ�����������Էֽ��Ϊ��С�����⣬�����������ͱ���ˡ�ͬʱ��������Ľ��Ϳ��Ա��ظ�ʹ�õģ�Ҳ����˵���߼��������������ø�С������Ľ⡣�����������Ժ󣬺����׾��뵽�ö�̬�滮����⡣
 * <p>
 * 1.���������ַ���s1, s2��������һ�����ĳ���Ϊ0ʱ�����������еĳ��ȿ϶�Ϊ0��
 * 2.����s1�ĵ�i���ַ���s2�ĵ�j���ַ����ʱ��������е���s1�ĵ�i-1���ַ���s2�ĵ�j-1���ַ�������г���+1��
 * 3.����s1�ĵ�i���ַ���s2�ĵ�j���ַ������ʱ��������е���s1�ĵ�i���ַ���s2�ĵ�j-1���ַ�������г��Ȼ�s1�ĵ�i-1���ַ���s2�ĵ�j���ַ�������г����������һ����
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int[][] ints = lcsLength(s1, s2);
        for (int i = 0; i < ints.length; i++) {
            String s = Arrays.toString(ints[i]);
            System.out.println(s);
        }
        String lcs = lcs(s1, s2);
        String lcs2 = lcs2(s1, s2);
        System.out.println("lcs = " + lcs);
        System.out.println("lcs2 = " + lcs2);
    }

    /**
     * �Ե�����
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int[][] lcsLength(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp;
    }

    public static String lcs(String s1, String s2) {
        int[][] dp = lcsLength(s1, s2);
        int l1 = s1.length();
        int l2 = s2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < l1 && j < l2) {

            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                j++;
                i++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return sb.toString();
    }


    /**
     * ��������
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int[][] lcsLength2(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public static String lcs2(String s1, String s2) {
        int[][] dp = lcsLength2(s1, s2);
        int i = s1.length(), j = s2.length();
        StringBuilder sb = new StringBuilder();
        while (i >= 1 && j >= 1) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    // ˵����ͬ���ַ�������ߣ��´α�����ʱ��Ӧ����ͬһ�У�����ǰ��һ������j--
                    j--;
                } else {
                    i--;
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
