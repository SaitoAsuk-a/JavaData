package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:17
 * @description ����ʽ(�̰߳�ȫ��
 * JVM�ڼ��������ʱ�����ϴ�����Ψһ�ĵ���ʵ�������һֱû�б�ʹ�ã��˷��˿ռ䣬���͵Ŀռ任ʱ�䣬ÿ�ε��õ�ʱ�򣬲���Ҫ���жϣ���ʡ������ʱ�䡣
 */
public class Singleton {
    //�ھ�̬��ʼ�����д�������ʵ������δ��뱣֤���̰߳�ȫ
    private static Singleton singleton = new Singleton();

    //Singleton��ֻ��һ�����췽�������Ǳ�private���εģ������û��޷�ͨ��new���������ö���ʵ��
    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
