package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 16:41
 * @description
 */
public class Teacher extends Person {

    public static Integer a;

    static {
        System.out.println("Teacher.�������ྲ̬�飬�����ڹ����ִ�У� ����ֻ�д�����һ�������ʱ��ִ��һ�Σ�");
        a=10;
        System.out.println("a = " + a);
    }

    {
        System.out.println("Teacher.�������๹��飬�����ڹ��췽��ִ�У�ÿ����һ������ִ��һ�Σ�");
    }

    public Teacher() {
        System.out.println("Teacher.�������๹�췽����ÿ����һ������ִ��һ��");
    }

    public void function1() {
        System.out.println("Teacher.��������Ǿ�̬�����е���ͨ����飬 ����������ʱִ�У�");
    }

    public static void function2() {
        System.out.println("Teacher.�������ྲ̬�����е���ͨ����飬����������ʱִ�У����ھ�̬��ִ�У�");
    }
}
