package base.designpatterns.creationalpattern.prototype;

import java.util.HashMap;

/**
 * @author liyu
 * @date 2019/12/4 9:51
 * @description Manager��ʹ��Product�ӿ�������ʵ����
 * Product�ӿ��Լ�Manager��Ĵ�����ȫû�г�����MessageBox���UnderlinePen������֣�
 * �������ζ�����ǿ��Զ������޸�Product�ӿ��Լ�Manager�࣬����MessageBox���UnderlinePen���Ӱ�졣
 * ���Ƿǳ���Ҫ�ģ���Ϊ һ��������ʹ�õ��˱������������ζ�Ÿ�������������ܵĵ��������һ�� ��
 * ��Manager���У���û��д������������� ����ʹ����Product����ӿ�����Ҳ����˵��Product�ӿڳ�Ϊ������Manager��������������֮���������
 */

public class Manager {
    //����ʵ���ġ����֡��͡�ʵ����֮��Ķ�Ӧ��ϵ
    private HashMap<String, Product> showcase = new HashMap<String, Product>();

    //register���������յ���һ�顰���֡��͡�Product�ӿڡ�ע�ᵽshowcase�С�����Product��ʵ��Product�ӿڵ�ʵ�������廹δȷ��
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productName) {
        Product p = showcase.get(productName);
        return p.creatClone();
    }

}
