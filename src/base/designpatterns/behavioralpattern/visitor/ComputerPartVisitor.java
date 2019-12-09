package base.designpatterns.behavioralpattern.visitor;

/**
 * @author liyu
 * @date 2019/12/9 15:11
 * @description ����һ����ʾ�����ߵĽӿ�
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);

    public void visit(Mouse mouse);

    public void visit(Keyboard keyboard);

    public void visit(Monitor monitor);
}
