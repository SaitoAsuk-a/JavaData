package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 11:05
 * @description
 */
public class Student extends Person{
    static {
        System.out.println("Student.�������ྲ̬�飬�����ڹ����ִ�У� ����ֻ�д�����һ�������ʱ��ִ��һ�Σ�");
    }

    {
        System.out.println("Student.�������๹��飬�����ڹ��췽��ִ�У�ÿ����һ������ִ��һ�Σ�");
    }

    public Student() {
        System.out.println("Student.�������๹�췽����ÿ����һ������ִ��һ��");
    }

    public void function1() {
        System.out.println("Student.��������Ǿ�̬�����е���ͨ����飬 ����������ʱִ�У�");
    }

    public static void function2() {
        System.out.println("Student.�������ྲ̬�����е���ͨ����飬����������ʱִ�У����ھ�̬��ִ�У�");
    }
}
