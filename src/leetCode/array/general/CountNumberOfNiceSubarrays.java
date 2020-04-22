package leetCode.array.general;

/**
 * @author liyu
 * @date 2020/4/21 14:10
 * @description ͳ�ơ����������顿
 * ����һ����������?nums ��һ������ k��
 * ���ĳ��������������ǡ���� k ���������֣����Ǿ���Ϊ����������ǡ����������项��
 * �뷵����������С����������项����Ŀ��
 * ʾ�� 1��
 * ���룺nums = [1,1,2,1,1], k = 3
 * �����2
 * ���ͣ����� 3 ���������������� [1,1,2,1] �� [1,2,1,1] ��
 * <p>
 * ʾ�� 2��
 * ���룺nums = [2,4,6], k = 1
 * �����0
 * ���ͣ������в������κ����������Բ��������������顣
 * <p>
 * ʾ�� 3��
 * ���룺nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * �����16
 * ��ʾ��
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2,1,1};
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int i = numberOfSubarrays2(nums, 2);
        System.out.println("i = " + i);
    }

    /**
     * ��ʱ
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            int nk = 0;
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    nk++;
                }
                if (nk == k) {
                    m++;
                }
                if (nk > k) {
                    break;
                }

            }
        }
        return m;
    }

    /**
     * ˫ָ�뷨
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // ˫ָ��
        int left = 0, right = 0;
        int count = 0; // �����������������ĸ���
        int res = 0;
        int preEven = 0; // ��¼��һ������ǰ���ż������
        while (right < nums.length){
            // ������������������������
            if (count < k){
                if (nums[right] % 2 != 0) count++;
                right++; // �ƶ��Ҳ�ָ��
            }
            // �����������������������ˣ�����һ������ǰ���ж��ٸ�ż��
            if (count == k) {
                preEven = 0;
                while (count == k){
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else res += preEven; // ÿ������ right Ϊż����ʱ��ͽ����ۼ� �൱������ǰ��ż������ * ����ż������
        }
        return res;
    }


}
