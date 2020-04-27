package leetCode.array.general;

/**
 * @author liyu
 * @date 2020/4/27 11:23
 * @description ������ת��������
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * ( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
 * ����Լ��������в������ظ���Ԫ�ء�
 * ����㷨ʱ�临�Ӷȱ�����?O(log?n) ����
 * <p>
 * ʾ�� 1:
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 * <p>
 * ʾ��?2:
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length < 1) {
            return -1;
        }
        int left = 0, right = length - 1;
        while ((left <= right)) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }
}
