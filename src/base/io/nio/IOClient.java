package base.io.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author liyu
 * @date 2019/11/26 11:41
 * @description ��ʾ��BIOͨ�ţ�һ����һӦ��ģ�͡����ǻ��ڿͻ��˴�������߳��������ӷ���˲����䷢��"��ǰʱ��+:hello world"������˻�Ϊÿ���ͻ����̴߳���һ���߳�������
 */
public class IOClient {
    public static void main(String[] args) {
        // TODO ��������̣߳�ģ�����ͻ������ӷ����
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

    }

}
