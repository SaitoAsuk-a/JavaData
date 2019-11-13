package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/13 16:34
 * @description ��ת����
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 * ʾ�� 1:
 * ����: [1,2,3,4,5,6,7] �� k = 3
 * ���: [5,6,7,1,2,3,4]
 * ����:
 * ������ת 1 ��: [7,1,2,3,4,5,6]
 * ������ת 2 ��: [6,7,1,2,3,4,5]
 * ������ת 3 ��: [5,6,7,1,2,3,4]
 * ʾ�� 2:
 * ����: [-1,-100,3,99] �� k = 2
 * ���: [3,99,-1,-100]
 * ����:
 * ������ת 1 ��: [99,-1,-100,3]
 * ������ת 2 ��: [3,99,-1,-100]
 * ˵��:
 * �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
 * Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) �� ԭ�� �㷨��
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums,3);
    }

    public static void rotate(int[] nums, int k) {
        int temp1, temp2, index, count = 0;//countΪ������������¼�ƶ��ɹ��Ĵ�����temp1��temp2�Ǹ����洢������Ϊ����Ԫ��ֵ֮��
        int len = nums.length;
        k %= len;//��kֵ��ǰ�ڴ�������ԭ�������kֵ��len����ôֻ�д���len���ǲ��ֲ�����Ч�ƶ�
        if (k == 0)
            return;//���k����0����kԭ���ǵ���len�ģ���ô���൱��û���ƶ��ֱ�ӷ���
        for (int i = 0; i <= k; i++) //�ƶ����������k�Σ���Ȼ��������count=len��ʱ�������ѭ��
        {
            if (count >= len)
                break;//�Լ��������Ŀ��ƣ�������λ��ȫ���ƶ����˾Ϳ��Խ�����
            index = i;//ÿ���ƶ��ĳ�ʼ�±�
            temp1 = nums[i];
            while ((index + k) % len != i) //һ��whileѭ���ƶ�һ��
            {
                temp2 = nums[(index + k) % len];
                nums[(index + k) % len] = temp1;
                index = (index + k) % len;
                temp1 = temp2;
                count++;
            }
            nums[i] = temp1;
            count++;
        }

    }
}
