package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:22
 * @description ʵ�ֵ���ģʽ����ѷ���
 * ��࣬�Զ�֧�����л����ƣ����Է�ֹ���ʵ���� �����������ʵ����Serializable�ӿڣ�Ĭ�������ÿ�η����л��ܻᴴ��һ���µ�ʵ������
 */
public enum  Singleton6 {
    //����һ��ö�ٵ�Ԫ�أ������� Singleton ��һ��ʵ��
    INSTANCE;

    public void doSomeThing() {
        System.out.println("ö�ٷ���ʵ�ֵ���");
    }
}
