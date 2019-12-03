package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:16
 * @description ���������ӿ�
 */
public interface Factory {
    public Gun produceGun();
    public Bullet produceBullet();
}

