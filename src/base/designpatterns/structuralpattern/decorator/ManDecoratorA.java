package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:17
 * @description ConcreteDecorator������װ���ߣ�
 * �����װ�ζ��󣬸��ڲ����еľ��屻װ�ζ������Ӿ����ְ��
 */
public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA��");
    }

    public void reEat() {
        System.out.println("�ٳ�һ�ٷ�");
    }
}

