package base.designpatterns.behavioralpattern.memento;

/**
 * @author liyu
 * @date 2019/12/8 16:21
 * @description ���� Memento �ࡣ
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
