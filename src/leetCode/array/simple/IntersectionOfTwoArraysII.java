package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/7/13 8:58
 * @description ��������Ľ���
 * �����������飬��дһ���������������ǵĽ�����
 * ʾ�� 1:
 * ����: nums1 = [1,2,2,1], nums2 = [2,2]
 * ���: [2,2]
 * ʾ�� 2:
 * ����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * ���: [4,9]
 * ˵����
 * ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
 * ���ǿ��Բ�������������˳��
 * ����:
 * ��������������Ѿ��ź����أ��㽫����Ż�����㷨��
 * ���?nums1?�Ĵ�С��?nums2?С�ܶ࣬���ַ������ţ�
 * ���?nums2?��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
 * ��Դ��https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 */
@UtilityClass
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        System.out.println("Arrays.toString(intersect) = " + Arrays.toString(intersect));
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            Integer count = map.get(i);
            count = count == null ? 1 : count + 1;
            map.put(i, count);
        }
        for (int i : nums2) {
            Integer count = map.get(i);
            if (count != null && count > 0) {
                list.add(i);
                map.put(i, --count);
            }
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }

        return ints;
    }

    public int[] intersect0(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
