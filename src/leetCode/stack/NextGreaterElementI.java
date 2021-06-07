package leetCode.stack;

import java.util.*;

/**
 * @author liyu
 * date 2021/6/7 15:50
 * description ��һ������Ԫ�� I
 * �������� û���ظ�Ԫ�� ������?nums1 ��?nums2?������nums1?��?nums2?���Ӽ���
 * �����ҳ� nums1?��ÿ��Ԫ����?nums2?�е���һ��������ֵ��
 * nums1?������?x?����һ������Ԫ����ָ?x?��?nums2?�ж�Ӧλ�õ��ұߵĵ�һ����?x?���Ԫ�ء���������ڣ���Ӧλ����� -1 ��
 * ʾ�� 1:
 * ����: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * ���: [-1,3,-1]
 * ����:
 * ���� num1 �е����� 4 �����޷��ڵڶ����������ҵ���һ����������֣������� -1 ��
 * ���� num1 �е����� 1 ���ڶ�������������1�ұߵ���һ���ϴ������� 3 ��
 * ���� num1 �е����� 2 ���ڶ���������û����һ����������֣������� -1 ��
 * ʾ�� 2:
 * ����: nums1 = [2,4], nums2 = [1,2,3,4].
 * ���: [3,-1]
 * ����:
 * ?   ���� num1 �е����� 2 ���ڶ��������е���һ���ϴ������� 3 ��
 * ���� num1 �е����� 4 ���ڶ���������û����һ����������֣������� -1 ��
 * ��ʾ��
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1��nums2���������� ������ͬ
 * nums1 �е���������ͬ�������� nums2 ��
 * ���ף���������һ��ʱ�临�Ӷ�Ϊ O(nums1.length + nums2.length) �Ľ��������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/next-greater-element-i
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        var nums1 = new int[]{7, 1, 2};
        var nums2 = new int[]{2, 3, 5, 1, 0, 7, 3};
        nextGreaterElement(nums1, nums2);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }

    /**
     * ����ջ
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // �ȴ��� nums2���Ѷ�Ӧ��ϵ�����ϣ��
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // ���� nums1 �õ������
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
