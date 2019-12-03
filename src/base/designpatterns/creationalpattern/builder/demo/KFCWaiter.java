package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:11
 * @description ����һ��ʹ��Builder�ӿڵĶ�������Ҫ�����ڴ���һ�����ӵĶ�������Ҫ���������ã�һ�ǣ������˿ͻ��������������̣����ǣ�������Ʋ�Ʒ������������̡�
 */
public class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }


    public Meal construct(){
        //׼��ʳ��
        mealBuilder.buildFood();
        //׼������
        mealBuilder.buildDrink();

        //׼����ϣ�����һ���������ײ͸��ͻ�
        return mealBuilder.getMeal();
    }
}
