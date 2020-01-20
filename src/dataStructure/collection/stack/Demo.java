package dataStructure.collection.stack;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liyu
 * @date 2020/1/17 16:29
 * @description
 */
@UtilityClass
public class Demo {
    public static void main(String[] args) {

        //����ջ�ķ�ת
//        testStackReverse();

//        int[] intPutArray=new int[]{6,1,3,5,3};
//        int[] ints = findingSpans(intPutArray);
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));


    }

    private static void testStackReverse() {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        integers.push(5);
        integers.forEach(System.out::println);
        reverseStack(integers);
        integers.forEach(System.out::println);
    }

    /**
     * ��תջ���ݹ���ʽ
     *
     * @param stack
     */
    public void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int data) {
        if (stack.empty()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    /**
     * ������
     * ��������A,A[i]�Ŀ��S[i]����Ϊ������A[j]<=A[j+1]����A[i]֮ǰ������Ԫ��A[j]��������
     * ������
     * O(n2)
     * O(1)
     *
     * @param intPutArray
     * @return
     */
    public int[] findingSpans(int[] intPutArray) {
        int[] spans = new int[intPutArray.length];
        for (int i = 0; i < intPutArray.length; i++) {
            int index = i - 1;
            int span = 1;
            while (index >= 0 && intPutArray[index] <= intPutArray[index + 1]) {
                span++;
                index--;
            }
            spans[i] = span;
        }
        return spans;
    }



}
