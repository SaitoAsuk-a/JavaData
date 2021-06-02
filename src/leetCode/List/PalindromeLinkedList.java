package leetCode.List;

/**
 * @author liyu
 * date 2021/6/2 15:15
 * description ���ж�һ�������Ƿ�Ϊ��������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 1->2
 * ���: false
 * ʾ�� 2:
 * <p>
 * ����: 1->2->2->1
 * ���: true
 * ���ף�
 * ���ܷ���?O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/palindrome-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        boolean palindrome = isPalindrome(l1);
        System.out.println("palindrome = " + palindrome);
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        // �ҵ�ǰ�벿�������β�ڵ㲢��ת��벿������
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        //�Ա�head pre�Ƿ���ͬ
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // ��ԭ�������ؽ��
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }


    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
