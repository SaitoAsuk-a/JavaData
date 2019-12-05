package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/5 9:09
 * @description ����˾���ӿ�
 */
public abstract class Company {

    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);//add

    public abstract void remove(Company company);//remove

    public abstract void display(int depth);//display

    public abstract void lineofDuty();//line of duty

}

