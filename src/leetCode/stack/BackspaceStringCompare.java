package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyu
 * date 2021/6/4 15:33
 * description �ȽϺ��˸���ַ���
 * ���� S �� T �����ַ����������Ƿֱ����뵽�հ׵��ı��༭�����ж϶����Ƿ���ȣ������ؽ���� # �����˸��ַ���
 * ע�⣺����Կ��ı������˸��ַ����ı�����Ϊ�ա�?
 * ʾ�� 1��
 * <p>
 * ���룺S = "ab#c", T = "ad#c"
 * �����true
 * ���ͣ�S �� T ������ ��ac����
 * ʾ�� 2��
 * <p>
 * ���룺S = "ab##", T = "c#d#"
 * �����true
 * ���ͣ�S �� T ������ ������
 * ʾ�� 3��
 * <p>
 * ���룺S = "a##c", T = "#a#c"
 * �����true
 * ���ͣ�S �� T ������ ��c����
 * ʾ�� 4��
 * <p>
 * ���룺S = "a#c", T = "b"
 * �����false
 * ���ͣ�S ���� ��c������ T ��Ȼ�� ��b����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/backspace-string-compare
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack = new LinkedList<>();
        Deque<Character> tStack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(t.charAt(i));
            }
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        return true;
    }

    public boolean backspaceCompare0(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
