package leetCode.array.simple;

public class GuessTheNumber {
//    СA �� СB ��������֡�СB ÿ�δ� 1, 2, 3 �����ѡ��һ����СA ÿ��Ҳ�� 1, 2, 3 ��ѡ��һ���¡�
//    ����һ���������������Ϸ���뷵�� СA �¶��˼��Σ�
//    �����guess����Ϊ СA ÿ�εĲ²⣬answer����Ϊ СB ÿ�ε�ѡ��guess��answer�ĳ��ȶ�����3��?
//
//    ʾ�� 1��
//    ���룺guess = [1,2,3], answer = [1,2,3]
//    �����3
//    ���ͣ�СA ÿ�ζ��¶��ˡ�

//    ʾ�� 2��
//    ���룺guess = [2,2,3], answer = [3,2,1]
//    �����1
//    ���ͣ�СA ֻ�¶��˵ڶ��Ρ�

    //    ���ƣ�
//    guess�ĳ��� = 3
//    answer�ĳ��� = 3
//    guess��Ԫ��ȡֵΪ {1, 2, 3} ֮һ��
//    answer��Ԫ��ȡֵΪ {1, 2, 3} ֮һ��

    public static void main(String[] args) {
        int[] guess = new int[]{2, 2, 3};
        int[] answer = new int[]{3, 2, 1};
        int i = game(guess, answer);
        System.out.println("i = " + i);
    }

    public static int game(int[] guess, int[] answer) {
        int times = 0;
        for (int i = 0; i < guess.length; i++) {

            if ((guess[i] ^ answer[i]) ==0) {
                times++;
            }
        }
        return times;
    }
}
