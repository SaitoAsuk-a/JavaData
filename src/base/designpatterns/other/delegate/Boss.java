package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:54
 * @description boss��ģ����ò���
 */
public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        //����ȥ���������ǵ���Ŀ�����ڸɻ�
        //��ʵ�ʸɻ��������ͨԱ��
        //����ǵ��ͣ��ɻ����ҵģ����������
        leader.excute("��¼");
        leader.excute("����");
    }
}
