package base.designpatterns.structuralpattern.facade;

/**
 * @author liyu
 * @date 2019/12/5 11:40
 * @description cpu��ϵͳ��
 * ʵ������ϵͳ�Ĺ��ܡ����Կͻ���ɫ��Facadeʱδ֪�ġ����ڲ�������ϵͳ�ڵ��໥������Ҳ�����ɹ������õĽӿ�
 */
public class CPU {

    public void start() {
        System.out.println("cpu is start...");
    }

    public void shutDown() {
        System.out.println("CPU is shutDown...");
    }
}
