package leetCode.array.general;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2020/4/17 10:38
 * @description ��Ծ��Ϸ
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ��λ�á�
 * <p>
 * ʾ��?1:
 * ����: [2,3,1,1,4]
 * ���: true
 * ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
 * ʾ��?2:
 * ����: [3,2,1,0,4]
 * ���: false
 * ����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{3, 2, 1, 0, 4};

        boolean b = canJump2(nums);
        System.out.println("b = " + b);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean flag = false;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                integers.add(i);
            }
        }
        AtomicInteger size = new AtomicInteger(integers.size());
        if (size.get() == 0) {
            return true;
        }
        integers.forEach(i -> {
            for (int j = 0; j < i; j++) {
                if (nums[j] > i - j) {
                    size.getAndDecrement();
                    break;
                }
            }
        });
        if (size.get() == 0) {
            flag = true;
        }
        return flag;
    }

    public static boolean canJump2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
