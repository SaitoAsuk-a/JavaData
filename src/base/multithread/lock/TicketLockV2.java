package base.multithread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2019/11/25 13:53
 * @description ��ÿ���̵߳��ŶӺŷŵ���ThreadLocal��
 * �ദ����ϵͳ�ϣ�ÿ������/�߳�ռ�õĴ��������ڶ�дͬһ������serviceNum ��ÿ�ζ�д�����������ڶ������������֮����л���ͬ������ᵼ�·��ص�ϵͳ���ߺ��ڴ����������󽵵�ϵͳ��������ܡ�
 */
public class TicketLockV2 {
    /**
     * �����
     */
    private AtomicInteger serviceNum = new AtomicInteger();
    /**
     * �ŶӺ�
     */
    private AtomicInteger ticketNum = new AtomicInteger();
    /**
     * ����һ��ThreadLocal�����ڴ洢ÿ���̵߳��ŶӺ�
     */
    private ThreadLocal<Integer> ticketNumHolder = new ThreadLocal<Integer>();
    public void lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        // ��ȡ����ʱ�򣬽���ǰ�̵߳��ŶӺű�������
        ticketNumHolder.set(currentTicketNum);
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
    }
    public void unlock() {
        // �ͷ�������ThreadLocal�л�ȡ��ǰ�̵߳��ŶӺ�
        Integer currentTickNum = ticketNumHolder.get();
        serviceNum.compareAndSet(currentTickNum, currentTickNum + 1);
    }
}
