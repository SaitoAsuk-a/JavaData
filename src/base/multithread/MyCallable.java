package base.multithread;

import java.util.concurrent.Callable;

/**
 * @author liyu
 * @date 2019/11/24 17:43
 * @description
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //����ִ�е�ǰ Callable ���߳�����
        return Thread.currentThread().getName();
    }
}