package base.designpatterns.other.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date 2019/12/9 15:53
 * @description leaderί����
 */
public class Leader implements  IExcuter {

    private Map<String,IExcuter> targets = new HashMap<String,IExcuter>();
    public Leader() {
        targets.put("����",new ExcuterA());
        targets.put("��¼",new ExcuterB());
    }
    @Override
    public void excute(String command) {
        targets.get(command).excute(command);
    }
}
