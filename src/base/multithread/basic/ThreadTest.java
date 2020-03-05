package base.multithread.basic;

/**
 * @author liyu
 * @date 2019/12/18 17:25
 * @description ��֤�̵߳��ڴ�����
 * <p>
 * Ϊʲô���ǵ��� start() ����ʱ��ִ�� run() ������Ϊʲô���ǲ���ֱ�ӵ��� run() ������
 * ������һ���ǳ������ java ���߳��������⣬�����������лᾭ�����ʵ����ܼ򵥣����Ǻܶ��˶����������
 * new һ�� Thread���߳̽������½�״̬;���� start() ������������һ���̲߳�ʹ�߳̽����˾���״̬�������䵽ʱ��Ƭ��Ϳ��Կ�ʼ�����ˡ� start() ��ִ���̵߳���Ӧ׼��������Ȼ���Զ�ִ�� run() ���������ݣ����������Ķ��̹߳����� ��ֱ��ִ�� run() ��������� run ��������һ�� main �߳��µ���ͨ����ȥִ�У���������ĳ���߳���ִ�����������Ⲣ���Ƕ��̹߳�����
 * �ܽ᣺ ���� start �������������̲߳�ʹ�߳̽������״̬���� run ����ֻ�� thread ��һ����ͨ�������ã����������߳���ִ�С�
 */
public class ThreadTest {

    //    static volatile boolean flag = false;
    static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("flag = " + flag);
        });

        thread.start();
        thread.sleep(2000);
        flag = true;
        System.out.println("flag1 = " + flag);

    }

}
