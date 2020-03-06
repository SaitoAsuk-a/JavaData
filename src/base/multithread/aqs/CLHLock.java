package base.multithread.aqs;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author liyu
 * @date 2019/11/25 14:17
 * @description
 * AQS ����˼���ǣ����������Ĺ�����Դ���У��򽫵�ǰ������Դ���߳�����Ϊ��Ч�Ĺ����̣߳����ҽ�������Դ����Ϊ����״̬��
 * ���������Ĺ�����Դ��ռ�ã���ô����Ҫһ���߳������ȴ��Լ�������ʱ������Ļ��ƣ�������� AQS ���� CLH ������ʵ�ֵģ�������ʱ��ȡ���������̼߳��뵽�����С�
 * CLH����һ�ֻ�������Ŀ���չ�������ܡ���ƽ���������������߳�ֻ�ڱ��ر�������������������ѯǰ����״̬���������ǰ���ͷ������ͽ����������������
 * CLH�ķ������ǣ�Craig��Landin and Hagersten
 */
public class CLHLock {
    /**
     * ����һ���ڵ㣬Ĭ�ϵ�lock״̬Ϊtrue
     */
    public static class CLHNode {
        private volatile boolean isLocked = true;
    }
    /**
     * β���ڵ�,ֻ��һ���ڵ㼴��
     */
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<CLHNode>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");
    public void lock() {
        // �½��ڵ㲢���ڵ��뵱ǰ�̱߳�������
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        // ���½��Ľڵ�����Ϊβ���ڵ㣬�����ؾɵĽڵ㣨ԭ�Ӳ�����������ɵĽڵ�ʵ���Ͼ��ǵ�ǰ�ڵ��ǰ���ڵ�
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            // ǰ���ڵ㲻Ϊnull��ʾ�����������߳�ռ�ã�ͨ��������ѯ�ж�ǰ���ڵ������־λ�ȴ�ǰ���ڵ��ͷ���
            while (preNode.isLocked) {
            }
            preNode = null;
            LOCAL.set(node);
        }
        // ���������ǰ���ڵ㣬��ʾ����û�б������߳�ռ�ã���ǰ�̻߳����
    }
    public void unlock() {
        // ��ȡ��ǰ�̶߳�Ӧ�Ľڵ�
        CLHNode node = LOCAL.get();
        // ���tail�ڵ����node����tail�ڵ����Ϊnull��ͬʱ��node��lock״ְ̬λfalse����ʾ��ǰ�߳��ͷ�����
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }
}
