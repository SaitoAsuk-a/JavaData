package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:52
 * @description ��ͨԱ��A
 */
public class ExcuterA implements IExcuter {

    @Override
    public void excute(String command) {
        System.out.println("Ա��A ��ʼ��" + command + "�Ĺ���");
    }
}
