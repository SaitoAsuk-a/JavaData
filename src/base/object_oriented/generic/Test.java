package base.object_oriented.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2020/4/16 14:22
 * @description
 */
public class Test {
    public static void main(String[] args) {
        List<? super Fruit> list = new ArrayList<>();
        list.add(new Apple("apple"));
        list.add(new Banana("banana"));
        list.add(new Fruit("fruit"));
        testExtend((List<? extends Fruit>) list);
    }

    public static void testExtend(List<? extends Fruit> list) {
        //����,extendsΪ�Ͻ�ͨ���,ֻ��ȡֵ,���ܷ�.
        //��ΪFruit�����಻ֻ��Apple����Banana,���ﲻ��ȷ������ķ��͵�����Apple����Banana�����Է����κ�һ�����Ͷ��ᱨ��
        //list.add(new Apple());
//        list.add(new Banana())

//        Fruit fruit = list.get(0);
        list.forEach(Food::getName);
    }

    public void testSuper(List<? super Fruit> list) {
        list.add(new Apple("1"));
        //superΪ�½�ͨ��������Դ��Ԫ�أ�����Ҳֻ�ܴ�ŵ�ǰ����������ʵ�����Ե�ǰ������������
        //�޷�ȷ��Fruit�ĸ����Ƿ�ֻ��Foodһ��(Object�ǳ�������)
        //��˷���Food��ʵ�����벻ͨ��
//        list.add(new Food("s"));
        Object object = list.get(0);
    }
}
