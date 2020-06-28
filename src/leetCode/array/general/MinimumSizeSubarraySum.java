package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/6/28 9:15
 * @description ������С��������
 * ����һ������?n?���������������һ��������?s ���ҳ���������������� �� s �ĳ�����С�����������飬�������䳤�ȡ�
 * ��������ڷ������������������飬���� 0��
 * ʾ��:?
 * ����: s = 7, nums = [2,3,1,2,4,3]
 * ���: 2
 * ����: ������?[4,3]?�Ǹ������µĳ�����С�����������顣
 * ����:������Ѿ������O(n) ʱ�临�ӶȵĽⷨ, �볢��?O(n log n) ʱ�临�ӶȵĽⷨ��
 * ��Դ��https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
@UtilityClass
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[]nums={2,3,1,2,4,3};
        int i = minSubArrayLen0(7, nums);
        System.out.println("i = " + i);
    }
    public int minSubArrayLen(int s, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (r < n) {
            sum += nums[r];
            while (sum >= s) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    public int minSubArrayLen0(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // Ϊ�˷�����㣬�� size = n + 1
        // sums[0] = 0 ��ζ��ǰ 0 ��Ԫ�ص�ǰ׺��Ϊ 0
        // sums[1] = A[0] ǰ 1 ��Ԫ�ص�ǰ׺��Ϊ A[0]
        // �Դ�����
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
