package base.designpatterns.creationalpattern.prototype;

/**
 * @author liyu
 * @date 2019/12/4 10:05
 * @description �»�����ʽ�ľ���ԭ�ͣ�ʵ����Product�ӿڣ�����ʵ�ָ�������ʵ����������ʵ���ķ�����UnderlinePen���ʵ�ּ�����MessageBox��һ������ͬ�Ŀ���ֻ��use������ʵ��
 */

public class UnderlinePen implements Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        for (int i = 0; i < length + 2; i++) {
            System.out.print(ulchar);

        }
        System.out.println("");
    }

    @Override
    public Product creatClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}

