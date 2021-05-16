package leetCode.other;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyu
 * date 2020/12/26 11:37
 * description ������
 * ����һ��������?0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * �����6
 * ���ͣ�����������ͼ��ʾ��
 * ʾ�� 2��
 * ���룺matrix = []
 * �����0
 * ʾ�� 3��
 * ���룺matrix = [["0"]]
 * �����0
 * ʾ�� 4��
 * ���룺matrix = [["1"]]
 * �����1
 * ʾ�� 5��
 * ���룺matrix = [["0","0"]]
 * �����0
 * ��ʾ��
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] Ϊ '0' �� '1'
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximal-rectangle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximalRectangle {

    /**
     * ����һ: ʹ����״ͼ���Ż���������
     * ˼·���㷨
     * ��ԭʼ�أ����ǿ����о�ÿ�����ܵľ��Ρ�����ö�پ������п��ܵ����Ͻ���������½����꣬�����þ����Ƿ����Ҫ��Ȼ���÷�����ʱ�临�Ӷȹ��ߣ�����ͨ�����еĲ���������������Ǳ���Ѱ������������
     * �������ȼ���������ÿ��Ԫ�ص�������� 1 ��������ʹ�ö�ά���� left ��¼������left[i][j] Ϊ����� i �е� j ��Ԫ�ص�������� 1 ��������
     * ��󣬶��ھ���������һ���㣬����ö���Ըõ�Ϊ���½ǵ�ȫ 1 ���Ρ�
     * ������ԣ��������� matrix[i][j] Ϊ���½ǵľ���ʱ������ö������i0��k��i �����п��ܵ� k����ʱ���������Ⱦ�Ϊ
     * left[i][j],left[i?1][j],��,left[k][j]����Сֵ��
     *
     * <p>
     * ��ÿ�����ظ���һ���̣��Ϳ��Եõ�ȫ�ֵ������Ρ�
     * ����Ԥ��������ȵķ�����ʵ�Ͻ�����ת������һϵ�е���״ͼ���������ÿ����״ͼ������������
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    /**
     * ������������ջ
     * ˼·���㷨
     * �ڷ���һ�У����������˽������ֳ�һϵ�е���״ͼ��Ϊ�˼�����ε�������������ֻ��Ҫ����ÿ����״ͼ�е������������ҵ�ȫ�����ֵ��
     * ���ǿ���ʹ�á�84. ��״ͼ�����ľ��εĹٷ���⡹�еĵ���ջ������������Ӧ�����������ɵ���״ͼ�С�
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // ����ÿһ�У�ʹ�û�����״ͼ�ķ���
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

}
