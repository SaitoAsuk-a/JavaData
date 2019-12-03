package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:15
 * @description AK�ӵ���
 */
public class AKBullet implements Bullet {

    @Override
    public void load() {
        System.out.println("Load bullets with AK");
    }

}

