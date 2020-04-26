package leetCode.array.hard;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/4/26 9:13
 * @description �ϲ�k����������
 * �ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�
 * ʾ��:
 * ����:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * ���: 1->1->2->3->4->4->5->6
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class MergeKSortedLlists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{node1, node2, node3};
        ListNode node = mergeKLists(lists);
        System.out.println("node = " + node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        boolean flag = true;
        int n = 0;
        int max = 0;
        ListNode temp = new ListNode(-1);
        ListNode root = temp;

        while (flag) {
            ListNode node = null;
            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    n++;
                } else {
                    if (node == null || lists[i].val < node.val) {
                        node = lists[i];
                        max = i;
                    }
                }

            }
            if (n == length) {
                flag = false;
            } else {
                lists[max] = lists[max].next;
                temp.next = node;
                temp = temp.next;
                node = null;
                n = 0;
                max = 0;
            }
        }
        return root.next;
    }

    /**
     * ��С��
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //����һ���ѣ�������Ԫ�ص�����ʽ
        PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> (o1.val - o2.val));
        //�����������飬Ȼ��ÿ�������ÿ���ڵ㶼�������
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //�Ӷ��в���ȡ��Ԫ�أ�����ȡ����Ԫ�ش�������
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        //����һ��С���ѣ��������������
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //�������һ�治һ����������һ����ȫ���ŵ�����
        //����ֻ��k������ĵ�һ���ڵ���뵽����
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }
        //֮�󲻶ϴӶ���ȡ���ڵ㣬�������ڵ㻹����һ���ڵ㣬
        //�ͽ��¸��ڵ�Ҳ�������
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }


    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
