package base.designpatterns.behavioralpattern.chainofresponsibility;

/**
 * @author liyu
 * @date 2019/12/6 9:52
 * @description ���崦���߽�ɫ(ConcreteHandler)��
 * ���崦���߽ӵ�����󣬿���ѡ��������������߽����󴫸��¼ҡ����ھ��崦���߳��ж��¼ҵ����ã���ˣ������Ҫ�����崦���߿��Է����¼ҡ�
 */
public class ConcreteHandler extends Handler {
    /**
     * �����������ô˷�����������
     */
    @Override
    public void handleRequest() {
        /**
         * �ж��Ƿ��к�̵����ζ���
         * ����У���ת���������̵����ζ���
         * ���û�У���������
         */
        if (getSuccessor() != null) {
            System.out.println("�Ź�����");
            getSuccessor().handleRequest();
        } else {
            System.out.println("��������");
        }
    }

}
