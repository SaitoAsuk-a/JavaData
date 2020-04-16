package leetCode.array.general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * @date 2020/4/15 8:51
 * @description 01����
 * ����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣
 * ��������Ԫ�ؼ�ľ���Ϊ 1 ��
 * ʾ�� 1:
 * ����:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * ���:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * ʾ�� 2:
 * ����:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * ���:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * ע��:
 * <p>
 * ���������Ԫ�ظ��������� 10000��
 * ����������������һ��Ԫ���� 0��
 * �����е�Ԫ��ֻ���ĸ�����������: �ϡ��¡����ҡ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/01-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Matrix01 {

    public static void main(String[] args) {
;
    }

//    ���� ��Tree �� BFS�� �����͵ġ���Դ BFS����
//    ���Ȱ� root �ڵ���ӣ���һ��һ�����Ա��������ˡ�
//    ���� ��ͼ �� BFS�� ������Դ BFS���� ������ʵҲ��һ���Ρ����� ��Tree �� BFS��������ע����������
//    Tree ֻ�� 1 �� root����ͼ�����ж��Դ�㣬����������Ҫ�Ѷ��Դ�㶼��ӣ�
//    Tree ���������˲���Ҫ��ʶ�Ƿ���ʹ�������������ͼ��˵������ñ�־�Ƿ���ʹ�Ŷ������Ϊ�˷�ֹĳ���ڵ�����ӣ���Ҫ�������֮ǰ�ͽ������ó��ѷ��ʣ��� �����ܶ���˵�Լ��� BFS ��ʱ�ˣ��Ӿ������������

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//�����
        boolean[][] visited = new boolean[m][n];//��¼�Ѿ��������λ��
        Queue<int[]> queue = new LinkedList<>();//���Ѷ���
        //������������0��λ�ü������������
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //�ĸ��������
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//��������
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            //�ĸ��������� 1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //û�м�����ĵط�һ���� 1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }
//������һ�� (i, j)������ 0 �ľ���Ϊ��
//
//f(i, j) = 1 + min(f(i-1, j), f(i, j-1), f(i+1, j), f(i, j+1)) if matrix[i][j] == 1
//        = 0  if matrix[i][j] == 0


//����� dp[i][j]����ʾ��λ�þ�������� 0 �ľ��롣
//���Ƿ��� dp[i][j] ���������������ĸ�״̬���������޷���һ������ʼ���ƣ�
//�������ǳ��Խ�����ֽ⣺
//���� (i, j)(i,j) ����� 00 ��λ�ã������� �����ϣ����ϣ����£����¡�4������֮һ��
//������Ƿֱ���ĸ��ǿ�ʼ���ƣ��ͷֱ�õ���λ�ڡ����Ϸ������Ϸ������·������·������� (i, j)(i,j) ������� 00 �ľ��룬ȡ min ���ɣ�
    public int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        // �����Ͻǿ�ʼ
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // �����½ǿ�ʼ
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }


}
