package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:53
 * @description ��ͨԱ��B
 */
public class ExcuterB implements IExcuter {
    @Override
    public void excute(String command) {
        System.out.println("Ա��B ��ʼ��" + command + "�Ĺ���");
    }
}
