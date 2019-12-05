package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/5 9:14
 * @description ���񲿣���Ҷ�ڵ㣩
 */
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void display(int depth) {
        System.out.println("�� " + depth + " ��Ļ�����Ϊ�� " + name);
    }

    @Override
    public void lineofDuty() {
        System.out.println(name + "    ����Ա����Ƹ������ѵ");
    }

    @Override
    public void remove(Company company) {

    }

}

