package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/12 15:49
 * @description ʵ�� strStr() ������
 * ����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
 * ʾ�� 1:
 * ����: haystack = "hello", needle = "ll"
 * ���: 2
 * ʾ�� 2:
 * ����: haystack = "aaaaa", needle = "aaaaa"
 * ���: -1
 * ˵��:
 * �� needle �ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣
 * ���ڱ�����ԣ��� needle �ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե� strstr() �Լ� Java�� indexOf() ���������
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
        int i = strStr(haystack, needle);
        System.out.println("i = " + i);
        System.out.println("haystack = " + haystack.indexOf(needle));
    }
    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int flg = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

            } else {
                flg++;
                i=flg;
                j = 0;
            }
        }
        if ((haystack.length()-flg<needle.length())||needle.length()>haystack.length()){
            return -1;
        }

            return flg;
    }
}
