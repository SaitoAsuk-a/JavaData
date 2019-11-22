package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/14 12:12
 * @description �ƶ���
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * ʾ��:
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ˵��:
 * ������ԭ�����ϲ��������ܿ�����������顣
 * �������ٲ���������
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l] = nums[i];
                l++;
            }
        }
        for (int i = l; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                if(i != j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
