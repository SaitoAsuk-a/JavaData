package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyu
 * date 2021/6/4 15:03
 * description ��Сջ
 * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 * push(x) ���� ��Ԫ�� x ����ջ�С�
 * pop()?���� ɾ��ջ����Ԫ�ء�
 * top()?���� ��ȡջ��Ԫ�ء�
 * getMin() ���� ����ջ�е���СԪ�ء�
 * ʾ��:
 *
 * ���룺
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * �����
 * [null,null,null,null,-3,null,0,-2]
 *
 * ���ͣ�
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.getMin();   --> ���� -2.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-stack
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
