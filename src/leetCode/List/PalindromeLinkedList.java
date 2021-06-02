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
        SingleListNode l1=new SingleListNode(1);
        SingleListNode l2=new SingleListNode(2);
        SingleListNode l3=new SingleListNode(2);
        SingleListNode l4=new SingleListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        boolean palindrome = isPalindrome(l1);
        System.out.println("palindrome = " + palindrome);
    }
    public static boolean isPalindrome(SingleListNode head) {
        if (head == null) return true;

        // �ҵ�ǰ�벿�������β�ڵ㲢��ת��벿������
        SingleListNode firstHalfEnd = endOfFirstHalf(head);
        SingleListNode secondHalfStart = reverseList(firstHalfEnd.next);

        //�Ա�head pre�Ƿ���ͬ
        SingleListNode p1 = head;
        SingleListNode p2 = secondHalfStart;
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


    private static SingleListNode middleNode(SingleListNode head) {
        SingleListNode slow = head;
        SingleListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private static SingleListNode reverseList(SingleListNode head) {
        SingleListNode prev = null;
        SingleListNode curr = head;
        while (curr != null) {
            SingleListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static SingleListNode endOfFirstHalf(SingleListNode head) {
        SingleListNode fast = head;
        SingleListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



