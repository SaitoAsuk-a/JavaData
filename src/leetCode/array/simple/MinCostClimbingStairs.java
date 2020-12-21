package leetCode.array.simple;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/12/21 9:11
 * description ʹ����С������¥��
 * �����ÿ��������Ϊһ�����ݣ���?i�����ݶ�Ӧ��һ���Ǹ�������������ֵ?cost[i](������0��ʼ)��
 * ÿ��������һ�������㶼Ҫ���Ѷ�Ӧ����������ֵ��Ȼ�������ѡ�������һ�����ݻ������������ݡ�
 * ����Ҫ�ҵ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ�������Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
 * ʾ��?1:
 * ����: cost = [10, 15, 20]
 * ���: 15
 * ����: ��ͻ����Ǵ�cost[1]��ʼ��Ȼ�����������ɵ����ݶ���һ������15��
 * ?ʾ�� 2:
 * ����: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * ���: 6
 * ����: ��ͻ��ѷ�ʽ�Ǵ�cost[0]��ʼ�����������Щ1������cost[3]��һ������6��
 * ע�⣺
 * cost?�ĳ��Ƚ�����?[2, 1000]��
 * ÿһ��?cost[i] ������һ��Integer���ͣ���ΧΪ?[0, 999]��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int i = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println("i = " + i);
        int j = minCostClimbingStairs(new int[]{0, 0, 0, 1});
        System.out.println("j = " + j);
    }

    /**
     * dp[i]=min(dp[i?1]+cost[i?1],dp[i?2]+cost[i?2])
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int cur = 0;
        int pre = 0;
        for (int i = 2; i < length + 1; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
