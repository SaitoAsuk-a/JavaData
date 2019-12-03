package base.designpatterns.creationalpattern.factory.simplefactory;

/**
 * @author liyu
 * @date 2019/12/3 13:45
 * @description ���Է���
 */

public class Test {

    public static void main(String[] args) {

        // ��ȡ Circle �Ķ��󣬲��������� draw ����
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // ��ȡ Rectangle �Ķ��󣬲��������� draw ����
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // ��ȡ Square �Ķ��󣬲��������� draw ����
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();

        //ʹ���ع���Ľ��в���
        Shape circle1 = ShapeFactory.CreateShape("CIRCLE");
        circle1.draw();

        //ʹ�÷����Ĳ���
        Circle aClass = (Circle) ShapeFactory2.getClass(Circle.class);//��������ȫ·��
        aClass.draw();
    }
}
