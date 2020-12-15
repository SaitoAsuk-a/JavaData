package leetCode.other;

/**
 * @author liyu
 * date 2020/12/15 10:41
 * description ��������������
 * @See https://leetcode-cn.com/problems/monotone-increasing-digits
 * ����һ���Ǹ�����?N���ҳ�С�ڻ����?N?������������ͬʱ���������Ҫ���������λ���ϵ������ǵ���������
 * �����ҽ���ÿ������λ���ϵ�����?x?��?y?����?x <= y?ʱ�����ǳ���������ǵ��������ġ���
 * ʾ�� 1:
 * ����: N = 10
 * ���: 9
 * ʾ�� 2:
 * ����: N = 1234
 * ���: 1234
 * ʾ�� 3:
 * ����: N = 332
 * ���: 299
 * ˵��: N?����?[0, 10^9]?��Χ�ڵ�һ��������
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        int i = monotoneIncreasingDigits(332);
        System.out.println("i = " + i);
    }
    public  static int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
