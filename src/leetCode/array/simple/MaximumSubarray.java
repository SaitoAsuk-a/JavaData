package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/8 11:41
 * @description ����һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * <p>
 * ʾ��:
 * <p>
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
 * ����:
 * <p>
 * ������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
 */
public class MaximumSubarray {

    //��̬�滮��ʱ�临�Ӷ�o(n)��(���߳����Ž�)
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    //���η���ʱ�临�Ӷ�o(n)���ŵ��ǿ��Բ������㡣
    public int maxSubArray2(int[] nums) {
        return mergeCount(nums,0,nums.length)[2];
    }
    /**
     * @return Ƭ�δ��������飬����Ϊ����ͨ���ֵ����ͨ���ֵ���ֲ����ֵ���ܺ�
     * */
    public int[] mergeCount(int[] nums,int fromIndex,int toIndex){
        int[] result=new int[4];
        if(toIndex-fromIndex!=1){
            int midIndex=(toIndex+fromIndex)>>>1;
            int[] resL=mergeCount(nums,fromIndex,midIndex);
            int[] resR=mergeCount(nums,midIndex,toIndex);
            result[0]=Math.max(resL[0],resL[3]+resR[0]);
            result[1]=Math.max(resR[1],resL[1]+resR[3]);
            result[2]=Math.max(Math.max(resL[2],resR[2]),resL[1]+resR[0]);
            result[3]=resL[3]+resR[3];
            return result;
        }
        Arrays.fill(result,nums[fromIndex]);
        return result;
    }

}

