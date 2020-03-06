package base.multithread.aqs;

import java.util.concurrent.*;

/**
 * @author liyu
 * @date 2019/11/26 10:30
 * @description CyclicBarrier(ѭ��դ��)
 * CyclicBarrier �� CountDownLatch �ǳ����ƣ���Ҳ����ʵ���̼߳�ļ����ȴ����������Ĺ��ܱ� CountDownLatch ���Ӹ��Ӻ�ǿ����ҪӦ�ó����� CountDownLatch ���ơ�
 * CyclicBarrier ��������˼�ǿ�ѭ��ʹ�ã�Cyclic�������ϣ�Barrier������Ҫ���������ǣ���һ���̵߳���һ�����ϣ�Ҳ���Խ�ͬ���㣩ʱ��������ֱ�����һ���̵߳�������ʱ�����ϲŻῪ�ţ����б��������ص��̲߳Ż�����ɻCyclicBarrierĬ�ϵĹ��췽���� CyclicBarrier(int parties)���������ʾ�������ص��߳�������ÿ���̵߳���await�������� CyclicBarrier ���Ѿ����������ϣ�Ȼ��ǰ�̱߳�������
 * CyclicBarrier �������ڶ��̼߳������ݣ����ϲ���������Ӧ�ó���������������һ��Excel�������û�����������ˮ��ÿ��Sheet����һ���ʻ���һ���ÿ��������ˮ��������Ҫͳ���û����վ�������ˮ�����ö��̴߳���ÿ��sheet���������ˮ����ִ����֮�󣬵õ�ÿ��sheet���վ�������ˮ���������barrierAction����Щ�̵߳ļ����������������Excel���վ�������ˮ��
 */
public class CyclicBarrierExample2 {
    // ���������
    private static final int threadCount = 550;
    // ��Ҫͬ�����߳�����
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

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
        try {
            /**�ȴ�60�룬��֤���߳���ȫִ�н���*/
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + "is finish");
    }

}
