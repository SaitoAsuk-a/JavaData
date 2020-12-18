package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * @author liyu
 * date 2020/12/18 16:44
 * description �Ҳ�ͬ
 * ���������ַ��� s �� t������ֻ����Сд��ĸ��
 * �ַ���?t?���ַ���?s?������ţ�Ȼ�������λ�����һ����ĸ��
 * ���ҳ��� t �б���ӵ���ĸ��
 * ʾ�� 1��
 * ���룺s = "abcd", t = "abcde"
 * �����"e"
 * ���ͣ�'e' ���Ǹ�����ӵ���ĸ��
 * ʾ�� 2��
 * ���룺s = "", t = "y"
 * �����"y"
 * ʾ�� 3��
 * ���룺s = "a", t = "aa"
 * �����"a"
 * ʾ�� 4��
 * ���룺s = "ae", t = "aea"
 * �����"a"
 * ��ʾ��
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s �� t ֻ����Сд��ĸ
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-difference
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class FindTheDifference {
    public static void main(String[] args) {
        char theDifference = findTheDifference("ae", "aea");
        System.out.println("theDifference = " + theDifference);
    }
    public char findTheDifference(String s, String t) {
        int[] charSumArray = new int[26];
        Arrays.fill(charSumArray,0);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            charSumArray[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i)-'a';
            if(charSumArray[index]==0){
                return t.charAt(i);
            }
            charSumArray[index]--;
        }
        return ' ';
    }

    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
