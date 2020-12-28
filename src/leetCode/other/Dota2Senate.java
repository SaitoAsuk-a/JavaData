package leetCode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * date 2020/12/11 17:44
 * description Dota2 ����Ժ
 * Dota2 ����������������Ӫ��Radiant(���)��?Dire(ҹ��)
 * Dota2 ����Ժ���������ɵĲ���Ա��ɡ����ڲ���Ժϣ����һ�� Dota2 ��Ϸ��ĸı�����������
 * ������һ��������Ϊ���̵�ͶƱ���С���ÿһ���У�ÿһλ����Ա��������ʹ����Ȩ���е�һ�
 * ��ֹһ������Ա��Ȩ��������Ա��������һλ����Ա����һ�ֺ����ļ�����ɥʧ���е�Ȩ����
 * ����ʤ�����������Ա������Ȩ��ͶƱ�Ĳ���Ա����ͬһ����Ӫ�ģ�����������ʤ������������Ϸ�е��йر仯��?
 * ����һ���ַ�������ÿ������Ա����Ӫ����ĸ ��R�� �� ��D�� �ֱ������?Radiant����ԣ���?Dire��ҹ�ʣ���Ȼ������� n ������Ա�������ַ����Ĵ�С����?n��
 * ����Ϊ�����Ĺ��̴Ӹ���˳��ĵ�һ������Ա��ʼ�����һ������Ա��������һ���̽�������ͶƱ����������ʧȥȨ���Ĳ���Ա���ڹ����б�������
 * ����ÿһλ����Ա���㹻��������Ϊ�Լ�������������õĲ��ԣ�����ҪԤ����һ�����ջ�����ʤ������ Dota2 ��Ϸ�о����ı䡣���Ӧ����?Radiant?��?Dire��
 * ʾ�� 1��
 * ���룺"RD"
 * �����"Radiant"
 * ���ͣ���һ������Ա���� Radiant ��Ӫ����������ʹ�õ�һ��Ȩ���õڶ�������ԱʧȥȨ������˵ڶ�������Ա����������Ϊ��û���κ�Ȩ����Ȼ���ڵڶ��ֵ�ʱ�򣬵�һ������Ա��������ʤ������Ϊ����Ψһһ����ͶƱȨ����
 * ʾ�� 2��
 * ���룺"RDD"
 * �����"Dire"
 * ���ͣ�
 * ��һ����,��һ������ Radiant ��Ӫ�Ĳ���Ա����ʹ�õ�һ��Ȩ����ֹ�ڶ�������Ա��Ȩ��
 * �ڶ������� Dire ��Ӫ�Ĳ���Ա�ᱻ������Ϊ����Ȩ������ֹ
 * ���������� Dire ��Ӫ�Ĳ���Ա����ʹ�����ĵ�һ��Ȩ����ֹ��һ������Ա��Ȩ��
 * ����ڵڶ���ֻʣ�µ���������Աӵ��ͶƱ��Ȩ��,��������������ʤ��
 * ��ʾ��
 * <p>
 * �����ַ����ĳ����� [1, 10,000] ֮��.
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/dota2-senate
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Dota2Senate {
    public static void main(String[] args) {
        String rdd = predictPartyVictory("RDD");
        System.out.println("rdd = " + rdd);
    }
    public static String predictPartyVictory(String senate) {
        int length = senate.length();
        Queue<Integer> R = new LinkedList();
        Queue<Integer> D = new LinkedList();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                R.add(i);
            } else {
                D.add(i);
            }
        }
        while (!R.isEmpty() && !D.isEmpty()) {
            Integer r = R.poll();
            Integer d = D.poll();
            if (r < d) {
                R.add(r + length);
            } else {
                D.add(r + length);
            }

        }
        return R.isEmpty() ? "Dire" : "Radiant";
    }
}