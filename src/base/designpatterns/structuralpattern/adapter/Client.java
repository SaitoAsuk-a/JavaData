package base.designpatterns.structuralpattern.adapter;

/**
 * @author liyu
 * @date 2019/12/4 11:00
 * @description ʹ���������Ŀͻ���
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
