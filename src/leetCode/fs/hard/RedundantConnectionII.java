package leetCode.fs.hard;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liyu
 * date 2020/9/17 9:32
 * description ��������II
 * �ڱ������У��и���ָ������������������ͼ��
 * ����ֻ��һ�����ڵ㣬���������ڵ㶼�Ǹø��ڵ�ĺ�̡�
 * ÿһ���ڵ�ֻ��һ�����ڵ㣬���˸��ڵ�û�и��ڵ㡣
 * ����һ������ͼ����ͼ��һ������N���ڵ� (�ڵ�ֵ���ظ�1, 2, ..., N) ������һ�����ӵı߹��ɡ�
 * ���ӵıߵ��������������1��N�м䣬�������ӵı߲����������Ѵ��ڵıߡ�
 * ���ͼ��һ���Ա���ɵĶ�ά���顣
 * ÿһ���ߵ�Ԫ����һ�� [u, v]�����Ա�ʾ����ͼ�����Ӷ��� u �Ͷ��� v �ıߣ����� u �� v ��һ�����ڵ㡣
 * ����һ����ɾ���ıߣ�ʹ��ʣ�µ�ͼ����N���ڵ���и��������ж���𰸣������������ڸ�����ά����Ĵ𰸡�
 * ʾ��?1:
 * ����: [[1,2], [1,3], [2,3]]
 * ���: [2,3]
 * ����: ����������ͼ����:
 * 1
 * / \
 * v   v
 * 2-->3
 * ʾ�� 2:
 * ����: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * ���: [4,1]
 * ����: ����������ͼ����:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * ע��:
 * ��ά�����С����3��1000��Χ�ڡ�
 * ��ά�����е�ÿ��������1��N֮�䣬���� N �Ƕ�ά����Ĵ�С��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/redundant-connection-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class RedundantConnectionII {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] redundantDirectedConnection = findRedundantDirectedConnection(edges);
        System.out.println("redundantDirectedConnection = " + Arrays.toString(redundantDirectedConnection));

    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}

class UnionFind {
    int[] ancestor;

    public UnionFind(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}
