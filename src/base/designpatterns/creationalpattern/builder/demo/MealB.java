package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:11
 * @description B�ײͣ�
 */
public class MealB extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("���ʹ�֭");
    }

    public void buildFood() {
        meal.setFood("����");
    }

}
