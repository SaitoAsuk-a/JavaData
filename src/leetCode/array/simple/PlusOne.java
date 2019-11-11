package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/11 13:35
 * @description ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 * <p>
 * ʾ��?1:
 * ����: [1,2,3]
 * ���: [1,2,4]
 * ����: ���������ʾ���� 123��
 * ʾ��?2:
 * ����: [4,3,2,1]
 * ���: [4,3,2,2]
 * ����: ���������ʾ���� 4321��
 */
public class PlusOne {
    public static void main(String[] args) {
        int digits[]={1,2,3};
        int[] ints = plusOne(digits);
        System.out.println("ints = " + Arrays.toString(ints));
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            digits[i]++;
            digits[i]=digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
