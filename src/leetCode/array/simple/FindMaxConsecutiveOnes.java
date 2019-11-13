package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/13 15:10
 * @description ����һ�����������飬 ���������������1�ĸ�����
 * ʾ�� 1:
 * ����: [1,1,0,1,1,1]
 * ���: 3
 * ����: ��ͷ����λ��������λ��������1�������������1�ĸ����� 3.
 * ע�⣺
 * ���������ֻ���� 0 ��1��
 * ��������ĳ��������������Ҳ����� 10,000��
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int now = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                now++;
            } else {
                now = 0;
            }
            result = Math.max(now, result);
        }
        return result;

    }
}
