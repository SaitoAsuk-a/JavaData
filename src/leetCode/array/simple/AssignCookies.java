package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * @author liyu
 * date 2020/12/25 15:44
 * description �ַ�����
 * ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ�
 * ��ÿ������ i������һ��θ��ֵ?g[i]���������ú���������θ�ڵı��ɵ���С�ߴ磻
 * ����ÿ����� j������һ���ߴ� s[j]?��
 * ��� s[j]?>= g[i]�����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣
 * ���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��
 * ʾ��?1:
 * <p>
 * ����: g = [1,2,3], s = [1,1]
 * ���: 1
 * ����:
 * �����������Ӻ�����С���ɣ�3�����ӵ�θ��ֵ�ֱ��ǣ�1,2,3��
 * ��Ȼ��������С���ɣ��������ǵĳߴ綼��1����ֻ����θ��ֵ��1�ĺ������㡣
 * ������Ӧ�����1��
 * ʾ��?2:
 * <p>
 * ����: g = [1,2], s = [1,2,3]
 * ���: 2
 * ����:
 * �����������Ӻ�����С���ɣ�2�����ӵ�θ��ֵ�ֱ���1,2��
 * ��ӵ�еı��������ͳߴ綼���������к������㡣
 * ������Ӧ�����2.
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <=?231 - 1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/assign-cookies
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class AssignCookies {
    public static void main(String[] args) {
        int contentChildren = findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println("contentChildren = " + contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        int count = 0, i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                count++;
            }
            j++;
        }

        return count;
    }
}
