package leetCode.fs.gengral;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * @date 2020/4/8 8:55
 * @description �����˵��˶���Χ
 * ������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ�����ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��
 * Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19��
 * ���ʸû������ܹ�������ٸ����ӣ�
 * ʾ�� 1��
 * ���룺m = 2, n = 3, k = 1
 * �����3
 * ʾ�� 1��
 * ���룺m = 3, n = 1, k = 0
 * �����1
 * ��ʾ��
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        int i = movingCount(20, 20, 11);
        System.out.println("i = " + i);
        int i1 = movingCountBFS(20, 20, 11);
        System.out.println("i1 = " + i1);
    }

    public static int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, 0, 0, m, n, k, visited);
    }

    /**
     * ������ȱ��� DFS
     *
     * @param i  ��ǰԪ���ھ����е�������
     * @param j  ��ǰԪ���ھ����е�������
     * @param si ��λ��i
     * @param sj ��λ��j
     * @return ���� 1 + �ҷ������Ŀɴ������ + �·������Ŀɴ������������ӱ���Ԫ��ݹ������Ŀɴ������
     */
    public static int dfs(int i, int j, int si, int sj, int m, int n, int k, boolean[][] visited) {
//        �� �� ��������Խ�� �� �� ��λ�ͳ���Ŀ��ֵ k �� �� ��ǰԪ���ѷ��ʹ� ʱ������ 00 ����������ɴ�⡣
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj, m, n, k, visited) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8, m, n, k, visited);
    }

    /**
     * ������ȱ��� BFS
     * ��ʼ���� �������˳�ʼ�� (0, 0)(0,0) ������� queue ��
     * ������ֹ������ queue Ϊ�ա������ѱ��������пɴ�⡣
     * ����������
     * ��Ԫ����ӣ� �����׵�Ԫ��� ��������λ�� ��������Ϊ��ǰ������Ԫ��
     * �ж��Ƿ������� �� �� ��������Խ�� �� �� ��λ�ͳ���Ŀ��ֵ k �� �� ��ǰԪ���ѷ��ʹ� ʱ��ִ�� continue ��
     * ��ǵ�ǰ��Ԫ�� ������Ԫ������ (i, j) ���� Set visited �У�����˵�Ԫ�� �ѱ����ʹ� ��
     * ��Ԫ����ӣ� ����ǰԪ�ص� �·����ҷ� ��Ԫ��� ��������λ�� ���� queue ��
     * ����ֵ�� Set visited �ĳ��� len(visited) �����ɴ���������
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCountBFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }


}
