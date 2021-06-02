package leetCode.List;

/**
 * @author liyu
 * date 2021/6/2 18:04
 * description ����һ�������ж��������Ƿ��л���
 * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����
 * ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 * ���ף�
 * ������ O(1)�������������ڴ�����������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LinkedListCycle {

    public boolean hasCycle(SingleListNode head) {
        if (head == null) return false;
        SingleListNode slow = head;
        SingleListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast= fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }


}

