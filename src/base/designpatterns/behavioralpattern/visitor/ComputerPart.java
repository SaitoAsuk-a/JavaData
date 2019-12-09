package base.designpatterns.behavioralpattern.visitor;

/**
 * @author liyu
 * @date 2019/12/9 15:09
 * @description ����һ����ʾԪ�صĽӿ�
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
