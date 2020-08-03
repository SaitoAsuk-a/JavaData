package leetCode.array.general;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/8/3 9:16
 * description �ַ������
 * ���������ַ�����ʽ�ķǸ�����?num1 ��num2?���������ǵĺ͡�
 * ע�⣺
 * num1 ��num2?�ĳ��ȶ�С�� 5100.
 * num1 ��num2 ��ֻ��������?0-9.
 * num1 ��num2 ���������κ�ǰ���㡣
 * �㲻��ʹ���κ΃Ƚ� BigInteger �⣬?Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class AddStrings {

    public static void main(String[] args) {
        String s = addStrings("1", "9");
        System.out.println("s = " + s);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int c = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || c > 0) {
            if (i >= 0 && j >= 0) {
                int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + c;
                sb.append(sum % 10);
                c = sum / 10;

            } else if (i >= 0 || j >= 0) {
                int sum = i >= 0 ? num1.charAt(i--) - '0' + c : +num2.charAt(j--) - '0' + c;
                sb.append(sum % 10);
                c = sum / 10;
            } else {
                sb.append(c);
                c = 0;
            }
        }
        return sb.reverse().toString();
    }
}
