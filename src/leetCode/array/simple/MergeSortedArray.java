package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/11 17:05
 * @description ��������������������?nums1 �� nums2���� nums2 �ϲ���?nums1?�У�ʹ��?num1 ��Ϊһ���������顣
 * ˵��:
 * ��ʼ��?nums1 �� nums2 ��Ԫ�������ֱ�Ϊ?m �� n��
 * ����Լ���?nums1?���㹻�Ŀռ䣨�ռ��С���ڻ����?m + n�������� nums2 �е�Ԫ�ء�
 * ʾ��:
 * ����:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * ���:?[1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0},nums2={2,5,6};
        merge2(nums1,3,nums2,3);
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
    }

    //ʱ�临�Ӷ� : O((n+m)log(n+m))��
    //�ռ临�Ӷ� : O(1)��
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    //ʱ�临�Ӷ� : O(n+m)��
    //�ռ临�Ӷ� : O(m)��
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    //ʱ�临�Ӷ� : O(n+m)��
    //�ռ临�Ӷ� : O(1)��
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
