package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2019/11/25 15:53
 * @description AtomicInteger ��������ʹ��
 * AtomicInteger������ԭ����
 * AtomicLong��������ԭ����
 * AtomicBoolean ��������ԭ����
 * public final int get() //��ȡ��ǰ��ֵ
 * public final int getAndSet(int newValue)//��ȡ��ǰ��ֵ���������µ�ֵ
 * public final int getAndIncrement()//��ȡ��ǰ��ֵ��������
 * public final int getAndDecrement() //��ȡ��ǰ��ֵ�����Լ�
 * public final int getAndAdd(int delta) //��ȡ��ǰ��ֵ��������Ԥ�ڵ�ֵ
 * boolean compareAndSet(int expect, int update) //����������ֵ����Ԥ��ֵ������ԭ�ӷ�ʽ����ֵ����Ϊ����ֵ��update��
 * public final void lazySet(int newValue)//��������ΪnewValue,ʹ�� lazySet ����֮����ܵ��������߳���֮���һС��ʱ���ڻ��ǿ��Զ����ɵ�ֵ��
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        int temvalue = 0;
        AtomicInteger i = new AtomicInteger(0);

        temvalue = i.getAndSet(3);
        System.out.println("temvalue = " + temvalue);
        System.out.println("i = " + i);

        boolean b = i.compareAndSet(3, 4);
        System.out.println("b = " + b);
        System.out.println("i = " + i);
    }
}
