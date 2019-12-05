package base.designpatterns.creationalpattern.prototype;

/**
 * @author liyu
 * @date 2019/12/4 9:50
 * @description Product�ӿ��Ǹ��ƹ��ܽӿڣ��ýӿڼ̳���java.lang.Cloneable(ֻ��ʵ���˸ýӿڵ����ʵ���ſ��Ե���clone()��������ʵ��,������׳��쳣).
 */
public interface Product extends Cloneable {
    //use���������ڡ�ʹ�á��ķ�����������ô��ʹ�á����򱻽�������ȥʵ�֡�
    public abstract void use(String s);

    //creatClone���������ڸ���ʵ���ķ���
    public abstract Product creatClone();

}

