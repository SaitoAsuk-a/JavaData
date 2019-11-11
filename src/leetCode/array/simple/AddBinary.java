package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/11 19:08
 * @description ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 * ����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��
 * <p>
 * ʾ�� 1:
 * ����: a = "11", b = "1"
 * ���: "100"
 * ʾ�� 2:
 * ����: a = "1010", b = "1011"
 * ���: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "110010";
        String b="110010";;
        String s = addBinary(a, b);
        System.out.println("s = " + s);
    }

    public static String addBinary(String a, String b) {
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int sum = 0;
        String result = "";
        while (alen >= 0 || blen >= 0) {
            if (alen >= 0) {
                sum += Integer.parseInt(a.substring(alen, alen + 1));
                alen--;
            }
            if (blen >= 0) {
                sum += Integer.parseInt(b.substring(blen, blen + 1));
                blen--;
            }
            if (sum == 0 || sum == 1) {
                result = sum + result;
                sum=0;
            } else {
                result = (sum - 2) + result;
                sum = 1;
            }
        }
        if (sum == 1) {
            result = "1" + result;
        }
        return result;
    }
}
