package leetCode.array.simple;

import lombok.experimental.UtilityClass;

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
@UtilityClass
public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        String s1 = reverseWords(s);
        System.out.println("s1 = " +s1);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] c = s.split("\\s+");
        if (c.length < 2) {
            return s;
        }
        StringBuffer bf = new StringBuffer();
        for (int i = c.length - 1; i > 0; i--) {
            bf.append(c[i]+" ");
        }
        bf.append(c[0]);
        return bf.toString();
    }
}
