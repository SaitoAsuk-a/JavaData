package leetCode.array.simple;

/**
 * @author liyu
 * @date 2020/3/11 10:26
 * @description ����һ���ַ�����һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ�� 2k ���ַ���ǰk���ַ����з�ת�����ʣ������ k ���ַ�����ʣ�������ȫ����ת�������С�� 2k �����ڻ���� k ���ַ�����תǰ k ���ַ�������ʣ����ַ�����ԭ����
 *
 * ʾ��:
 * ����: s = "abcdefg", k = 2
 * ���: "bacdfeg"
 * Ҫ��:
 * ���ַ���ֻ����Сд��Ӣ����ĸ��
 * �����ַ����ĳ��Ⱥ� k ��[1, 10000]��Χ�ڡ�
 */
public class ReverseString2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k=3;
        String s1 = reverseStr(s, k);
        System.out.println("s1 = " + s1);
    }

    public static String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        int i = 0;
        boolean f = true;
        while (i < c.length+k) {
            if (i + k < c.length) {
                if (f) {

                    for (int j = i + k-1; j >= i; j--) {
                        sb.append(c[j]);
                    }
                } else {
                    for (int j = i; j < i + k; j++) {
                        sb.append(c[j]);
                    }
                }
                i = i + k;
                f=!f;
            } else if (i + k >= c.length) {
                if (f) {
                    for (int j = c.length - 1; j >= i; j--) {
                        sb.append(c[j]);
                    }
                } else {
                    for (int j = i; j < c.length; j++) {
                        sb.append(c[j]);
                    }
                }
                break;
            }

        }
        return sb.toString();
    }
}
