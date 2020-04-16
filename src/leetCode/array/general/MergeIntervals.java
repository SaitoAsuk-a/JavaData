package leetCode.array.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liyu
 * @date 2020/4/16 15:41
 * @description �ϲ�����
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 * ʾ�� 1:
 * ����: [[1,3],[2,6],[8,10],[15,18]]
 * ���: [[1,6],[8,10],[15,18]]
 * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 * ʾ��?2:
 * ����: [[1,4],[4,5]]
 * ���: [[1,5]]
 * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-intervals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {

        // �Ȱ���������ʼλ������
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // ��������
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // �����������ǿյģ����ߵ�ǰ�������ʼλ�� > �������������������ֹλ�ã�
            // �򲻺ϲ���ֱ�ӽ���ǰ������������顣
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // ��֮����ǰ����ϲ������������������
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
