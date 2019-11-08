package leetCode.array.simple;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2019/11/8 10:26
 * @description ����һ������ nums?��һ��ֵ val������Ҫԭ���Ƴ�������ֵ����?val?��Ԫ�أ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ�� 1:
 * ���� nums = [3,2,2,3], val = 3,
 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ��?2:
 * ���� nums = [0,1,2,2,3,0,4,2], val = 2,
 * ����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
 * ע�������Ԫ�ؿ�Ϊ����˳��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ˵��:
 * Ϊʲô������ֵ��������������Ĵ���������?
 * ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
 * ����������ڲ���������:
 * // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
 * int len = removeElement(nums, val);
 * // �ں������޸�����������ڵ������ǿɼ��ġ�
 * // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
 * for (int i = 0; i < len; i++) {
 * ? ? print(nums[i]);
 * }
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int i = removeElement(nums, val);
        System.out.println("i = " + i);
    }

    public static int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;

    }

    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
