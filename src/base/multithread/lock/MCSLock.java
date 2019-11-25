package base.multithread.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author liyu
 * @date 2019/11/25 14:54
 * @description MCSLock�ǶԱ��ر����Ľڵ����ѭ����
 * MCS:����������John Mellor-Crummey��Michael Scott
 * CLHLock�ǻ�����ʽ����û�������ĺ����ڵ����ԣ�MCSLock����ʾ������һ��ָ������ڵ������
 * ����ȡ�����߳�״̬�����ڵ�(node)����,ÿ���̶߳���һ�ݶ����Ľڵ㣬�����ͽ����TicketLock�ദ��������ͬ��������
 */
public class MCSLock {
    /**
     * �ڵ㣬��¼��ǰ�ڵ����״̬�Լ������ڵ�
     */
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isLocked = true;
    }

    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<MCSNode>();
    // ����
    @SuppressWarnings("unused")
    private volatile MCSNode queue;
    // queue������
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class,
            "queue");

    public void lock() {
        // �����ڵ㲢���浽ThreadLocal��
        MCSNode currentNode = new MCSNode();
        NODE.set(currentNode);
        // ��queue����Ϊ��ǰ�ڵ㣬���ҷ���֮ǰ�Ľڵ�
        MCSNode preNode = UPDATER.getAndSet(this, currentNode);
        if (preNode != null) {
            // ���֮ǰ�ڵ㲻Ϊnull����ʾ���Ѿ��������̳߳���
            preNode.next = currentNode;
            // ѭ���жϣ�ֱ����ǰ�ڵ������־λΪfalse
            while (currentNode.isLocked) {
            }
        }
    }

    public void unlock() {
        MCSNode currentNode = NODE.get();
        // nextΪnull��ʾû�����ڵȴ���ȡ�����߳�
        if (currentNode.next == null) {
            // ����״̬������queueΪnull
            if (UPDATER.compareAndSet(this, currentNode, null)) {
                // ����ɹ��ˣ���ʾqueue==currentNode,����ǰ�ڵ����û�нڵ���
                return;
            } else {
                // ������ɹ�����ʾqueue!=currentNode,����ǰ�ڵ�������һ���ڵ㣬��ʾ���߳��ڵȴ�
                // �����ǰ�ڵ�ĺ����ڵ�Ϊnull������Ҫ�ȴ��䲻Ϊnull���ο�����������
                while (currentNode.next == null) {
                }
            }
        } else {
            // �����Ϊnull����ʾ���߳��ڵȴ���ȡ������ʱ���ȴ��̶߳�Ӧ�Ľڵ���״̬����Ϊfalse��ͬʱ����ǰ�̵߳ĺ�̽ڵ���Ϊnull
            currentNode.next.isLocked = false;
            currentNode.next = null;
        }
    }
}