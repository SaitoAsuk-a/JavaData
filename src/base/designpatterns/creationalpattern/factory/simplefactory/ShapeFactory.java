package base.designpatterns.creationalpattern.factory.simplefactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author liyu
 * @date 2019/12/3 12:15
 * @description ������
 * ������ʵ���и����⣬�������������Ʒ��Ļ�������Ҫ�޸Ĺ������е�getShape����������������Բ����� ����-���ԭ��
 */

public class ShapeFactory {

    // ʹ�� getShape ������ȡ��״���͵Ķ���
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }


    //ʹ�ú���ʽ��̽����ع�
    private final static Map<String, Supplier<Shape>> map=new HashMap<>();
    static {
        map.put("CIRCLE",Circle::new);
        map.put("RECTANGLE",Rectangle::new);
        map.put("SQUARE",Square::new);
    }
    public static Shape CreateShape(String name){
        Supplier<Shape> shapeSupplier = map.get(name);
        if (shapeSupplier==null) {
            throw new IllegalArgumentException("no such shape name :"+name);
        }
        return shapeSupplier.get();
    }
}
