package leetCode.array.hard;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liyu
 * date 2020/8/1 9:00
 * description ��С����
 * ����?k?���������е��������顣�ҵ�һ����С���䣬ʹ��?k?���б��е�ÿ���б�������һ�������������С�
 * ���Ƕ������?b-a < d-c?������?b-a == d-c?ʱ?a < c�������� [a,b] �� [c,d] С��
 * ʾ�� 1:
 * ����:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * ���: [20,24]
 * ����:
 * �б� 1��[4, 10, 15, 24, 26]��24 ������ [20,24] �С�
 * �б� 2��[0, 9, 12, 20]��20 ������ [20,24] �С�
 * �б� 3��[5, 18, 22, 30]��22 ������ [20,24] �С�
 * ע��:
 * �������б���ܰ����ظ�Ԫ�أ����������������ʾ >= ��
 * 1 <= k <= 3500
 * -105 <= Ԫ�ص�ֵ?<= 105
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {

    }

    /**
     * ��
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(next[index])));
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

}