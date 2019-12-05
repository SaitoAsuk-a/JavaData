package base.designpatterns.structuralpattern.flyweight;

/**
 * @author liyu
 * @date 2019/12/5 12:10
 * @description ������Ԫ�࣬ʵ����Ԫ�ӿڡ�����Ķ��󽫱�����
 */
public class ConcreteFlyWeight implements FlyWeight {


    private String name;

    public ConcreteFlyWeight(String name) {
        this.name = name;
    }

    @Override
    public void action(String externalState) {
        System.out.println(name+"-----"+externalState);
    }
}
