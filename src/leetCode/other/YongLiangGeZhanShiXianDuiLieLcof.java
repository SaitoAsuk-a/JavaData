package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.Stack;

/**
 * @author liyu
 * @date 2020/6/30 9:08
 * @description ������ջʵ�ֶ���
 * ������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ��
 * �ֱ�����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead?�������� -1 )
 * <p>
 * ʾ�� 1��
 * ���룺
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * �����[null,null,3,-1]
 * ʾ�� 2��
 * ���룺
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * �����[null,-1,null,null,5,2]
 * ��ʾ��
 * 1 <= values <= 10000
 * �����?appendTail��deleteHead ����?10000?�ε���
 * <p>
 * ��Դ��https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
@UtilityClass
public class YongLiangGeZhanShiXianDuiLieLcof {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        int i = cQueue.deleteHead();
        System.out.println("i = " + i);
        int j = cQueue.deleteHead();
        System.out.println("j = " + j);
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty() && stack1.isEmpty()) {
                return -1;
            } else if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
