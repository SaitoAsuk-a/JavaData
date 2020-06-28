package leetCode.array.general;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/6/24 9:26
 * @description ��ӽ�������֮��
 * ����һ������?n ������������?nums?�� һ��Ŀ��ֵ?target���ҳ�?nums?�е�����������ʹ�����ǵĺ���?target?��ӽ���
 * �������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * ʾ����
 * ���룺nums = [-1,2,1,-4], target = 1
 * �����2
 * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
 * ��ʾ��
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3?<= nums[i]?<= 10^3
 * -10^4?<= target?<= 10^4
 * <p>
 * ��Դ��https://leetcode-cn.com/problems/3sum-closest
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
        int[] nums = {0, 2, 1, -3};
        int i = threeSumClosest(nums, 1);
        System.out.println("i = " + i);
    }

    public static int threeSumClosest(int[] nums, int target) {

        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int abs = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    int abs1 = Math.abs(target - sum);
                    int i1 = nums[i] + nums[j] + nums[k];
                    if (abs == 0) {
                        return i1;
                    }
                    sum = abs1 <= abs ? sum : i1;
                }
            }
        }
        return sum;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // ö�� a
        for (int i = 0; i < n; ++i) {
            // ��֤����һ��ö�ٵ�Ԫ�ز����
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ʹ��˫ָ��ö�� b �� c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // �����Ϊ target ֱ�ӷ��ش�
                if (sum == target) {
                    return target;
                }
                // ���ݲ�ֵ�ľ���ֵ�����´�
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // ����ʹ��� target���ƶ� c ��Ӧ��ָ��
                    int k0 = k - 1;
                    // �ƶ�����һ������ȵ�Ԫ��
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // �����С�� target���ƶ� b ��Ӧ��ָ��
                    int j0 = j + 1;
                    // �ƶ�����һ������ȵ�Ԫ��
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
