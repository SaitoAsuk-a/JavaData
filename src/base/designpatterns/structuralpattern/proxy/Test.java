package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:44
 * @description
 */
public class Test {
    public static void main(String[] args){
        IDBQuery q = new DBQueryProxy(); //ʹ�ô���
        String request = q.request();//������ʹ��ʱ�Ŵ�����ʵ����
        System.out.println("request = " + request);
    }
}
