package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.PriorityQueue;

/**
 * @author liyu
 * date 2020/12/30 9:11
 * description ���һ��ʯͷ������
 * ��һ��ʯͷ��ÿ��ʯͷ������������������
 * ÿһ�غϣ�����ѡ���������ص�ʯͷ��Ȼ������һ����顣����ʯͷ�������ֱ�Ϊ?x ��?y����?x <= y����ô����Ŀ��ܽ�����£�
 * ���?x == y����ô����ʯͷ���ᱻ��ȫ���飻
 * ���?x != y����ô����Ϊ?x?��ʯͷ������ȫ���飬������Ϊ?y?��ʯͷ������Ϊ?y-x��
 * ������ֻ��ʣ��һ��ʯͷ�����ش�ʯͷ�����������û��ʯͷʣ�£��ͷ��� 0��
 * ʾ����
 * ���룺[2,7,4,1,8,1]
 * �����1
 * ���ͣ�
 * ��ѡ�� 7 �� 8���õ� 1����������ת��Ϊ [2,4,1,1,1]��
 * ��ѡ�� 2 �� 4���õ� 2����������ת��Ϊ [2,1,1,1]��
 * ������ 2 �� 1���õ� 1����������ת��Ϊ [1,1,1]��
 * ���ѡ�� 1 �� 1���õ� 0����������ת��Ϊ [1]����������ʣ���ǿ�ʯͷ��������
 * ��ʾ��
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/last-stone-weight
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class LastStoneWeight {

    public static void main(String[] args) {
        int i = lastStoneWeight(new int[]{2, 2});
        System.out.println("i = " + i);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
