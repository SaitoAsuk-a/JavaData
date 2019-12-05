package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:11
 * @description ����(Abstraction)��ɫ��
 * ���󻯸����Ķ��壬������һ����ʵ�ֻ���������á�
 */

public abstract class Abstraction {
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation();
}

