package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 11:04
 * @description
 */
public class Person {
    static {
        System.out.println("1.���Ǹ��ྲ̬�飬�����ڹ����ִ�У� ����ֻ�д�����һ�������ʱ��ִ��һ�Σ�");
    }

    {
        System.out.println("2.���Ǹ��๹��飬�����ڹ��췽��ִ�У�ÿ����һ������ִ��һ�Σ�");
    }

    public Person() {
        System.out.println("3.���Ǹ��๹�췽����ÿ����һ������ִ��һ��");
    }

    public void function1() {
        System.out.println("���Ǹ���Ǿ�̬�����е���ͨ����飬 ����������ʱִ�У�");
    }

    public static void function2() {
        System.out.println("���Ǹ��ྲ̬�����е���ͨ����飬����������ʱִ�У����ھ�̬��ִ�У�");
    }
}
