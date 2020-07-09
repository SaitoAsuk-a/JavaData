package leetCode.array.general;


import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liyu
 * @date 2020/7/9 9:00
 * @description �ָ��ո�
 * Ŷ�������㲻С�İ�һ����ƪ�����еĿո񡢱�㶼ɾ���ˣ����Ҵ�дҲŪ����Сд��
 * �����"I reset the computer. It still didn��t boot!"�Ѿ������"iresetthecomputeritstilldidntboot"��
 * �ڴ�������źʹ�Сд֮ǰ������Ȱ����ϳɴ����Ȼ�ˣ�����һ�����Ĵʵ�dictionary����������Щ��û�ڴʵ��
 * ����������sentence��ʾ�����һ���㷨�������¶Ͽ���Ҫ��δʶ����ַ����٣�����δʶ����ַ�����
 * ע�⣺�������ԭ�������Ķ���ֻ�践��δʶ����ַ���
 * ʾ����
 * ���룺
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * ����� 7
 * ���ͣ� �Ͼ��Ϊ"jess looked just like tim her brother"����7��δʶ���ַ���
 * ��ʾ��
 * 0 <= len(sentence) <= 1000
 * dictionary�����ַ��������� 150000��
 * �������Ϊdictionary��sentence��ֻ����Сд��ĸ��
 * <p>
 * ��Դ��https://leetcode-cn.com/problems/re-space-lcci
 */
@UtilityClass
public class ReSpaceLcci {

    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public static void main(String[] args) {
        String sentence = "jesslookedjustliketimherbrother";
        String dictionary[] = {"looked", "just", "like", "her", "brother"};
        int respace = respace(dictionary, sentence);
        System.out.println("respace = " + respace);
    }

    /**
     * ���� dp[i] ��ʾ����ǰ i ���ַ����ٵ�δʶ����ַ���������ǰ������� dp ֵ��
     * ����ת�Ʒ��̣�ÿ��ת�Ƶ�ʱ�����ǿ��ǵ� j(j��i) ������ i ���ַ���ɵ��Ӵ� sentence[j?1?i?1]
     * ��ע���ַ����±�� 0 ��ʼ���Ƿ����ڴʵ����ҵ���������ҵ��Ļ����ն���ת�Ʒ��̼�Ϊ
     * dp[i]=min(dp[i],dp[j?1])
     * ����û���ҵ��Ļ����ǿ��Ը���dp[i?1] ��״̬�ټ��ϵ�ǰδ��ʶ��ĵ� i ���ַ�����˴�ʱ dp ֵΪ
     * dp[i]=dp[i?1]+1
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {

        int length = sentence.length();
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }
        int dp[] = new int[length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {

            //�����޷�ƥ��
            dp[i] = dp[i - 1] + 1;
            Trie cur = root;
            for (int j = i; j >= 1; j--) {

                int t = sentence.charAt(j - 1) - 'a';
                if (cur.next[t] == null) {
                    break;
                } else if (cur.next[t].endFlag) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                cur = cur.next[t];
            }

        }
        return dp[length];
    }

    /**
     * �ַ�����ϣ
     * Ԥ��֪ʶ �ַ�����ϣ���ɲο���1392. �����ǰ׺���ٷ�����еġ�����֪ʶ����
     * ˼·���㷨
     * ����ʹ���ֵ�����Ŀ���ǲ���ĳһ���� s �Ƿ���һ�����ļ��� S ���У����ҵ�����֪�� s �Ƿ��� S ��֮�󣬿��Կ��ٵ�֪���� s �����ĳһ���µ���ĸ�õ����´� s��
     * �Ƿ��� S �У����ת�ƵĹ����� O(1) �ġ��������ǲ����ֵ���������ʹ�� HashMap ��������һ�����ɣ���Щ��������ʵ�� s �� s'�� O(1) ת�ƣ����ֵ������ԡ�
     * ��ʵ����һ���ַ�����ϣ�ķ���Ҳ��ʵ�� O(1)��ת�ƣ����ǡ�Ԥ��֪ʶ�����ᵽ�� Rabin-Karp ���������������ַ����滻�ֵ�����ʱ�临�ӶȲ��䣬�ռ临�Ӷȿ����Ż��� O(n+q)��
     * ���� n Ϊ sentence ��Ԫ�صĸ�����q Ϊ�ʵ��е��ʵĸ�����
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace0(String[] dictionary, String sentence) {

        Set<Long> hashValues = new HashSet<Long>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    public long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }
}

/**
 * ���ֵ���
 */
class Trie {
    public Trie[] next;
    public boolean endFlag;

    public Trie() {
        this.next = new Trie[26];
        this.endFlag = false;
    }

    public void insert(String s) {

        Trie cur = this;
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = s.charAt(i) - 'a';
            if (cur.next[t] == null) {
                cur.next[t] = new Trie();
            }
            cur = cur.next[t];
        }
        cur.endFlag = true;
    }

}


