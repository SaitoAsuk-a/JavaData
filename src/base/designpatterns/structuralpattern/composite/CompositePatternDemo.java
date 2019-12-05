package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/4 19:27
 * @description
 */
public class CompositePatternDemo {
    public static void main(String[] args) {

//        demo1();
        demo2();

    }

    private static void demo2() {
        //һ���ܹ�˾
        ConcreteCompany root = new ConcreteCompany("�����ܹ�˾");
        root.add(new HRDepartment("�ܹ�˾������Դ��"));
        root.add(new FinanceDepartment("�ܹ�˾����"));

        //�����ӹ�˾
        ConcreteCompany com1 = new ConcreteCompany("���ݷֹ�˾");
        com1.add(new HRDepartment("���ݷֹ�˾������Դ��"));
        com1.add(new FinanceDepartment("���ݷֹ�˾����"));
        root.add(com1);

        ConcreteCompany com2 = new ConcreteCompany("���ݷֹ�˾");
        com2.add(new HRDepartment("���ݷֹ�˾������Դ��"));
        com2.add(new FinanceDepartment("���ݷֹ�˾����"));
        root.add(com2);

        ConcreteCompany com3 = new ConcreteCompany("���ڷֹ�˾");
        com3.add(new HRDepartment("���ڷֹ�˾������Դ��"));
        com3.add(new FinanceDepartment("���ڷֹ�˾����"));
        root.add(com3);

        System.out.println("-------��˾�ṹͼ--------");
        root.display(1);
        System.out.println("----------������ְ��----------");
        root.lineofDuty();
    }

    private static void demo1() {
        Employee CEO = new Employee("John", "CEO", 30000);
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //��ӡ����֯������Ա��
        System.out.println("-------------------��˾Ա�����----------------------");
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            //��ӡCEO��ֱ��һ������
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                //��ӡCEO�Ķ�������
                System.out.println(employee);
            }
        }
    }

}
