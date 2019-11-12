package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/12 17:49
 * @description ��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n �� min(ai, bi) �ܺ����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,4,3,2]
 * <p>
 * ���: 4
 * ����: n ���� 2, ����ܺ�Ϊ 4 = min(1, 2) + min(3, 4).
 * ��ʾ:
 * <p>
 * n ��������,��Χ�� [1, 10000].
 * �����е�Ԫ�ط�Χ�� [-10000, 10000
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = 1 + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
