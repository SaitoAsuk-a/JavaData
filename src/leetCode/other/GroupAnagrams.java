package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * date 2020/12/14 9:24
 * description ��ĸ��λ�ʷ���
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * ʾ��:
 * <p>
 * ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * ˵����
 * ���������ΪСд��ĸ��
 * �����Ǵ������˳��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/group-anagrams
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(System.out::print);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, Integer> map = new HashMap();
        int length = strs.length;
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            String s = sortString(strs[i]);
            Integer index = map.get(s);
            if (index == null) {
                List<String> group = new ArrayList();
                group.add(strs[i]);
                result.add(group);
                map.put(s, result.size() - 1);
            } else {
                result.get(index).add(strs[i]);
            }

        }
        return result;
    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
