package algorithm.dynamicprogramming;

/**
 * @author liyu
 * @date 2020/1/2 17:19
 * @description ������������к�
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ�������������
 * ʾ��:
 * <p>
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class SumOfMaximalConsecutiveSubnumbers {
    public static void main(String[] args) {
        int a = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int b = maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int c = maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    /**
     * ����ȫ�������
     *
     * @param nums
     * @return
     */
    public static int maxSumSub(int[] nums) {
        //��֤�Ƿ�ȫ�Ǹ���
        int n = 0;
        int max = nums[0];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 0) {
                n++;
            }
            max = max > nums[j] ? max : nums[j];
        }
        if (n == nums.length) {
            return max;
        }

        return maxSubArray(nums);
    }

    /**
     * ��̬�滮
     * M[i] ��iΪĩ�˵����д�������
     * M[i]=Max{M[i-1]+A[i],0}
     *
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int[] M = new int[nums.length];
        int maxSum = 0;
        if (nums[0] > 0) {
            M[0] = nums[0];
        } else {
            M[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            M[i] = Math.max(M[i - 1] + nums[i], 0);
            maxSum = Math.max(M[i], maxSum);
        }
        return maxSum;
    }

    /**
     * ���������Խ��
     *
     * @param nums
     * @return
     */
    private static int maxSubArray2(int[] nums) {
        int maxSum = 0, nowMax = 0;
        for (int i = 0; i < nums.length; i++) {
            nowMax = nowMax + nums[i];
            if (nowMax < 0) {
                nowMax = 0;
                continue;
            } else {
                maxSum = Math.max(nowMax, maxSum);
            }
        }

        return maxSum;
    }

    /**
     * ��̬�滮
     * M[i] ��iΪ��ʼ�˵����д�������
     * M[i]=Max{M[i+1]+A[i],0}
     *
     * @param nums
     * @return
     */
    private static int maxSubArray3(int[] nums) {
        int[] M = new int[nums.length];
        int maxSum = 0;
        if (nums[nums.length-1] > 0) {
            M[nums.length-1] = nums[nums.length-1];
        } else {
            M[nums.length-1] = 0;
        }
        for (int i = nums.length; i > 1; i--) {
            M[i - 2] = Math.max(M[i-1] + nums[i - 2], 0);
            maxSum = Math.max(M[i - 2], maxSum);
        }
        return maxSum;
    }


}
