package leetCode.array.general;

import java.util.Stack;

/**
 * @author liyu
 * @date 2020/4/14 14:09
 * @description �������II
 * �������� �ǿ� ���������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢һλ���֡�����������ӻ᷵��һ���µ�����
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 * ���ף�
 * ��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��
 * ʾ����
 * ���룺(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //��λ
        int c = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c > 0) {
            int sum = c;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            c = sum / 10;
        }

        return head;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
