package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 14:58
 * @description
 */
public class MiddlePen extends Pen {
    public void draw(String name) {
        String penType = "�к�ë�ʻ���";
        this.color.bepaint(penType, name);
    }
}
