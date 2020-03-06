package base.multithread.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liyu
 * @date 2019/11/26 10:15
 * @description CountDownLatch ������ʱ����
 * CountDownLatch �����ֵ����÷�
 * ��ĳһ�߳��ڿ�ʼ����ǰ�ȴ�n���߳�ִ����ϡ��� CountDownLatch �ļ�������ʼ��Ϊn ��new CountDownLatch(n) ��ÿ��һ�������߳�ִ����ϣ��ͽ���������1 countdownlatch.countDown()������������ֵ��Ϊ0ʱ����CountDownLatch�� await() ���߳̾ͻᱻ���ѡ�һ������Ӧ�ó�����������һ������ʱ�����߳���Ҫ�ȴ�������������ϣ�֮���ټ���ִ�С�
 * ��ʵ�ֶ���߳̿�ʼִ�������������ԡ�ע���ǲ����ԣ����ǲ�����ǿ�����Ƕ���߳���ĳһʱ��ͬʱ��ʼִ�С����������ܣ�������̷߳ŵ���㣬�ȴ�����ǹ�죬Ȼ��ͬʱ���ܡ������ǳ�ʼ��һ������� CountDownLatch ���󣬽����������ʼ��Ϊ 1 ��new CountDownLatch(1) ������߳��ڿ�ʼִ������ǰ���� coundownlatch.await()�������̵߳��� countDown() ʱ����������Ϊ0������߳�ͬʱ�����ѡ�
 * ��������⣺һ���ǳ������ʹ�ó����ǣ������ʹ��n���̷߳��ʹ�����Դ����ÿ�β��Խ׶ε��߳���Ŀ�ǲ�ͬ�ģ������Բ���������
 */
public class CountDownLatchExample1 {

    // ���������
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // ����һ�����й̶��߳��������̳߳ض�����������̳߳ص��߳�������̫�ٵĻ���ᷢ��ִ�еĺ�����
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda ���ʽ������
                try {
                    test(threadnum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// ��ʾһ�������Ѿ������
                }

            });
        }
        new Thread(()->{
            try {
                countDownLatch.await();
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"finish");
        },"1").start();
        new Thread(()->{
            try {
                countDownLatch.await();
                Thread.sleep(6000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"finish");
        },"2").start();

        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// ģ������ĺ�ʱ����
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// ģ������ĺ�ʱ����
    }
}
