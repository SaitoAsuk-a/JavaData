package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author liyu
 * @date 2019/11/25 16:16
 * @description AtomicIntegerArray �ೣ�÷���
 * AtomicIntegerArray����������ԭ����
 * AtomicLongArray������������ԭ����
 * AtomicReferenceArray ��������������ԭ����
 * public final int get(int i) //��ȡ index=i λ��Ԫ�ص�ֵ
 * public final int getAndSet(int i, int newValue)//���� index=i λ�õĵ�ǰ��ֵ������������Ϊ��ֵ��newValue
 * public final int getAndIncrement(int i)//��ȡ index=i λ��Ԫ�ص�ֵ�����ø�λ�õ�Ԫ������
 * public final int getAndDecrement(int i) //��ȡ index=i λ��Ԫ�ص�ֵ�����ø�λ�õ�Ԫ���Լ�
 * public final int getAndAdd(int delta) //��ȡ index=i λ��Ԫ�ص�ֵ��������Ԥ�ڵ�ֵ
 * boolean compareAndSet(int i, int expect, int update) //����������ֵ����Ԥ��ֵ������ԭ�ӷ�ʽ�� index=i λ�õ�Ԫ��ֵ����Ϊ����ֵ��update��
 * public final void lazySet(int i, int newValue)//���� ��index=i λ�õ�Ԫ������ΪnewValue,ʹ�� lazySet ����֮����ܵ��������߳���֮���һС��ʱ���ڻ��ǿ��Զ����ɵ�ֵ��
 */
public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int temvalue = 0;
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }
        temvalue = i.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
    }

}
