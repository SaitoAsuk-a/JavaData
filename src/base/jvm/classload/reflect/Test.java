package base.jvm.classload.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyu
 * @date 2019/12/5 15:29
 * @description
 */
public class Test {
    public static void main(String[] args) {
        //�������ɶ������
        demo1();

        //���䷽������
        Object o = reflectMethod();
        if (o instanceof String) {
            System.out.println("o = " + o);
        }
    }

    private static void demo1() {
        ReflectServicelmpl reflectServicelmplInstance = getReflectServicelmplInstance();
        reflectServicelmplInstance.sayHello("liyu");
        String param = reflectServicelmplInstance.getParam();
        System.out.println("param = " + param);
    }

    //�������ɶ���
    public static ReflectServicelmpl getReflectServicelmplInstance() {
        ReflectServicelmpl object = null;
        try {
            object = (ReflectServicelmpl) Class.forName("base.jvm.classload.reflect.ReflectServicelmpl").getConstructor(String.class).newInstance("����");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    //���䷽��
    public static Object reflectMethod() {
        Object returnObj = null;
        try {
            ReflectServicelmpl reflectServicelmpl = (ReflectServicelmpl) Class.forName("base.jvm.classload.reflect.ReflectServicelmpl").getConstructor(String.class).newInstance("����");
            Method sayHello = reflectServicelmpl.getClass().getMethod("sayHello", String.class);
            returnObj = sayHello.invoke(reflectServicelmpl, "liyu");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnObj;
    }
}
