package base.designpatterns.structuralpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liyu
 * @date 2019/12/5 16:47
 * @description �� 1 ������������������ʵ����Ĺ�ϵ��������ʹ���� bind ����ȥ��ɵ� �� ��������������������� target ��������ʵ���� �� Ȼ��ͨ�����´��뽨�������ɴ������
 * �� 2 ����ʵ�ִ����߼������� invoke ������ ��ʵ�ִ����߼���
 */
public class JdkProxyExample implements InvocationHandler {
    //��ʵ����
    private Object target = null;


    /**
     * �������߼�
     *
     * @param proxy  ������󣬾��� bind �������ɵĶ���
     * @param method ��ǰ���ȷ���
     * @param args   ��ǰ�������ز���
     * @return ����������
     * @throws Throwable �쳣
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("��������߼�����");
        System.out.println("-----------");
        Object invoke = method.invoke(target, args);
        System.out.println("--------------");
        return invoke;
    }

    /**
     * ������ʵ������������Ĺ�ϵ
     *
     * @param target ��ʵ����
     * @return �������
     */
    public Object bind(Object target) {
        this.target = target;
        /**
         *  newProxyInstance �������� 3 ������
         *  �� 1 ����������������ǲ����� target ���� ���������
         *  �� 2 ���ǰ����ɵĶ�̬��������¹�����Щ�ӿ��� �����д�����Ƿ��� target ʵ�ֵĽӿ��¡� HelloWorldImpl ����Ľӿ���Ȼ���� HelloWorld���������������������� HelloWorld proxy = xxxx ��
         *  �� 3 ���Ƕ���ʵ�ַ����߼��Ĵ����࣬ this ��ʾ��ǰ����������ʵ��InvocationHandler �ӿڵ� invoke ���� �������Ǵ����߼���������ʵ������
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
