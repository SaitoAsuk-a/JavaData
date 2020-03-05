package base.multithread.basic;

/**
 * @author liyu
 * @date 2020/3/5 10:45
 * @description ������ʾ
 * ������������߱������ĸ�������
 * 1.��������������Դ����һ��ʱ��ֻ��һ���߳�ռ�á�
 * 2.�����뱣��������һ��������������Դ������ʱ�����ѻ�õ���Դ���ֲ��š�
 * 3.����������:�߳��ѻ�õ���Դ��ĩʹ����֮ǰ���ܱ������߳�ǿ�а��ᣬֻ���Լ�ʹ����Ϻ���ͷ���Դ��
 * 4.ѭ���ȴ�����:���ɽ���֮���γ�һ��ͷβ��ӵ�ѭ���ȴ���Դ��ϵ
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + "get resource1");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waiting to get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "get resource2");
                }
            }
        }, "thread-1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + "get resource2");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waiting to get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + "get resource1");
                }
            }
        }, "thread-2").start();
    }
}
