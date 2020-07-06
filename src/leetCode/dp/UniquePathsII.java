package leetCode.dp;

/**
 * @author liyu
 * @date 2020/7/6 8:59
 * @description ��ͬ·��II
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 * ˵����m?�� n ��ֵ�������� 100��
 * ʾ��?1:
 * ����:
 * [
 * ? [0,0,0],
 * ? [0,1,0],
 * ? [0,0,0]
 * ]
 * ���: 2
 * ����:
 * 3x3 ��������м���һ���ϰ��
 * �����Ͻǵ����½�һ���� 2 ����ͬ��·����
 * 1. ���� -> ���� -> ���� -> ����
 * 2. ���� -> ���� -> ���� -> ����
 * ��Դ��https://leetcode-cn.com/problems/unique-paths-ii
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[r - 1][c - 1];
    }

    /**
     * ���������Ż���
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles0(int[][] obstacleGrid) {

        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];

    }
}
