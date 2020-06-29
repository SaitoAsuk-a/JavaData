package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/6/29 8:43
 * @description �����еĵ�K�����Ԫ��
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * ʾ��?2:
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 * ˵��:
 * ����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
 * <p>
 * ��Դ��https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */

@UtilityClass
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest1(nums, 4);
        System.out.println("kthLargest = " + kthLargest);
    }

    /**
     * �⺯������
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * ��С��
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest0(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * ���ٲ���
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        Random random = new Random();
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
