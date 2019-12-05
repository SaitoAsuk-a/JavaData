package base.designpatterns.structuralpattern.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyu
 * @date 2019/12/5 17:58
 * @description
 */
public class CglibProxyExample implements MethodInterceptor {
    /**
     * �����߼�����
     * @param o �������
     * @param method ����
     * @param objects ��������
     * @param methodProxy ��������
     * @return �����߼�����
     * @throws Throwable �쳣
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("������ʵ����ǰ");
        //CGLIB���������ʵ���󷽷�
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("������ö���֮��");
        return invoke;
    }

    /**
     * ����CGLIB�������
     * @param cls Class��
     * @return Class���CGLIB�������
     */
    public Object getProxy(Class cls,Class[] argumentTypes, Object[] arguments){
        //CGLIB enhancer ��ǿ����
        Enhancer enhancer = new Enhancer();
        //������ǿ����
        enhancer.setSuperclass(cls);
        //��������߼�����Ϊ��ǰ����Ҫ��ǰ����ʵ�� MethodInterceptor ����
        enhancer.setCallback(this);
        //���ɲ����ش������
        return enhancer.create(argumentTypes,arguments);
    }
}
