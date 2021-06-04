package leetCode.stack;

import java.util.*;

/**
 * @author liyu
 * date 2021/6/4 10:09
 * description ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("]");
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty()) {
                    if (s.charAt(i) == ')') {
                        if (stack.pop() != '(') {
                            return false;
                        }
                    } else if (s.charAt(i) == '}') {
                        if (stack.pop() != '{') {
                            return false;
                        }
                    } else {
                        if (stack.pop() != '[') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValid0(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
