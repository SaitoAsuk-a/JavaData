package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liyu
 * @date 2020/7/2 8:56
 * @description ��������е�kС��Ԫ��
 * ����һ��?n x n?��������ÿ�к�ÿ��Ԫ�ؾ������������ҵ������е� k С��Ԫ�ء�
 * ��ע�⣬���������ĵ� k СԪ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * ʾ����
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * ���� 13��
 * ��ʾ��
 * ����Լ��� k ��ֵ��Զ����Ч�ģ�1 �� k �� n2?��
 * ��Դ��https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
@UtilityClass
public class KthSmallestElementInASortedMatrix {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int i = kthSmallest2(matrix, 8);
        System.out.println("i = " + i);

    }

    /**
     * ���ȶ��й���󶥶�
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int matrix1 : matrix[i]) {
                queue.add(matrix1);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }

    /**
     * ֱ������ ��ֱ�ӵ������ǽ������ά�������ΪΪһά���飬���Ը�һά�����������������һά�����еĵ� k ������Ϊ�𰸡�
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {

        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];

    }

    /**
     * �鲢���� ����Ŀ���������ʿ�֪����������ÿһ�о�Ϊһ���������顣���⼴ת��Ϊ���� n �������������ҵ� k ������������뵽���ù鲢�����������
     * �鲢���� k ��������ֹͣ��һ��鲢��������������鲢���������� n ������鲢��������Ҫ��С����ά�������Ż�ʱ�临�Ӷȡ�
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];


    }


    /**
     * ���ֲ���
     * ����Ŀ���������ʿ�֪����������ڵ�Ԫ���Ǵ����ϵ����µ����ģ�����������Ͻ�Ϊ matrix[0][0]��
     * ����֪��������ά������matrix[0][0] Ϊ��Сֵmatrix[n?1][n?1] Ϊ���ֵ���������ǽ���ֱ���� l �� r��
     * ���Է���һ�����ʣ���ȡһ���� mid ���� l��mid��r����ô�����в�����mid �������϶�ȫ���ֲ��ھ�������Ͻǡ�
     * ȡmid=8��
     * ���ǿ��Կ����������д��� mid �����ͺͲ�����mid �����ֱ��γ���������飬����һ������߽�������ηֿ����������Ͻǰ��Ĵ�С��Ϊ�����в����� mid ������������
     * ����Ҳ�����Լ�ȡһЩ mid ֵ��ͨ����ͼ�Լ�����⡣
     * ����ֻҪ���������������һ�鼴�ɼ�������������Ĵ�С��Ҳ��Ȼ��ͳ�Ƴ�����������в����� midmid �����ĸ����ˡ�
     * �߷���ʾ���£���Ȼȡmid=8��
     * �������������߷���
     * ��ʼλ���� matrix[n?1][0]�������½ǣ���
     * �赱ǰλ��Ϊ matrix[i][j]����matrix[i][j]��mid���򽫵�ǰ�����еĲ�����mid ��������������i+1���ۼӵ����У��������ƶ������������ƶ���
     * �����ƶ�ֱ���߳�����Ϊֹ��
     * ���Ƿ����������߷�ʱ�临�Ӷ�Ϊ O(n)�������ǿ������Լ����������һ�� mid���������ж�������С�������������˶��ִ𰸵����ʡ�
     * ���������Ϊ x����ô����֪�� l��x��r��������ȷ���˶��ִ𰸵����½硣
     * ÿ�ζ��ڡ��²⡹�Ĵ� mid������������ж����������� mid ��
     * ������������� k����ô˵�����մ� x ��С�� mid��
     * ����������� k����ô˵�����մ� x ���� mid��
     * �������ǾͿ��Լ�������յĽ�� x �ˡ�
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {

        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
