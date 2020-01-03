package algorithm.recursion;

/**
 * @author liyu
 * @date 2020/1/3 11:31
 * @description ��ŵ��
 */
public class TowersOfHanoi {
    public static void main(String[] args) {
        int i = towersOfHanoi(10, 'A', 'B', 'C', 0);
        System.out.println("i = " + i);
    }

    public static int towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg, int times) {
        //���ֻ��һ��Բ�̣�ֱ���ƶ���������һ
        if (n == 1) {
            times++;
            System.out.println("move disk from " + fromPeg + "\tto\t" + toPeg);
        } else {
            //����C����������A���������n-1��Բ���ƶ���C��
            times = towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg, times);
            //���µ�Բ�̴�A�ƶ���B
            System.out.println("move disk from " + fromPeg + "\tto\t" + toPeg);
            times++;
            //����A����������C���������n-1��Բ���ƶ���B��
            times = towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg, times);

        }
        return times;
    }

}
