package base.designpatterns.behavioralpattern.chainofresponsibility;

/**
 * @author liyu
 * @date 2019/12/6 9:50
 * @description �������߽�ɫ(Handler)�������һ����������Ľӿڡ������Ҫ���ӿڿ��Զ����һ���������趨�ͷ��ض��¼ҵ����á������ɫͨ����һ��Java���������Java�ӿ�ʵ�֡�
 */
public abstract class Handler {

    /**
     * ���к�̵����ζ���
     */
    protected Handler successor;

    /**
     * ʾ�⴦������ķ�������Ȼ���ʾ�ⷽ����û�д��������
     * ��ʵ���ǿ��Դ�������ģ����ݾ�����Ҫ��ѡ���Ƿ񴫵ݲ���
     */
    public abstract void handleRequest();

    /**
     * ȡֵ����
     */
    public Handler getSuccessor() {
        return successor;
    }

    /**
     * ��ֵ���������ú�̵����ζ���
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}
