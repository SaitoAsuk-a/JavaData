package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:10
 * @description ����ʵ�ֻ�(Concrete Implementor)��ɫ��
 * �����ɫ����ʵ�ֻ���ɫ�ӿڵľ���ʵ�֡�
 */

public class ConcreteImplementor implements Implementor {
    public void operationImpl() {
        //����ʵ��
        System.out.println("ConcreteImplementor.class.getName() = " + ConcreteImplementor.class.getName());
    }
}
