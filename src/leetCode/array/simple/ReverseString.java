package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/12 17:37
 * @description
 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
 * ����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
 * ʾ�� 1��
 *
 * ���룺["h","e","l","l","o"]
 * �����["o","l","l","e","h"]
 * ʾ�� 2��
 *
 * ���룺["H","a","n","n","a","h"]
 * �����["h","a","n","n","a","H"]
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        char[]s={'h','e','l','l','o'};
        reverseString(s);
        System.out.println("s = " + Arrays.toString(s));

    }
    public static void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while (l<r){
            char t = s[l];
            s[l]=s[r];
            s[r]=t;
            l++;
            r--;
        }
    }
}
