package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liyu
 * @date 2019/11/8 9:02
 * @description ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 * <p>
 * ʾ��:
 * ���� nums = [2, 7, 11, 15], target = 9
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 */
@UtilityClass
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 8};
        int t = 8;
        int[] ints1 = twoSum(ints, t);
        int[] ints2 = twoSum2(ints, t);
        System.out.println("ints2 = " + Arrays.toString(ints2));//��
        System.out.println("ints1 = " + Arrays.toString(ints1));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (integerIntegerHashMap.containsKey(complete)) {
                return new int[]{integerIntegerHashMap.get(complete), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (complete == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

    }

}
