package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:43
 * @description DBQueryProxy �� DBQuery �� �ӳټ��ش���
 */
public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        // TODO Auto-generated method stub
        //��������Ҫ��ʱ����ܴ�����ʵ���󣬴������̿��ܺ���
        if (real == null) {
            real = new DBQuery();
        }
        //�ڶ��̻߳����£����ﷵ��һ������࣬������ Future ģʽ
        return real.request();
    }

}
