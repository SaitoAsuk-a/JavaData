package base.designpatterns.behavioralpattern.interpreter;

/**
 * @author liyu
 * @date 2019/12/8 14:15
 * @description ����ʵ���������ӿڵ�ʵ���ࡣ
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
