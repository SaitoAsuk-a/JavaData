package algorithm.sort;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2021/6/9 14:43
 * description
 */
@UtilityClass
public class Search {

    public static void main(String[] args) {
        var a = new int[]{1, 3, 5, 6, 7, 8, 8, 8, 9, 15};
        int i = binarySearch2(a, a.length, 8);
        System.out.println("i = " + i);
    }

    /**
     * ���ֲ���
     *
     * @param a     ��С���������
     * @param n     ���鳤��
     * @param value �����ҵ�ֵ
     * @return
     */
    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * ���ֲ��ҵĵݹ�ʵ��
     *
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int binarySearch0(int[] a, int n, int val) {
        return binarySearchInternally(a, 0, n - 1, val);
    }

    public int binarySearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearchInternally(a, mid + 1, high, value);
        } else {
            return binarySearchInternally(a, low, mid - 1, value);
        }
    }


    /**
     * ���ֲ������еĵ�һ��ֵ
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binarySearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) return low;
        else return -1;

//        int low = 0;
//        int high = n - 1;
//        while (low <= high) {
//            int mid = low + ((high - low) >> 1);
//            if (a[mid] > value) {
//                high = mid - 1;
//            } else if (a[mid] < value) {
//                low = mid + 1;
//            } else {
//                if ((mid == 0) || (a[mid - 1] != value)) return mid;
//                else high = mid - 1;
//            }
//        }
//        return -1;
    }

    /**
     * �������һ��ֵ���ڸ���ֵ��Ԫ��
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binarySearch2(int[] a, int n, int value) {
//        int low = 0;
//        int high = n - 1;
//        while (low <= high) {
//            int mid = low + ((high - low) >> 1);
//            if (a[mid] > value) {
//                high = mid - 1;
//            } else if (a[mid] < value) {
//                low = mid + 1;
//            } else {
//                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
//                else low = mid + 1;
//            }
//        }
//        return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (high > 0 && a[high] == value) ? high : -1;
    }
}
