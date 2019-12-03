package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:09
 * @description ����һ��Product����ĸ�������ָ���ĳ���ӿڡ�
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}
