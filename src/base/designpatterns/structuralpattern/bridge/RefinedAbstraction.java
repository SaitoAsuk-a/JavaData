package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:12
 * @description ��������(Refined Abstraction)��ɫ����չ���󻯽�ɫ���ı����������Գ��󻯵Ķ��塣
 */

public class RefinedAbstraction extends Abstraction {
    public void operation() {
        System.out.println("\"impl\" = " + "impl");
        //����
        impl.operationImpl();
        //����
    }
}
