package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:22
 * @description
 */
public class ESTest {

    public static void main(String[] args) {
        Singleton6 singleton6 = Singleton6.INSTANCE;
        singleton6.doSomeThing();//output:ö�ٷ���ʵ�ֵ���
//        Singleton5 singleton5 = Singleton5.getInstance();

    }

}
