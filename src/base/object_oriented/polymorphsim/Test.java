package base.object_oriented.polymorphsim;

/**
 * @author liyu
 * @date 2020/4/14 16:26
 * @description Ϊ��ʵ�������ڵĶ�̬������˵�Ƕ�̬�󶨣���Ҫ��������������
 * ������̳л��߽ӿ�ʵ�֡�����Ҫ��д����ķ��������������ָ������Ķ���
 */
public class Test{

    public static void main(String[] args){
        Parent p = new Son(); //3.���������ָ������Ķ���
        Parent p1 = new Daughter(); //3.���������ָ������Ķ���
    }
}
