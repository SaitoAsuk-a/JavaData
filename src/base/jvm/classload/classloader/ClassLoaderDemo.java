package base.jvm.classload.classloader;

/**
 * @author liyu
 * @date 2019/12/12 14:12
 * @description ÿ������ض���һ�����������
 * AppClassLoader�ĸ��������ΪExtClassLoader ExtClassLoader�ĸ��������Ϊnull��null��������ExtClassLoaderû�и�������������� BootstrapClassLoader ��
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
