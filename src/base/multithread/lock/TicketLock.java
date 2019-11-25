package base.multithread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2019/11/25 13:45
 * @description TicketLock��Ҫ������ǹ�ƽ�Ե����⡣
 * ˼·��ÿ�����̻߳�ȡ����ʱ�򣬾͸����̷߳���һ��������id�����ǳ�֮Ϊ�ŶӺţ�ͬʱ������Ӧһ������ţ�ÿ�����߳��ͷ���������žͻ��������ʱ����������ĳ���߳��ŶӺ�һ�£���ô���߳̾ͻ�����������ŶӺ��ǵ����ģ����Ծͱ�֤�����������ȡ�����߳̿������Ȼ�ȡ��������ʵ���˹�ƽ�ԡ�
 * ������������а���ҵ���Ŷӣ��Ŷӵ�ÿһ���˿Ͷ�����һ����Ҫ���������̣߳������з��񴰿ڱ�ʾ����ÿ���д��ڷ�����ɾͰ��Լ��ķ���ż�һ����ʱ���Ŷӵ����й˿��У�ֻ���Լ����ŶӺ�������һ�µĲſ��Եõ�����
 * �̻߳�ȡ��֮�󣬽������ŶӺŷ��أ��ȸ��߳��ͷ�����ʱ����Ҫ�����ŶӺŴ��롣���������з��յģ���Ϊ����ŶӺ��ǿ��Ա��޸ĵģ�һ���ŶӺű���С���޸��ˣ���ô�������ܱ���ȷ�ͷš�
 */
public class TicketLock {
    /**
     * �����
     */
    private AtomicInteger serviceNum = new AtomicInteger();
    /**
     * �ŶӺ�
     */
    private AtomicInteger ticketNum = new AtomicInteger();
    /**
     * lock:��ȡ���������ȡ�ɹ������ص�ǰ�̵߳��ŶӺţ���ȡ�ŶӺ������ͷ���. <br/>
     *
     * @return
     */
    public int lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
        return currentTicketNum;
    }
    /**
     * unlock:�ͷ��������뵱ǰ���������̵߳��ŶӺ� <br/>
     *
     * @param ticketNum
     */
    public void unlock(int ticketNum) {
        serviceNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
