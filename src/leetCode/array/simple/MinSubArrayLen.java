package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/13 15:16
 * @description ����һ������ n ���������������һ�������� s ���ҳ���������������� �� s �ĳ�����С�����������顣��������ڷ������������������飬���� 0��
 * ʾ��:
 * ����: s = 7, nums = [2,3,1,2,4,3]
 * ���: 2
 * ����: ������ [4,3] �Ǹ������µĳ�����С�����������顣
 * ����:
 * ������Ѿ������O(n) ʱ�临�ӶȵĽⷨ, �볢�� O(n log n) ʱ�临�ӶȵĽⷨ��
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int nums[]={2,3,1,2,4,3};
        int i = minSubArrayLen(7, nums);
        System.out.println("i = " + i);
    }

    // ˫ָ�� : ��������
    public static int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        // �趨nums�����[l...r]����Ԫ��֮�ʹ��ڵ���s
        int l = 0, r = -1;
        int sum = 0;
        while (l < nums.length) {
            if (sum < s){
                if (r == nums.length - 1){
                    break;
                }
                sum += nums[r + 1];
                r++;
            } else {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        if (min == nums.length + 1) {
            return 0;
        }

        return min;

    }
}
