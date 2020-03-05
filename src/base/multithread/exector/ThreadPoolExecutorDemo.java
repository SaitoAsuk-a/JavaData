package base.multithread.exector;

import base.multithread.exector.MyRunnable;

import java.util.concurrent.*;

/**
 * @author liyu
 * @date 2019/11/24 17:06
 * @description ʹ���̳߳صĺô���
 * <p>
 * ������Դ���ġ�ͨ���ظ������Ѵ������߳̽����̴߳�����������ɵ����ġ�
 * �����Ӧ�ٶȡ������񵽴�ʱ��������Բ���Ҫ�ĵȵ��̴߳�����������ִ�С�
 * ����̵߳Ŀɹ����ԡ��߳���ϡȱ��Դ����������ƵĴ���������������ϵͳ��Դ�����ή��ϵͳ���ȶ��ԣ�ʹ���̳߳ؿ��Խ���ͳһ�ķ��䣬���źͼ�ء�
 * <p>
 * ʹ�� ThreadPoolExecutor ���캯���Զ�������ķ�ʽ�������̳߳�
 * corePoolSize: �����߳���Ϊ ��
 * maximumPoolSize ������߳���
 * keepAliveTime : �ȴ�ʱ��Ϊ ��
 * unit: �ȴ�ʱ��ĵ�λΪ TimeUnit.SECONDS��
 * workQueue���������Ϊ ArrayBlockingQueue,..����������Ϊ XX;
 * threadFactory :executor �������̵߳�ʱ����õ�,һ��ʹ��Ĭ��
 * handler:���Ͳ���Ϊ��
 * 1>.ThreadPoolExecutor.AbortPolicy���׳� RejectedExecutionException���ܾ�������Ĵ���
 * 2>.ThreadPoolExecutor.CallerRunsPolicy������ִ���Լ����߳����������������������󡣵������ֲ��Իή�Ͷ����������ύ�ٶȣ�Ӱ�������������ܡ����⣬�������ϲ�����Ӷ����������������Ӧ�ó�����Գ��ܴ��ӳٲ����㲻���������κ�һ����������Ļ��������ѡ��������ԡ�
 * 3>.ThreadPoolExecutor.DiscardPolicy�� ������������ֱ�Ӷ�������
 * 4>.ThreadPoolExecutor.DiscardOldestPolicy�� �˲��Խ����������δ�������������
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //�÷�������һ���̶��߳��������̳߳ء����̳߳��е��߳�����ʼ�ղ��䡣����һ���µ������ύʱ���̳߳������п����̣߳�������ִ�С�
        // ��û�У����µ�����ᱻ�ݴ���һ����������У������߳̿���ʱ���㴦������������е�����
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        //��������һ��ֻ��һ���̵߳��̳߳ء�������һ�������ύ�����̳߳أ�����ᱻ������һ����������У����߳̿��У��������ȳ���˳��ִ�ж����е�����
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //�÷�������һ���ɸ���ʵ����������߳��������̳߳ء��̳߳ص��߳�������ȷ���������п����߳̿��Ը��ã��������ʹ�ÿɸ��õ��̡߳��������߳̾��ڹ����������µ������ύ����ᴴ���µ��̴߳�������
        // �����߳��ڵ�ǰ����ִ����Ϻ󣬽������̳߳ؽ��и��á�
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //ʹ�ð���Ͱ��Ƽ��Ĵ����̳߳صķ�ʽ
        //ͨ��ThreadPoolExecutor���캯���Զ����������
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //����WorkerThread����WorkerThread��ʵ����Runnable �ӿڣ�
            Runnable worker = new MyRunnable("" + i);
            //ִ��Runnable
            executor.execute(worker);
        }
        //��ֹ�̳߳�
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
