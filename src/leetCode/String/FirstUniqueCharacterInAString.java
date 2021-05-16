package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.HashMap;

/**
 * @author liyu
 * date 2020/12/23 9:25
 * description �ַ����еĵ�һ��Ψһ�ַ�
 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
 * ʾ����
 * <p>
 * s = "leetcode"
 * ���� 0
 * s = "loveleetcode"
 * ���� 2
 * ��ʾ������Լٶ����ַ���ֻ����Сд��ĸ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        int loveleetcode = firstUniqChar("loveleetcode");
        System.out.println("loveleetcode = " + loveleetcode);
    }
    public int firstUniqChar(String s) {
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i))== 1) {
                return i;
            }
        }
        return -1;
    }
}
