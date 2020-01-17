package dataStructure.collection.listnode;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/1/15 10:12
 * @description �������
 */
@UtilityClass
public class Demo {
    public static void main(String[] args) {

        //���Ե������ȱ���
//        testListNodeLength();

        //���Ե����������
//        testInsertListNode();

        //����˫���������
//        testDLLInsert();

        //���Ե��������������
//        testListNodeLoop();

        //���������������
//         testInsertSortedList();

        //��������ת
//        testReverseList();

        //���Բ��������ཻ���
//        testIntersectingNode();

        //���Բ��������м��㣬�����ӡ�����ж�����������ż��
//        testMiddleAndReversePrint();

        //���Ժϲ�������������
//        testMergeList();

        //���Գɶ���������
//        testReversePairList();

        //����Լɪ��
        int josephusPosition = getJosephusPosition(5, 5);
        System.out.println("josephusPosition = " + josephusPosition);
    }

    private static void testReversePairList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        listNode7.setNext(listNode8);
        listNode8.setNext(listNode9);
        printListNode(listNode1);
        ListNode listNode = reversePairList(listNode1);
        printListNode(listNode);
        ListNode listNode10 = reversePairList2(listNode);
        printListNode(listNode10);
    }

    private static void testMergeList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        listNode1.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode8);
        listNode8.setNext(listNode9);
        listNode9.setNext(listNode10);
        printListNode(listNode1);

        listNode2.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        printListNode(listNode2);

        ListNode listNode = mergeSortedList(listNode1, listNode2);
        printListNode(listNode);
    }

    private static void testMiddleAndReversePrint() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode middleNode = findMiddleNode(listNode1);
        System.out.println("middleNode.getData() = " + middleNode.getData());
        printListNode(listNode1);
        printNodeFromEnd(listNode1);
        boolean evenLength = isEvenLength(listNode1);
        System.out.println("evenLength = " + evenLength);
        listNode4.setNext(new ListNode(5));
        boolean evenLength1 = isEvenLength(listNode1);
        System.out.println("evenLength1 = " + evenLength1);
    }

    private static void testIntersectingNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode6 = new ListNode(6);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode12.setNext(listNode13);
        listNode13.setNext(listNode5);
        listNode5.setNext(listNode6);
        ListNode intersectingNode = findIntersectingNode(listNode1, listNode12);
        System.out.println("intersectingNode.getData() = " + intersectingNode.getData());
    }

    private static void testReverseList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode5 = ReverseList(listNode1);
        printListNode(listNode5);
    }

    private static ListNode testInsertSortedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode = insertSortedList(listNode1, new ListNode(5));
        System.out.println("listNode.getData() = " + listNode.getData());
        printListNode(listNode);
        return listNode;
    }

    private static void testListNodeLoop() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode2);
        boolean b = doesLinkedListContainsLoop(listNode1);
        System.out.println("b = " + b);
        int beginLoopNode = findBeginLoopNode(listNode1);
        System.out.println("beginLoopNode = " + beginLoopNode);
        int loopLength = findLoopLength(listNode1);
        System.out.println("loopLength = " + loopLength);
    }

    private static void testDLLInsert() {
        DLLNode dllNode1 = new DLLNode(1);
        DLLNode dllNode2 = new DLLNode(2);
        DLLNode dllNode3 = new DLLNode(3);
        DLLNode dllNode4 = new DLLNode(4);
        DLLNode dllNode5 = new DLLNode(5);
        DLLNode dllNode6 = new DLLNode(6);
        DLLInsert(dllNode1, dllNode2, 2);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode3, 3);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode4, 4);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode5, 5);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode6, 6);
        printDLLNode(dllNode1, null);
    }

    private static void testInsertListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode = insertInLinkedList(listNode1, new ListNode(7), 3);
        printListNode(listNode);
    }

    private static void testListNodeLength() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        int i = listLength(listNode1);
        System.out.println("i = " + i);
    }

    /**
     * ���ص�������ĳ���
     *
     * @param headNode
     * @return ������
     */
    public int listLength(ListNode headNode) {
        int length = 0;
        ListNode cur = headNode;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    /**
     * ��ӡ��������
     *
     * @param headNode
     * @return
     */
    public void printListNode(ListNode headNode) {
        ListNode cur = headNode;
        while (cur != null) {
            System.out.print(cur.getData() + "->");
            cur = cur.getNext();
        }
        System.out.println();
    }

    /**
     * �����������ڵ�
     *
     * @param headNode     ͷ���
     * @param nodeToInsert ��������
     * @param position     ����Ϊλ��
     * @return ����ͷ���
     */
    public ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {//����Ϊ��ֱ�Ӳ���
            return nodeToInsert;
        }

        int size = listLength(headNode);

        if (position > size + 1 || position < 1) {//Խ���ж�
            System.out.println("error");
            return headNode;
        }

        if (position == 1) {//����ͷ���ڵ�
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {//�����м��β�����
            ListNode preNode = headNode;
            int count = 1;
            while (count < position - 1) {
                preNode = preNode.getNext();
                count++;
            }
            ListNode nodeNext = preNode.getNext();
            preNode.setNext(nodeToInsert);
            nodeToInsert.setNext(nodeNext);
            return headNode;
        }
    }

    /**
     * ��ȡ˫��������
     *
     * @param headNode
     * @return
     */
    public int getDLLLength(DLLNode headNode) {
        int length = 0;
        DLLNode cur = headNode;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    public DLLNode DLLInsert(DLLNode heaNode, DLLNode nodeToInsert, int position) {
        if (heaNode == null) {
            return nodeToInsert;
        }

        int size = getDLLLength(heaNode);

        if (position > size + 1 || position < 1) {
            throw new IllegalArgumentException("����λ����Ч");
        }
        if (position == 1) {//����ͷ���
            nodeToInsert.setNext(heaNode);
            heaNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            DLLNode cur = heaNode;
            int index = 1;
            while (index < position - 1) {
                cur = cur.getNext();
                index++;
            }
            DLLNode next = cur.getNext();
            cur.setNext(nodeToInsert);
            nodeToInsert.setPrevious(cur);
            if (next != null) {
                nodeToInsert.setNext(next);
                next.setPrevious(nodeToInsert);
            }
            return heaNode;
        }
    }

    /**
     * ��ӡDLLNode
     *
     * @param headNode
     * @param endNode
     */
    public void printDLLNode(DLLNode headNode, DLLNode endNode) {

        if (headNode != null) {
            DLLNode cur = headNode;
            while (cur != null) {
                System.out.println(cur.getData());
                cur = cur.getNext();
            }
        } else if (endNode != null) {
            DLLNode cur = endNode;
            while (cur != null) {
                System.out.println(cur.getData());
                cur = cur.getPrevious();
            }
        }
    }

    /**
     * ��ȡ����ѭ�����еĳ���
     *
     * @param head
     * @return
     */
    public int circularListLength(CLNode head) {
        int length = 0;
        CLNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.getNext();
            if (cur == head) {
                break;
            }
        }
        return length;
    }

    /**
     * ��ӡ����ѭ������
     *
     * @param head
     */
    public void printCircularList(CLNode head) {
        CLNode cur = head;
        while (cur != null) {
            System.out.println(cur.getData() + "-->");
            cur = cur.getNext();
            if (cur == head) {
                break;
            }
        }
    }

    /**
     * �жϵ������Ƿ��л�
     * ���ڿ���ָ���Floyd���ж��㷨
     *
     * @param headNode
     * @return
     */
    public boolean doesLinkedListContainsLoop(ListNode headNode) {
        if (headNode == null) {
            return false;
        }
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * �жϵ������Ƿ��л�
     * �޻����� -1
     * �л����ػ��ڵ�λ��
     * �����ڵ����������������headNode��������������1����ƶ��������Ľ����ǻ��Ľ��
     *
     * @param headNode
     * @return
     */
    public int findBeginLoopNode(ListNode headNode) {
        if (headNode == null) {
            return -1;
        }
        boolean hasLoop = false;
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {

            slow = headNode;
            int index = 1;
            while (slow != fast) {
                index++;
                slow = slow.getNext();
                fast = fast.getNext();
            }
            return index;
        }
        return -1;
    }

    /**
     * �ж������Ƿ��л������ػ��ĳ���
     * ������fast���ƶ�һȦ
     *
     * @param headNode
     * @return
     */
    public int findLoopLength(ListNode headNode) {
        int loopLength = 0;
        if (headNode == null) {
            return loopLength;
        }
        boolean hasLoop = false;
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {
            fast = fast.getNext();
            loopLength++;
            while (slow != fast) {
                loopLength++;
                fast = fast.getNext();
            }
        }
        return loopLength;
    }

    /**
     * ���������������һ�����
     *
     * @param headNode
     * @param newNode
     * @return
     */
    public ListNode insertSortedList(ListNode headNode, ListNode newNode) {
        if (headNode == null) {
            return newNode;
        }
        ListNode cur = headNode;
        ListNode temp = null;
        while (cur != null && cur.getData() < newNode.getData()) {
            temp = cur;
            cur = cur.getNext();
        }
        //��cur֮ǰ������
        newNode.setNext(cur);
        if (temp != null) {
            temp.setNext(newNode);
            return headNode;
        }
        return newNode;
    }

    /**
     * ��ת��������
     *
     * @param headNode
     * @return
     */
    public ListNode ReverseList(ListNode headNode) {
        ListNode next = null;
        ListNode temp = null;
        while (headNode != null) {
            next = headNode.getNext();
            headNode.setNext(temp);
            temp = headNode;
            headNode = next;
        }
        return temp;
    }

    /**
     * �������������ཻ�Ľ�㣬��������������޻�
     * ʱ�临�Ӷ�O(max(m,n))
     * �ռ临�Ӷ�O(1)
     *
     * @param L1HeadNode
     * @param L2HeadNode
     */
    public ListNode findIntersectingNode(ListNode L1HeadNode, ListNode L2HeadNode) {
        int l1 = listLength(L1HeadNode);
        int l2 = listLength(L2HeadNode);
        ListNode longList, shortList;
        int d;
        if (l1 < l2) {
            longList = L2HeadNode;
            shortList = L1HeadNode;
            d = l2 - l1;
        } else {
            longList = L1HeadNode;
            shortList = L2HeadNode;
            d = l1 - l2;
        }
        //�������ƶ�d
        for (int i = 0; i < d; i++) {
            longList = longList.getNext();
        }
        //����һ���ƶ���ֱ������
        while (longList != null && shortList != null) {
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList.getNext();
            longList = longList.getNext();
        }
        return null;
    }

    /**
     * ��ѯ�����м�ڵ㣬
     *
     * @param headNode
     * @return
     */
    public ListNode findMiddleNode(ListNode headNode) {
        if (headNode == null) {
            return null;
        }
        ListNode slow = headNode, fast = headNode;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * �����ӡ����
     * �ݹ���ʽ
     * ʱ�临�Ӷ�O(n)
     * �ռ临�Ӷ�O(n)
     *
     * @param headNode
     */
    public void printNodeFromEnd(ListNode headNode) {
        if (headNode == null) {
            return;
        }
        printNodeFromEnd(headNode.getNext());
        System.out.println(headNode.getData());
    }

    /**
     * �ж�һ������ĳ�����ż����������
     *
     * @param head
     * @return
     */
    public boolean isEvenLength(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.getNext() != null) {
            cur = cur.getNext().getNext();
        }
        if (cur == null) {
            return true;
        }
        return false;
    }

    /**
     * �ϲ�������������Ϊһ��
     *
     * @param a
     * @param b
     * @returnh
     */
    public ListNode mergeSortedList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode result;
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(mergeSortedList(a.getNext(), b));
        } else {
            result = b;
            result.setNext(mergeSortedList(b.getNext(), a));
        }
        return result;
    }

    /**
     * �ɶ���ת�б�
     * 1->2->3->4->5 ======>2->1->4->3->5
     * �ݹ��
     *
     * @param head
     * @return
     */
    public ListNode reversePairList(ListNode head) {
        ListNode temp;
        if (head == null || head.getNext() == null) {
            return head;
        } else {
            temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            head.getNext().setNext(reversePairList(head.getNext().getNext()));
            return head;
        }
    }

    /**
     * �ɶ���ת�б�
     * 1->2->3->4->5 ======>2->1->4->3->5
     * ������
     *
     * @param head
     * @return
     */
    public ListNode reversePairList2(ListNode head) {
        ListNode temp1 = null;
        ListNode temp2 = null;
        while (head != null && head.getNext() != null) {
            if (temp1 != null) {
                temp1.getNext().setNext(head.getNext());
            }
            temp1 = head.getNext();
            head.setNext(head.getNext().getNext());
            temp1.setNext(head);
            if (temp2 == null) {
                temp2 = temp1;
            }
            head = head.getNext();
        }
        return temp2;
    }

    /**
     * ��һ��ѭ������ƽ��Ϊ����������ڵ���Ϊ������ǰһ���ϴ�
     *
     * @param head  ԭ����ͷ���
     * @param head1 �ָ������ͷ���1
     * @param head2 �ָ������ͷ���2 ����
     */
    public void splitList(ListNode head, ListNode head1, ListNode head2) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return;
        }
        if (head.getNext() != head) {//�ж������Ƿ�
            head2 = head;
            return;
        }
        //ѭ�����������������ʱ��fast.next��ָ��head
        if (fast.getNext() != head && fast.getNext().getNext() != head) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //����Ϊż��������£�fastָ���ƶ�һ��
        if (fast.getNext().getNext() == head) {
            fast = fast.getNext();
        }
        //����ǰ�벿�ֵ�headָ��
        head1 = head;
        //���ú�벿�ֵ�headָ��
        head2 = slow.getNext();
        //�Ѻ�벿�ֱ�ɻ�
        fast.setNext(slow.getNext());
        //��ǰ�벿�ֱ�ɻ�
        slow.setNext(head);
    }

    /**
     * Լɪ��
     * N������ѡ��һ����ͷ�ˣ������ų�һ���������Ż�û������M���˾ʹӻ����ų����ˣ�������һ���˿�ʼ���¼��������ҳ�������ڻ��е���
     *
     * @param N
     * @param M
     * @return
     */
    public int getJosephusPosition(int N, int M) {
        if (N <= 1) {
            return N;
        }
        //�ȹ���һ����
        ListNode head, temp;
        head = new ListNode(1);
        temp = head;
        for (int i = 2; i <= N; i++) {
            ListNode listNode = new ListNode(i);
            temp.setNext(listNode);
            temp = listNode;
        }
        temp.setNext(head);

        while (N > 1) {
            for (int i = 0; i < M - 1; i++) {
                temp = temp.getNext();
            }
            //��ȥ
            temp.setNext(temp.getNext().getNext());
            temp = temp.getNext();
            N--;
        }
        return temp.getData();
    }

}
