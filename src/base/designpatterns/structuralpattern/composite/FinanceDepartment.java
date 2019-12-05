package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/5 10:50
 * @description ������Դ������Ҷ�ڵ㣩
 */
public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
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
        System.out.println(name + "   ����˾������֧����");
    }

    @Override
    public void remove(Company company) {

    }

}

