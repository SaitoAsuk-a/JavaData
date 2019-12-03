package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:20
 * @description ����ʽ���Ǽ�ʽ/��̬�ڲ��෽ʽ)
 * ��̬�ڲ�ʵ�ֵĵ����������ص����̰߳�ȫ��
 * ֻ��ͨ����ʽ���� getInstance ����ʱ���Ż���ʽװ�� SingletonHolder �࣬�Ӷ�ʵ���� instance��ֻ�е�һ��ʹ�����������ʵ����ʱ��ż��أ�ͬʱ�������̰߳�ȫ���⣩
 *
 * Java�о�̬�ڲ���ļ���ʱ��:
 * �ⲿ����μ��أ����ʼ����̬��������̬����顢��̬����������������ڲ���;�̬�ڲ��ࡣ
 * ʵ�����ⲿ�࣬�����ⲿ��ľ�̬��������̬���������ⲿ������Ƚ��м��أ���ֻ����һ�Ρ�
 * ֱ�ӵ��þ�̬�ڲ���ʱ���ⲿ�಻����ء�
 */
public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {
    }

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
