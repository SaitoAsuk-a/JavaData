package base.designpatterns.creationalpattern.factory.simplefactory;

/**
 * @author liyu
 * @date 2019/12/3 13:48
 * @description ���÷������򵥹���ÿ���������˲�Ʒ�඼Ҫ�޸Ĳ�Ʒ�����ı׶�
 */
public class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
