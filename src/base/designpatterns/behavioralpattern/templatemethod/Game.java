package base.designpatterns.behavioralpattern.templatemethod;

/**
 * @author liyu
 * @date 2019/12/9 14:36
 * @description
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //ģ��
    public final void play(){

        //��ʼ����Ϸ
        initialize();

        //��ʼ��Ϸ
        startPlay();

        //������Ϸ
        endPlay();
    }
}
