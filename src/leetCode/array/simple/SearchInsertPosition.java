package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/8 10:57
 * @description ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * ����Լ������������ظ�Ԫ�ء�
 * ʾ�� 1:
 * ����: [1,3,5,6], 5
 * ���: 2
 * ʾ��?2:
 * ����: [1,3,5,6], 2
 * ���: 1
 * ʾ�� 3:
 * ����: [1,3,5,6], 7
 * ���: 4
 * ʾ�� 4:
 * ����: [1,3,5,6], 0
 * ���: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int i = searchInsert(nums, target);
        System.out.println("i = " + i);
        int index = Arrays.binarySearch(nums, target);
        if(index>0){
            System.out.println("index = " + index);
        }else {
            index=-index-1;
            System.out.println("-index = " + index);
        }
    }

    //��������
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length && nums[i] < target; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return i;
    }

    //���ֲ���ʵ��
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
