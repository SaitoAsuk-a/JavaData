package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:21
 * @description ����ʽ�����̰߳�ȫ��synchronized�ؼ����̰߳�ȫ�汾 ��
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {
    }

    //û�м���synchronized�ؼ��ֵİ汾���̲߳���ȫ��
    public static Singleton2 getSingleton2() {
        //�жϵ�ǰ�����Ƿ��Ѿ����ڣ��������򷵻أ����������ٽ�������
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
