package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/12 17:16
 * @description ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * ʾ�� 1:
 * ����: ["flower","flow","flight"]
 * ���: "fl"
 * ʾ�� 2:
 * ����: ["dog","racecar","car"]
 * ���: ""
 * ����: ���벻���ڹ���ǰ׺��
 * ˵��:
 * <p>
 * ��������ֻ����Сд��ĸ a-z
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
        String[] strs2={"dog","racecar","car"};
        System.out.println("longestCommonPrefix(strs2) = " + longestCommonPrefix(strs2));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String result=strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result)!=0){
                result=result.substring(0,result.length()-1);
                if (result.length()==0){
                    return "";
                }
            }
        }
        return result;

    }
}
