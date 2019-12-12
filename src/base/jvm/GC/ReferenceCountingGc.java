package base.jvm.GC;

/**
 * @author liyu
 * @date 2019/12/11 14:19
 * @description ���ü�����
 * �����������һ�����ü�������ÿ����һ���ط����������������ͼ� 1��������ʧЧ���������ͼ� 1���κ�ʱ�������Ϊ 0 �Ķ�����ǲ������ٱ�ʹ�õġ�
 * �������ʵ�ּ򵥣�Ч�ʸߣ�����Ŀǰ������������в�û��ѡ������㷨�������ڴ棬������Ҫ��ԭ���������ѽ������֮���໥ѭ�����õ����⡣
 * ��ν����֮����໥�������⣬�����������ʾ�����˶��� objA �� objB �໥�����ŶԷ�֮�⣬
 * ����������֮�������κ����á�����������Ϊ�������öԷ����������ǵ����ü���������Ϊ 0���������ü����㷨�޷�֪ͨ GC �������������ǡ�
 */
public class ReferenceCountingGc {
    Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;

    }

}
