package base.multithread.basic;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author liyu
 * @date 2020/3/5 11:54
 * @description ThreadLocal����Ҫ����ľ�����ÿ���̰߳��Լ���ֵ�����Խ�ThreadLocal������ı����ɴ�����ݵĺ��ӣ������п��Դ洢ÿ���̵߳�˽�����ݡ�
 * ����㴴����һ��ThreadLocal��������ô�������������ÿ���̶߳�������������ı��ظ�������Ҳ��ThreadLocal�����������������ǿ���ʹ�� get���� �� set���� ��������ȡĬ��ֵ����ֵ����Ϊ��ǰ�߳�����ĸ�����ֵ���Ӷ��������̰߳�ȫ���⡣
 */

public class ThreadLocalDemo {
    // SimpleDateFormat �����̰߳�ȫ�ģ�����ÿ���̶߳�Ҫ���Լ������ĸ���
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //formatter pattern is changed here by thread, but it won't reflect to other threads
            formatter.set(new SimpleDateFormat());

            System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());

        }).start();
    }

}
