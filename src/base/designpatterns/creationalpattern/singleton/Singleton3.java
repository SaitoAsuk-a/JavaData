package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:23
 * @description
 * ����ÿ��ʹ��getInstance() ��Ҫ����synchronized������һ�㣬�����������getInstance()�ķ�����ʱ�����ѣ����һ����ܻᷢ������
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    //û�м���synchronized�ؼ��ֵİ汾���̲߳���ȫ��
    public static synchronized Singleton3 getSingletion3() {
        //�жϵ�ǰ�����Ƿ��Ѿ����ڣ��������򷵻أ����������ٽ�������
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
