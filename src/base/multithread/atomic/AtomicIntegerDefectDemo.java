package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2019/11/25 15:44
 * @description CAS ABA ����
 * ����: ��һ���߳�ȡ���˱��� x ��ֵ A��Ȼ����������ɱ���£���֮����ֻ�õ��˱��� x ��ֵ A�����ʱ���ڵڶ����߳�Ҳȡ���˱��� x ��ֵ A��Ȼ��ѱ��� x ��ֵ��Ϊ B��Ȼ����������ɱ���£�����ְѱ��� x ��ֵ��Ϊ A ���൱�ڻ�ԭ�ˣ�������֮���һ���߳����ڽ����˱��� x �Ĳ��������Ǵ�ʱ���� x ��ֵ���� A������ compareAndSet �����ǳɹ���
 * ��������(���ܲ�̫���ʣ��������): ������ֽ�Ϊ�㣬Ȼ��ͨ�������Ͷ�׬��������֮�����������ˣ��������ӣ���������ĩ����Ȼ�ֽ������루���ܱ��������ʽ�ˣ�������׬��Ǯ����ʵ�����ǵý�˰�ģ�
 * �������ӣ���AtomicIntegerΪ����
 */
public class AtomicIntegerDefectDemo {
    public static void main(String[] args) {
        defectOfABA();
    }

    static void defectOfABA() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);

        Thread coreThread = new Thread(
                () -> {
                    final int currentValue = atomicInteger.get();
                    System.out.println(Thread.currentThread().getName() + " ------ currentValue=" + currentValue);

                    // ���Ŀ�ģ�ģ�⴦������ҵ�񻨷ѵ�ʱ��
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    boolean casResult = atomicInteger.compareAndSet(1, 2);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                }
        );
        coreThread.start();

        // ���Ŀ�ģ�Ϊ���� coreThread �߳���������
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread amateurThread = new Thread(
                () -> {
                    int currentValue = atomicInteger.get();
                    boolean casResult = atomicInteger.compareAndSet(1, 2);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);

                    currentValue = atomicInteger.get();
                    casResult = atomicInteger.compareAndSet(2, 1);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                }
        );
        amateurThread.start();
    }
}
