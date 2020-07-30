package leetCode.array.general;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/7/30 16:51
 * description �������
 * ����һ��������?n��������Ϊ���������������ĺͣ���ʹ��Щ�����ĳ˻���󻯡� ��������Ի�õ����˻���
 * ʾ�� 1:
 * ����: 2
 * ���: 1
 * ����: 2 = 1 + 1, 1 �� 1 = 1��
 * ʾ��?2:
 * ����: 10
 * ���: 36
 * ����: 10 = 3 + 3 + 4, 3 ��?3 ��?4 = 36��
 * ˵��: ����Լ���?n?��С�� 2 �Ҳ����� 58��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/integer-break
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class IntegerBreak {

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println("i = " + i);
    }

    public int integerBreak(int n) {

        if (n < 4) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }

        int mul = 1;
        while (n - 3 >= 2) {
            mul *= 3;
            n -= 3;
        }
        if (n > 0) {
            mul *= n;
        }

        return mul;
    }

    public int integerBreakDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

}
