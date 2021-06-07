package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyu
 * date 2021/6/7 10:01
 * description ����������
 * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 * ʾ�� 1��
 * ���룺s = "1 + 1"
 * �����2
 * ʾ�� 2��
 * ���룺s = " 2-1 + 2 "
 * �����3
 * ʾ�� 3��
 * ���룺s = "(1+(4+5+2)-3)+(6+8)"
 * �����23?
 * ��ʾ��
 * 1 <= s.length <= 3?* 105
 * s �����֡�'+'��'-'��'('��')'���� ' ' ���
 * s ��ʾһ����Ч�ı��ʽ
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/basic-calculator
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BasicCalculator {

    public static void main(String[] args) {
        int calculate = calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println("calculate = " + calculate);
    }

    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

}
