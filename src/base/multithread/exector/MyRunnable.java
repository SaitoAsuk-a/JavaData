package base.multithread.exector;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/24 17:04
 * @description ����һ���򵥵�Runnable�࣬��Ҫ��Լ5������ִ��������
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}