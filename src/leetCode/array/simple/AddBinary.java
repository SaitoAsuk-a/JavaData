package leetCode.array.simple;


import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/6/23 8:40
 * @description ���������
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 * ����Ϊ �ǿ� �ַ�����ֻ��������?1?��?0��
 * <p>
 * ʾ��?1:
 * <p>
 * ����: a = "11", b = "1"
 * ���: "100"
 * ʾ��?2:
 * <p>
 * ����: a = "1010", b = "1011"
 * ���: "10101"
 * ?
 * ��ʾ��
 * <p>
 * ÿ���ַ��������ַ� '0' �� '1' ��ɡ�
 * 1 <= a.length, b.length <= 10^4
 * �ַ���������� "0" ���Ͷ�����ǰ���㡣
 * <p>
 * ��Դ��https://leetcode-cn.com/problems/add-binary
 */
@UtilityClass
public  class AddBinary {

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String s = addBinary(a, b);
        System.out.println("s = " + s);
    }
    public String addBinary(String a, String b) {

        StringBuffer buffer = new StringBuffer();
        int c = 0;
        int al = a.length(), bl = b.length();
        int i = 0;

        while (i < al || i < bl) {
            c += (i < al ? Integer.parseInt(String.valueOf(a.charAt(al-i-1))) : 0);
            c += (i < bl ? Integer.parseInt(String.valueOf(b.charAt(bl-i-1))) : 0);
            buffer.append(c % 2);
            c = c / 2;
            i++;
        }
        if(c>0){
            buffer.append(1);
        }
        return buffer.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

}