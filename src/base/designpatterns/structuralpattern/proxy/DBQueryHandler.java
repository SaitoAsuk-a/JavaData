package base.designpatterns.structuralpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:46
 * @description ���������õ� Handler������ʵ�ִ��������ڲ��߼���
 */
public class DBQueryHandler implements InvocationHandler {
    IDBQuery realQuery = null;//��������ӿ�

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("proxy = " + proxy);
        //�����һ�ε��ã�������ʵ����
        if (realQuery == null) {
            realQuery = new DBQuery();
        }
        //������ʵ�������ʵ�ʵĲ���
        return realQuery.request();
    }
    public static IDBQuery createProxy(){
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new DBQueryHandler());
        return proxy;
    }

}
