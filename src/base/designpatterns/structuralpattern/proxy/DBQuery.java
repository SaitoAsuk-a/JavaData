package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:38
 * @description DBQuery ����ʵ���⣬����ʵ�ʵ�ҵ�����
 */
public class DBQuery implements IDBQuery {
    public DBQuery() {
        try {
            Thread.sleep(1000);//�������ݿ����ӵȺ�ʱ����
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }

}
