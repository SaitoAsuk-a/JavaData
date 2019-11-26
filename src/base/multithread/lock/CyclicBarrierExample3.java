package base.multithread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liyu
 * @date 2019/11/26 10:50
 * @description CyclicBarrier���ṩһ�����߼��Ĺ��캯��CyclicBarrier(int parties, Runnable barrierAction)���������̵߳�������ʱ������ִ��barrierAction�����㴦������ӵ�ҵ�񳡾���ʾ����������
 */
public class CyclicBarrierExample3 {

    // ���������
    private static final int threadCount = 550;
    // ��Ҫͬ�����߳�����
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println("------���߳����ﵽ֮������ִ��------");
    });

    public static void main(String[] args) throws InterruptedException {
        // �����̳߳�
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        cyclicBarrier.await();
        System.out.println("threadnum:" + threadnum + "is finish");
    }
}
