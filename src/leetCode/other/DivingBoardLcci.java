package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/7/8 9:28
 * @description ��ˮ��
 * ������ʹ��һ��ľ�彨����ˮ�塣���������͵�ľ�壬���г��Ƚ϶̵�ľ�峤��Ϊshorter�����Ƚϳ���ľ�峤��Ϊlonger��
 * ���������ʹ��k��ľ�塣��дһ��������������ˮ�����п��ܵĳ��ȡ�
 * ���صĳ�����Ҫ��С�������С�
 * ʾ����
 * ���룺
 * shorter = 1
 * longer = 2
 * k = 3
 * ����� {3,4,5,6}
 * ��Դ��https://leetcode-cn.com/problems/diving-board-lcci
 */
@UtilityClass
public class DivingBoardLcci {


    public static void main(String[] args) {
        int[] ints = divingBoard(1, 1, 0);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }

    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k + 1];
        for (int shorterNumber = k; shorterNumber >= 0; shorterNumber--) {
            int longerNumber = k - shorterNumber;
            res[longerNumber] = shorter * shorterNumber + longer * longerNumber;

        }
        return res;
    }
}
