package base.object_oriented.overloading_vs_overriding.overloading;

/**
 * @author liyu
 * @date 2020/4/14 16:40
 * @description ���ص�����
 * 1.�����صķ�������ı�����б�
 * 2.�����صķ������Ըı䷵�����ͣ�
 * 3.�����صķ������Ըı�������η���
 * 4.�����صķ������������µĻ����ļ���쳣��
 * 5.�����ܹ���ͬһ�����л�����һ�������б����ء�
 */
class Dog {
    public void bark() {
        System.out.println("woof ");
    }

    //overloading method
    public void bark(int num) {
        for (int i = 0; i < num; i++)
            System.out.println("woof ");
    }
}

