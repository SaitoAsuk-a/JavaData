package base.jvm.GC;

/**
 * @author liyu
 * @date 2019/12/11 14:01
 * @description ���������£��������������� eden �����䡣�� eden ��û���㹻�ռ���з���ʱ�������������һ�� Minor GC.
 * ������ GC��Minor GC��:ָ�����������ĵ������ռ�������Minor GC �ǳ�Ƶ���������ٶ�һ��Ҳ�ȽϿ졣
 * ����� GC��Major GC/Full GC��:ָ������������� GC�������� Major GC �������������һ�ε� Minor GC�����Ǿ��ԣ���Major GC ���ٶ�һ���� Minor GC ���� 10 �����ϡ�
 * -XX:+PrintGCDetails
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
//        allocation2 = new byte[900*1024];
    }
}
