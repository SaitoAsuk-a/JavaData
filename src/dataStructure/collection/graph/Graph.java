package dataStructure.collection.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * date 2021/6/18 19:33
 * description ����ͼ���ڽӱ��ʾ
 */
public class Graph {
    private int v; // ����ĸ���
    private LinkedList<Integer> adj[]; // �ڽӱ�

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // ����ͼһ���ߴ�����
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * bfs��ӡs��t��·��
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }


        }

    }

    /**
     * �ݹ��ӡs--t��·��
     *
     * @param pre
     * @param s
     * @param t
     */
    private void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && t != s) {
            print(pre, s, pre[t]);
        }
        System.out.println(t + " ");
    }

    public void dfs(int s, int t) {
        boolean found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(found, s, t, visited, prev);
        print(prev, s, t);
    }


    public void recurDfs(boolean found, int w, int s, boolean[] visited, int[] pre) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == s) {
            found = true;
            return;
        }
        LinkedList<Integer> list = adj[w];
        for (int i = 0; i < list.size(); i++) {
            int q = list.get(i);
            if (!visited[q]) {
                pre[q] = w;
                recurDfs(found, q, s, visited, pre);
            }
        }
    }
}
