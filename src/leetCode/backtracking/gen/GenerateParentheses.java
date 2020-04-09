package leetCode.backtracking.gen;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2020/4/9 9:15
 * @description ��������
 * ���� n?�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ�����Ч��������ϡ�
 * ʾ����
 * ���룺n = 3
 * �����[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/generate-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generator(list, n, new StringBuilder(), 0, 0);
        dfs("", 0, 0, n, new ArrayList<>());
        System.out.println("list = " + list);
        return list;

    }

    /**
     * ��������
     *
     * @param result �����
     * @param n
     * @param cur
     * @param left   �����Ÿ���
     * @param right  �����Ÿ���
     */
    public void generator(List<String> result, int n, StringBuilder cur, int left, int right) {
        if (cur.length() == 2 * n) {
            result.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append("(");
            generator(result, n, cur, left + 1, right);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(")");
            generator(result, n, cur, left, right + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * ������һ��������ע��������ݵ���cur��û�б�
     *
     * @param curStr ��ǰ�ݹ�õ��Ľ��
     * @param left   �������Ѿ����˼���
     * @param right  �������Ѿ����˼���
     * @param n      �����š�������һ�����ü���
     * @param res    �����
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // ��֦
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    /**
     * ��̬�滮��ʽ
     *�� 1 ��������״̬ dp[i]��ʹ�� i �������ܹ����ɵ���ϡ�
     *
     * �� 2 ����״̬ת�Ʒ��̣�
     * i �����ŵ�һ����ϣ��� i - 1 �����ŵĻ����ϵõ�������˼�� ��״̬ת�Ʒ��̡� �Ļ�����
     * i �����ŵ�һ����ϣ�һ���������� "(" ��ʼ����һ���� ")" ��β��Ϊ�ˣ����ǿ���ö���µ������� ")" ����������λ�ã��õ����е���ϣ�
     * ö�ٵķ�ʽ����ö�������� "(" �������� ")" �м���ܵĺϷ������Ŷ�������ʣ�µĺϷ������Ŷ��������һ�������� "(" ��Ե������� ")" �ĺ��棬����õ�����ǰ��״̬��
     * ״̬ת�Ʒ����ǣ�
     * dp[i] = "(" + dp[���ܵ����Ŷ���] + ")" + dp[ʣ�µ����Ŷ���]
     * �����ܵ����Ŷ����� �� ��ʣ�µ����Ŷ����� ֮�͵�Ϊ i - 1���� �����ܵ����Ŷ����� j ���Դ� 0 ��ʼ����಻�ܳ��� i�� �� i - 1��
     * ��ʣ�µ����Ŷ����� + j = i - 1���� ��ʣ�µ����Ŷ����� = i - j - 1��
     * ����ã�
     * dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
     *
     *�� 3 ���� ˼����ʼ״̬�������
     * ��ʼ״̬����Ϊ������Ҫ 0 ����������״̬�����״̬���� dp �� 0 ��ʼ��0 �����ŵ�Ȼ���� [""]��
     * �����dp[n] ��
     * ����������Ҿͽ�����̬�滮����ô��Ҳ�Ǻ�����ģ��������������ص㣺
     * 1���Ե����ϣ���С��ģ���⿪ʼ���𽥵õ����ģ����Ľ⼯��
     * 2���޺�Ч�ԣ�����Ľ���ĵõ�������Ӱ�쵽ǰ��Ľ����
     * @param n
     * @return
     */
    public List<String> generateParenthesisDY(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // ���� dp �������ǰ�������б�����ӣ�������ö���
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // ö�������ŵ�λ��
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }


}
