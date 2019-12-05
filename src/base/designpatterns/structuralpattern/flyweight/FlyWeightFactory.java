package base.designpatterns.structuralpattern.flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyu
 * @date 2019/12/5 13:45
 * @description ��Ԫģʽ�У���ؼ�����Ԫ������
 * ����ά���Ѵ�������Ԫʵ������ͨ��ʵ����ǣ�һ�����ڲ�״̬��ȥ������Ӧ��ʵ����
 * ��Ŀ�����δ����ʱ����Ԫ�������𴴽�ʵ�������������-����ӳ�䡣
 * ��Ŀ������Ѵ���ʱ����Ԫ����ֱ�ӷ�������ʵ����ʵ�ֶ���ĸ���
 */
public class FlyWeightFactory {
    private static ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();

    public static FlyWeight getFlyWeight(String name) {
        if (allFlyWeight.get(name) == null) {
            synchronized (allFlyWeight) {
                if (allFlyWeight.get(name) == null) {
                    System.out.println("Instance of name = {} does not exist, creating it");
                    FlyWeight flyWeight = new ConcreteFlyWeight(name);
                    System.out.println("Instance of name = {} created");
                    allFlyWeight.put(name, flyWeight);
                }
            }
        }
        return allFlyWeight.get(name);
    }
}
