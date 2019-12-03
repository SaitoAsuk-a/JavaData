package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:12
 * @description
 */
public class Test {
    public static void main(String[] args) {

        //�ײ�A
        MealA a = new MealA();
        //׼���ײ�A�ķ���Ա
        KFCWaiter waiter = new KFCWaiter(a);
        //����ײ�
        Meal mealA = waiter.construct();
        System.out.print("�ײ�A����ɲ���:");
        System.out.println("ʳ�"+mealA.getFood()+"��   "+"��Ʒ��"+mealA.getDrink());
    }
}
