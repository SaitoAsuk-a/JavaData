package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * date 2020/12/16 9:26
 * description ���ʹ���
 * ����һ�ֹ��� pattern?��һ���ַ���?str?���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�
 * �����?��ѭ?ָ��ȫƥ�䣬���磬?pattern?���ÿ����ĸ���ַ���?str?�е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�
 * ʾ��1:
 * ����: pattern = "abba", str = "dog cat cat dog"
 * ���: true
 * ʾ�� 2:
 * ����:pattern = "abba", str = "dog cat cat fish"
 * ���: false
 * ʾ�� 3:
 * ����: pattern = "aaaa", str = "dog cat cat dog"
 * ���: false
 * ʾ��?4:
 * ����: pattern = "abba", str = "dog dog dog dog"
 * ���: false
 * ˵��:
 * ����Լ���?pattern?ֻ����Сд��ĸ��?str?�������ɵ����ո�ָ���Сд��ĸ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-pattern
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class WordPattern {

    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println("b = " + b);
        boolean a = wordPattern("abba", "dog cat cat fish");
        System.out.println("a = " + a);
        boolean c = wordPattern("abba", "dog dog dog dog");
        boolean d = wordPattern("aaa", "aa aa aa aa");
        System.out.println("d = " + d);
        System.out.println("c = " + c);
    }

    public boolean wordPattern(String pattern, String s) {
        int length = pattern.length();
        String[] str = s.trim().split(" ");
        if (str.length != length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>(length);
        Map<String, Character> map2 = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            String value = map1.get(pattern.charAt(i));
            if (value == null) {
                value = str[i];
                Character character = map2.get(value);
                if (character != null) {
                    return false;
                }
                map1.put(pattern.charAt(i), value);
                map2.put(value, pattern.charAt(i));
            } else {
                if (!value.equals(str[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
