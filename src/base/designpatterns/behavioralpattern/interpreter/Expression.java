package base.designpatterns.behavioralpattern.interpreter;

/**
 * @author liyu
 * @date 2019/12/8 14:14
 * @description ����һ�����ʽ�ӿ�
 */
public interface Expression {
    public boolean interpret(String context);
}
