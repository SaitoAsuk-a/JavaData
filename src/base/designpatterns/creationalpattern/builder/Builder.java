package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 14:31
 * @description Builder���������ߣ�������һ��Product����ĸ�������ָ���ĳ���ӿڡ�
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}
