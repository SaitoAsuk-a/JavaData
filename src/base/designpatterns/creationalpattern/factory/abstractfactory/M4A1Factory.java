package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:17
 * @description ����M4A1��M4A1�ӵ��Ĺ���
 */
public class M4A1Factory implements Factory{

    @Override
    public Gun produceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1Bullet();
    }

}
