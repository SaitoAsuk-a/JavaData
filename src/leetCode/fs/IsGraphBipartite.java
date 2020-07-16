package leetCode.fs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * @date 2020/7/16 8:48
 * @description �ж϶���ͼ
 * ����һ������ͼgraph�������ͼΪ����ͼʱ����true��
 * ��������ܽ�һ��ͼ�Ľڵ㼯�Ϸָ�������������Ӽ�A��B����ʹͼ�е�ÿһ���ߵ������ڵ�һ������A���ϣ�һ������B���ϣ����Ǿͽ����ͼ��Ϊ����ͼ��
 * graph�������ڽӱ�ʽ������graph[i]��ʾͼ����ڵ�i���������нڵ㡣ÿ���ڵ㶼��һ����0��graph.length-1֮�����������ͼ��û���Ի���ƽ�бߣ�?graph[i]?�в�����i������graph[i]��û���ظ���ֵ��
 * ʾ�� 1:
 * ����: [[1,3], [0,2], [1,3], [0,2]]
 * ���: true
 * ����:
 * ����ͼ����:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * ���ǿ��Խ��ڵ�ֳ�����: {0, 2} �� {1, 3}��
 * ʾ�� 2:
 * ����: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * ���: false
 * ����:
 * ����ͼ����:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * ���ǲ��ܽ��ڵ�ָ�������������Ӽ���
 * ע��:
 * graph �ĳ��ȷ�ΧΪ [1, 100]��
 * graph[i] �е�Ԫ�صķ�ΧΪ [0, graph.length - 1]��
 * graph[i] ������� i �������ظ���ֵ��
 * ͼ�������: ���j �� graph[i]���, ��ô i Ҳ���� graph[j]��ߡ�
 * ��Դ��https://leetcode-cn.com/problems/is-graph-bipartite
 */

public class IsGraphBipartite {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    /**
     * ��ͼ�е����������ڵ� u �� v���������֮����һ����ֱ����������ô u �� v �������ڲ�ͬ�ļ��ϡ�
     * �������������ͼ��ͨ����ô���ǾͿ�����ѡһ���ڵ㿪ʼ������Ⱦ�ɺ�ɫ��������Ƕ�����ͼ���б��������ýڵ�ֱ�����������нڵ�Ⱦ����ɫ����ʾ��Щ�ڵ㲻������ʼ�ڵ�����ͬһ�����ϡ������ٽ���Щ��ɫ�ڵ�ֱ�����������нڵ�Ⱦ�ɺ�ɫ���Դ����ƣ�ֱ������ͼ�е�ÿ���ڵ����Ⱦɫ��
     * ��������ܹ��ɹ�Ⱦɫ����ô��ɫ����ɫ�Ľڵ������һ�����ϣ��������ͼ����һ������ͼ���������δ�ܳɹ�Ⱦɫ������Ⱦɫ�Ĺ����У�ĳһʱ�̷��ʵ���һ���Ѿ�Ⱦɫ�Ľڵ㣬����������ɫ�����ǽ�Ҫ����Ⱦ�ϵ���ɫ����ͬ��Ҳ��˵���������ͼ����һ������ͼ��
     * �㷨���������£�
     * ������ѡһ���ڵ㿪ʼ������Ⱦ�ɺ�ɫ�����Ӹýڵ㿪ʼ����������ͼ���б�����
     * �ڱ����Ĺ����У��������ͨ���ڵ� u �������˽ڵ� v���� u �� v ��ͼ����һ����ֱ������������ô�������������
     * ��� v δ��Ⱦɫ����ô���ǽ���Ⱦ���� u ��ͬ����ɫ������ v ֱ�������Ľڵ���б�����
     * ��� v ��Ⱦɫ��������ɫ�� u ��ͬ����ô˵������������ͼ���Ƕ���ͼ�����ǿ���ֱ���˳����������� False ��Ϊ�𰸡�
     * ����������ʱ��˵������������ͼ�Ƕ���ͼ������ True ��Ϊ�𰸡�

     * �����������
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; ++i) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;

    }

    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }

    /**
     * �����������
     * @param graph
     * @return
     */
    public boolean isBipartite0(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
