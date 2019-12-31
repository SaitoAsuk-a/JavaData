package algorithm.sort;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/12/30 15:14
 * @description ������ʮ�������㷨ʵ��
 */
public class Sort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 3, 7, 1, 2, 9, 8, 0, 4};
        System.out.println("����ǰarr=" + Arrays.toString(arr));
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        shellSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
//        heapSort(arr);
//        countSort(arr);
//        bucketSort(arr);
        radixSort(arr);
        System.out.println("�����arr=" + Arrays.toString(arr));

    }


    /**
     * ð������
     * ͨ�������Ҳ��Ͻ����������������Ԫ�أ���һ�ֵĽ���֮�󣬿�����δ�����Ԫ���ϸ����Ҳࡣ
     * ��һ��ѭ���У����û�з�����������˵�������Ѿ�������ģ���ʱ����ֱ���˳���
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }

    }

    /**
     * ѡ������
     * ѡ��������е���СԪ�أ�����������ĵ�һ��Ԫ�ؽ���λ�á��ٴ�ʣ�µ�Ԫ����ѡ�����С��Ԫ�أ�����������ĵڶ���Ԫ�ؽ���λ�á����Ͻ��������Ĳ�����ֱ����������������
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Ѱ��[i, n)���������Сֵ������
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * ��������
     * ������������ҽ��У�ÿ�ζ�����ǰԪ�ز��뵽����Ѿ�����������У�ʹ�ò���֮����������Ȼ����
     * �� j Ԫ����ͨ����������Ƚϲ�������ʵ�ֲ�����̣����� j Ԫ��С�ڵ� j - 1 Ԫ�أ��ͽ����ǵ�λ�ý�����Ȼ���� j ָ�������ƶ�һ��λ�ã����Ͻ������ϲ�����
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//
//            for (int j = i + 1; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }

        // �Ľ���������򣨼���������Ԫ�صĲ�������
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (e < arr[j - 1])
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = e;
        }
    }

    /**
     * ϣ������
     * ѡ��һ����������t1��t2������tk������ti>tj��tk=1��
     * ���������и���k�������н���k ������
     * ÿ�����򣬸��ݶ�Ӧ������ti�����������зָ�����ɳ���Ϊm �������У��ֱ�Ը��ӱ����ֱ�Ӳ������򡣽���������Ϊ1 ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        //ʵ��1
//        int step = 1;
//        while (step < arr.length) {
//            step = step * 3 + 1;
//        }
//
//        while (step > 0) {
//            for (int i = step; i < arr.length; i++) {
//                int j = i - step;
//                while (j >= 0 && arr[j + step] < arr[j]) {
//                    swap(arr, j + step, j);
//                    j -= step;
//                }
//
//            }
//            step = Math.floorDiv(step, 3);
//        }

        //ʵ��2
        int n = arr.length;
        for (int h = n / 2; h > 0; h = h / 2) {
            // �ڲ���һ����������
            for (int i = 0; i < n; i = i + h) {

                int e = arr[i];
                int j = i;
                for (; j > 0; j = j - h) {
                    if (e < arr[j - h]) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = e;
            }
        }

    }

    /**
     * �鲢����
     * �鲢�����������������Ѿ�����Ĳ��ֹ鲢��һ��
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

//        �Ե����Ϲ鲢����
//        int N = arr.length;
//        int[] aux = new int[N];
//        for (int sz = 1; sz < N; sz += sz)
//            for (int i = 0; i + sz < N; i += sz + sz)
//                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
    }

    /**
     * ��ָ����Χ��������й鲢����
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * ��arr[l...mid]��arr[mid+1...r]�����ֽ��й鲢
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // �����벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {  // ��벿����ָԪ�� < �Ұ벿����ָԪ��
                arr[k] = aux[i - l];
                i++;
            } else {  // ��벿����ָԪ�� >= �Ұ벿����ָԪ��
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    /**
     * ��������
     * ����������ԭ�����򣬲���Ҫ�������飬���ǵݹ������Ҫ����ջ��
     * ����������õ��������ÿ�ζ������ܽ�����԰�֣������ݹ���ô����������ٵġ���������±Ƚϴ���Ϊ CN=2CN/2+N�����Ӷ�Ϊ O(NlogN)��
     * �������£���һ�δ���С��Ԫ���з֣��ڶ��δӵڶ�С��Ԫ���з֣������㡣�������������Ҫ�Ƚ� N2/2��Ϊ�˷�ֹ�����ʼ��������ģ��ڽ��п�������ʱ��Ҫ����������顣
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * �ݹ�ʹ�ÿ�������,��arr[l...r]�ķ�Χ��������
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition2(arr, l, r);
//        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }


    /**
     * ������ͨ��p�ָ��������
     * ��arr[l...r]���ֽ���partition����
     * ����p, ʹ��arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
//        swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);  // ������һ�б�������������

        // �趨��׼ֵ��v��
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }


    /**
     * ˫·���������partition
     * ����p, ʹ��arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     * ���������к��д����ظ���Ԫ�أ���partition�ܿ��ܰ����黮�ֳ��������䲻ƽ��������֣�ʱ�临�Ӷ��˻���O(n?)����ʱ��Ӧ�ð�С��v�ʹ���v�����������ˡ�
     *
     * @param arr ��������
     * @param l   ��߽�
     * @param r   �ұ߽�
     * @return
     */
    private static int partition2(int[] arr, int l, int r) {

        // �����arr[l...r]�ķ�Χ��, ѡ��һ����ֵ��Ϊ�궨��pivot
        // swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);

        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // ע������ı߽�, arr[i].compareTo(v) < 0, ������arr[i].compareTo(v) <= 0
            // ˼��һ��Ϊʲô?
            while (i <= r && arr[i] < v)
                i++;

            // ע������ı߽�, arr[j].compareTo(v) > 0, ������arr[j].compareTo(v) >= 0
            // ˼��һ��Ϊʲô?
            while (j >= l + 1 && arr[j] > v)
                j--;

            // ��������������߽���趨, �е�ͬѧ�ڿγ̵��ʴ����кܺõĻش�:)
            // ��ҿ��Բο�: http://coding.imooc.com/learn/questiondetail/4920.html
            if (i > j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);

        return j;
    }

    /**
     * ��·��������
     * ����ֳ��������֣�����v ����v С��v
     * �ھ��д����ظ���ֵ�Ե������ʹ����·����
     * �ݹ�ʹ�ÿ�������,��arr[l...r]�ķ�Χ��������
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort3Ways(int[] arr, int l, int r) {

        // �����arr[l...r]�ķ�Χ��, ѡ��һ����ֵ��Ϊ�궨��pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

    /**
     * ������
     * ����һ���� H[0����n-1]��
     * �Ѷ��ף����ֵ���Ͷ�β������
     * �Ѷѵĳߴ���С 1�������� shift_down(0)��Ŀ���ǰ��µ����鶥�����ݵ�������Ӧλ�ã�
     * �ظ����� 2��ֱ���ѵĳߴ�Ϊ 1��
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        int len = arr.length;
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return;
    }

    /**
     * ��������
     *
     * @param arr
     * @param len
     */
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * �����ѽ��
     *
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    /**
     * ��������
     * ��O(n)��ʱ��ɨ��һ���������� A����ȡ��Сֵ min �����ֵ max
     * ����һ���µĿռ䴴���µ����� B������Ϊ ( max - min + 1)
     * ���� B �� index ��Ԫ�ؼ�¼��ֵ�� A ��ĳԪ�س��ֵĴ���
     * ������Ŀ���������У�������߼��Ǳ������� B�������ӦԪ���Լ���Ӧ�ĸ���
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
        int maxValue = getMaxValue(arr);
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }

    }

    /**
     * �������������ֵ
     *
     * @param arr
     * @return
     */
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * Ͱ����
     * ���ù̶������Ŀ�Ͱ��
     * �����ݷŵ���Ӧ��Ͱ�С�
     * ��ÿ����Ϊ�յ�Ͱ�����ݽ�������
     * ƴ�Ӳ�Ϊ�յ�Ͱ�����ݣ��õ����
     *
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        int bucketSize = 5;
        bucketSort(arr, bucketSize);
    }

    /**
     * Ͱ����
     * ָ��Ͱ��
     *
     * @param arr
     * @param bucketSize
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // ����ӳ�亯�������ݷ��䵽����Ͱ��
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // ��ÿ��Ͱ������������ʹ���˲�������
            insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return;
    }

    /**
     * �Զ����ݣ�����������
     *
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * ��������
     * �����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油��
     * �����λ��ʼ�����ν���һ������
     * �����λ����һֱ�����λ��������Ժ�, ���оͱ��һ����������
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int mod = 10;
        int dev = 1;
        int maxDigit = getMaxDigit(arr);

         for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // ���Ǹ����������������չһ�������������� [0-9]��Ӧ������[10-19]��Ӧ���� (bucket + 10)
            int[][] counter =  new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return;
    }

    /**
     * ��ȡ�������λ��
     *
     * @param arr
     * @return
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    /**
     * ��ȡ��ֵλ��
     *
     * @param num
     * @return
     */
    private static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    /**
     * ���������е�i��j
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
