package leetCode.array.simple;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liyu
 * @date 2019/11/14 9:00
 * @description ��ת�ַ�����ĵ���
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 * ʾ�� 1��
 * ����: "the sky is blue"
 * ���: "blue is sky the"
 * ʾ�� 2��
 * ����: "  hello world!  "
 * ���: "world! hello"
 * ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ʾ�� 3��
 * ����: "a good   example"
 * ���: "example good a"
 * ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 * �޿ո��ַ�����һ�����ʡ�
 * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s= "     hello world!  ";
        int c = s.charAt(0);
        int c1 = s.charAt(2);
        System.out.println("c = " + c);
        System.out.println("c1 = " + c1);
        String[] s1 = s.split(" ");
        System.out.println("s1 = " + Arrays.toString(s1));
    }

    public String reverseWords(String s) {

        return s;
    }
}
