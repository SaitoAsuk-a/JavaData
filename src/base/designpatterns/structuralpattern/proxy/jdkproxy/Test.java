package base.designpatterns.structuralpattern.proxy.jdkproxy;

/**
 * @author liyu
 * @date 2019/12/5 17:21
 * @description JDK ��̬��������ṩ�ӿڲ���ʹ��
 */
public class Test {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        //�󶨹�ϵ����Ϊ���ڽӿ� HelloWorld �£���������������� HelloWorld proxy
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        //ע�� ����ʱ HelloWorld ���󼺾���һ���������������������߼����� invoke ��
        proxy.sayHelloWorld("liyu");
    }
}
