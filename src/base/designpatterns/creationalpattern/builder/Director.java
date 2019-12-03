package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 15:00
 * @description Director��ָ���ߣ�������һ��ʹ��Builder�ӿڵĶ�������Ҫ�����ڴ���һ�����ӵĶ�������Ҫ���������ã�һ�ǣ������˿ͻ��������������̣����ǣ�������Ʋ�Ʒ�������������
 */
public class Director {
    private Builder builder;

    //1 ���췽���ķ�ʽע��builder����
    public Director(Builder builder) {
        this.builder = builder;
    }

    //2 set����ע��builder����
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
