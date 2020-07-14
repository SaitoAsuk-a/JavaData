package leetCode.dp;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyu
 * @date 2020/7/14 8:47
 * @description ��������С·����
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 * ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
 * ���磬���������Σ�
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ?11������2?+?3?+?5?+?1?= 11����
 * ˵����
 * ��������ֻʹ�� O(n)?�Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�
 * ��Դ��https://leetcode-cn.com/problems/triangle
 */

@UtilityClass
public class Triangle {

    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(2);
        List<Integer> list1 = Arrays.asList(3, 4);
        List<Integer> list2 = Arrays.asList(6, 5, 7);
        List<Integer> list3 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        int i = minimumTotal(triangle);
        System.out.println("i = " + i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if (n < 1) {
            return 0;
        }

        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = triangle.get(i).get(j) + dp[j];
                } else if (j < i && j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                } else {
                    dp[j] = triangle.get(i).get(j) + dp[j - 1];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = min > i ? i : min;
        }
        return min;
    }
}
