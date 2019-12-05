package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:10
 * @description Decorator��װ���߳����ࣩ
 * ά��һ��ָ��Componentʵ�������ã�������һ����Component�ӿ�һ�µĽӿ�
 */
public abstract class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}
