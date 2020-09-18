package algorithm.other;

/**
 * @author liyu
 * date 2020/9/17 11:09
 * description
 * see:{https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/unionfind-suan-fa-xiang-jie}
 */
public class UnionFind {

    /**
     * ����UF
     */
    class UF {
        // ��¼��ͨ����
        private int count;
        // �ڵ� x �Ľڵ��� parent[x]
        private int[] parent;

        /**
         * ���캯����n Ϊͼ�Ľڵ�����
         */
        public UF(int n) {
            // һ��ʼ������ͨ
            this.count = n;
            // ���ڵ�ָ���ʼָ���Լ�
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            // ���������ϲ�Ϊһ��
            parent[rootP] = rootQ;
            // parent[rootQ] = rootP Ҳһ��
            count--; // ���������϶�Ϊһ
        }

        /**
         * ����ĳ���ڵ� x �ĸ��ڵ�
         */
        private int find(int x) {
            // ���ڵ�� parent[x] == x
            while (parent[x] != x)
                x = parent[x];
            return x;
        }

        /**
         * ���ص�ǰ����ͨ��������
         */
        public int count() {
            return count;
        }
    }

    /**
     * ƽ���Ż����UF
     */
    class UF2 {
        private int count;
        private int[] parent;
        // ����һ�������¼���ġ�������
        private int[] size;

        public UF2(int n) {
            this.count = n;
            parent = new int[n];
            // ���ÿ����ֻ��һ���ڵ�
            // ����Ӧ�ó�ʼ�� 1
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // С���ӵ��������棬��ƽ��
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }


        private int find(int x) {
            while (parent[x] != x) {
                // ����·��ѹ��
//                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
