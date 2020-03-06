package base.multithread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/25 13:34
 * @description �������������
 */
public class ReentrantSpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();
    private int count;
    public void lock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) { // �����ǰ�߳��Ѿ���ȡ���������߳�������һ��Ȼ�󷵻�
            count++;
            return;
        }
        // ���û��ȡ��������ͨ��CAS����
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }
    public void unlock() {
        Thread cur = Thread.currentThread();
        if (cur == cas.get()) {
            if (count > 0) {// �������0����ʾ��ǰ�̶߳�λ�ȡ�˸������ͷ���ͨ��count��һ��ģ��
                count--;
            } else {// ���count==0�����Խ����ͷţ��������ܱ�֤��ȡ���Ĵ������ͷ����Ĵ�����һ�µ��ˡ�
                cas.compareAndSet(cur, null);
            }
        }
    }
}
