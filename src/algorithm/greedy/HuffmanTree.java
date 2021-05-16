package algorithm.greedy;

import java.util.Arrays;

public class HuffmanTree {
    int selectStart = 0; //���������ʾ֮ǰ����ɾ��������С����������

    private class HuffmanCode {
        char data; // ����ַ������� 'C'
        String bit; // ��ű������ַ���, ����"111"

        public HuffmanCode(char data, String bit) {
            this.data = data;
            this.bit = bit;
        }
    }

    /**
     * @description: ����Ȩֵ����Ϊrank�Ľ�������nodes�е��±꣨��Ȩֵ��С�����ţ�
     */
    private int select(Node[] HT, int range, int rank) {
        Node[] copyNodes = Arrays.copyOf(HT, range);// ��HT[0]~HT[range]������copyNodes��
        QuickSort.sort(copyNodes); // ��copyNodes���д�С����Ŀ�������
        Node target = copyNodes[rank + selectStart]; // ȡ�á�ɾ������Ȩֵ����Ϊrank�Ľ�����
        for (int j = 0; j < HT.length; j++) {
            if (target == HT[j]) return j; // ���ظý�����������HT�е��±�
        }
        return -1;
    }

    /**
     * @description: �����շ�����
     */
    public Node[] buildTree(Node[] nodes) {
        int s1, s2, p;
        int n = nodes.length; // ���������
        int m = 2 * n - 1; // �ڽ�� + �����������
        Node[] HT = new Node[m]; // �洢�������HT����
        for (int i = 0; i < m; i++) HT[i] = new Node(0); // ��ʼ��HT����Ԫ��
        for (int i = 0; i < n; i++) {
            HT[i].data = nodes[i].data;
            HT[i].weight = nodes[i].weight; //��������Ȩֵ�б����������
        }
        for (int i = n; i < m; i++) {
            s1 = select(HT, i, 0); // ȡ��HT������Ȩֵ��С�Ľ�������±�
            s2 = select(HT, i, 1); // ȡ��HT������Ȩֵ��С�Ľ�������±�
            HT[i].left = s1; // ��������
            HT[i].right = s2;
            HT[s1].parent = i;
            HT[s2].parent = i;
            HT[i].weight = HT[s1].weight + HT[s2].weight;// ���㵱ǰ�����Ȩֵ
            selectStart += 2; // ���������ʾ֮ǰ����ɾ��������С����������
        }
        return HT; // ��������HT���鷵��
    }

    /**
     * @description: ���кշ�������
     */
    public HuffmanCode[] encode(Node[] nodes) {
        Node[] HT = buildTree(nodes); // ���������nodes���鹹��շ�����
        int n = nodes.length;
        HuffmanCode[] HC = new HuffmanCode[n];
        String bit;
        for (int i = 0; i < n; i++) { // ��������Ҷ�ӽ��
            bit = "";
            for (int c = i, f = HT[i].parent; f != 0; c = f, f = HT[f].parent) { // ��Ҷ�ӽ�����ݵ������
                if (HT[f].left == c) bit = "0" + bit; // �������
                else bit = "1" + bit;
            }
            HC[i] = new HuffmanCode(HT[i].data, bit); // ���ַ��Ͷ�Ӧ�ı���洢����
        }
        return HC;
    }

    /**
     * @description: ���кշ�������
     */
    public String decode(Node[] nodes, String code) {
        String str = "";
        Node[] HT = buildTree(nodes);
        int n = HT.length - 1;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '1') {
                n = HT[n].right;
            } else {
                n = HT[n].left;
            }
            if (HT[n].left == 0) {
                str += HT[n].data;
                n = HT.length - 1;
            }
        }
        return str;
    }

    /**
     * �����
     * weight��ʾȨֵ�� data��ʾ����洢���ַ���data����������ı���/�����л��õ���
     * ��ͬ����Ϊ�շ������룬�����������������ʹ��������ʵ�ֶ���������]
     * ����left��right���ԵĻ����ϣ�Ϊ���������parent���ԣ�Ŀ�����ܹ���Ҷ�ӽ�����ݵ�����㣬�Ӷ�ʵ�ֺշ������롣
     */
    private static class Node {
        char data;
        int weight;
        int left, right, parent;

        public Node(char data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Node(int weight) {
            this.weight = weight;
        }
    }

    /**
     * ���������
     */
    private static class QuickSort {
        /**
         * @description: ������������Ԫ��
         */
        private static void exchange(Node[] a, int i, int j) {
            Node temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        /**
         * @description: �зֺ���
         */
        private static int partition(Node[] a, int low, int high) {
            int i = low, j = high + 1;      // i, jΪ����ɨ��ָ��
            int pivotkey = a[low].weight;  // pivotkey Ϊѡȡ�Ļ�׼Ԫ�أ�ͷԪ�أ�
            while (true) {
                while (a[--j].weight > pivotkey) {
                    if (j == low) break;
                }  // ���α�����
                while (a[++i].weight < pivotkey) {
                    if (i == high) break;
                }  // ���α�����
                if (i >= j) break;    // �����α�����ʱ��ֹͣ�� ���������ⲿwhileѭ��
                else exchange(a, i, j);  // �����α�δ����ʱֹͣ, ����������ָԪ�أ�ѭ������
            }
            exchange(a, low, j); // ��׼Ԫ�غ��α�����ʱ��ָԪ�ؽ�����Ϊ���һ�ν���
            return j;  // һ��������ɣ� ���ػ�׼Ԫ��λ��
        }

        /**
         * @description: ���ݸ�����Ȩֵ�������������
         */
        private static void sort(Node[] a, int low, int high) {
            if (high <= low) {
                return;
            } // ��high == low, ��ʱ���ǵ�Ԫ�������飬��Ȼ���� ����ֹ�ݹ�
            int j = partition(a, low, high);  // ����partition�����з�
            sort(a, low, j - 1);   // ����һ������(�з�)ʱ����׼Ԫ����ߵ���������еݹ�
            sort(a, j + 1, high); // ����һ������(�з�)ʱ����׼Ԫ���ұߵ���������еݹ�
        }

        public static void sort(Node[] a) { //sort�������أ� ֻ���Ⱪ¶һ���������
            sort(a, 0, a.length - 1);
        }
    }

    /**
     * @description: buildTree����������
     */
    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        nodes[0] = new Node('A', 7);
        nodes[1] = new Node('B', 5);
        nodes[2] = new Node('C', 2);
        nodes[3] = new Node('D', 4);
        HuffmanTree ht = new HuffmanTree();
        System.out.println(ht.decode(nodes, "010110111"));
    }
}