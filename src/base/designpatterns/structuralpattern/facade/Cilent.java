package base.designpatterns.structuralpattern.facade;

/**
 * @author liyu
 * @date 2019/12/5 11:55
 * @description �ͻ�����
 */
public class Cilent {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("=================");
        computer.shutDown();
    }
}
