package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:16
 * @description ����AK��AK�ӵ��Ĺ���
 */
public class AKFactory implements Factory{

    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AKBullet();
    }

}

